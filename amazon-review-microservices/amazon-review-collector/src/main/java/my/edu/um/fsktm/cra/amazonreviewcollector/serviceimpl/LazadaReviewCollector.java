package my.edu.um.fsktm.cra.amazonreviewcollector.serviceimpl;

import my.edu.um.fsktm.cra.amazonreviewcollector.enumeration.ECommerceChannel;
import my.edu.um.fsktm.cra.amazonreviewcollector.domain.Review;
import my.edu.um.fsktm.cra.amazonreviewcollector.repository.ReviewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LazadaReviewCollector implements my.edu.um.fsktm.cra.amazonreviewcollector.service.LazadaReviewCollector {
    RestTemplate restTemplate;
    ReviewRepository reviewRepository;
    private final MessageChannel channel;
    Logger log= LoggerFactory.getLogger(getClass());
    public LazadaReviewCollector(RestTemplate restTemplate, ReviewRepository reviewRepository,@Qualifier("newreview-grabChannel")MessageChannel channel){
        this.restTemplate=restTemplate;
        this.reviewRepository=reviewRepository;
        this.channel=channel;
    }
    @Override
    public List<Review> collectReviewForProduct(String productId) {
        List<Review> reviewList=new ArrayList<>();
        int PageNo=1;
        int totalPages=1;
        do {
            Map<String, Object> lazadaResultMap = restTemplate.getForObject("https://my.lazada.com.my/pdp/review/getReviewList?itemId=445081958&pageSize=5&filter=0&sort=0&pageNo=1", Map.class);
            lazadaResultMap = (Map) lazadaResultMap.get("model");
            ArrayList<Map> lazadareviewItems = (ArrayList<Map>) lazadaResultMap.get("items");
            lazadareviewItems.forEach(item -> {
                reviewList.add(new Review(ECommerceChannel.Lazada, productId, (item.get("buyerId") instanceof Long?Long.valueOf((Long)item.get("buyerId")).toString(): Integer.valueOf((Integer)item.get("buyerId")).toString())
                        , (String)item.get("reviewTitle"), (String)item.get("buyerName"), (String)item.get("reviewContent"), (String)item.get("reviewTime"), 0));
            });
            Map pagingInfo = (Map) lazadaResultMap.get("paging");
            totalPages = (int) pagingInfo.get("totalPages");
            PageNo++;
        }
        while (PageNo<totalPages);
        reviewList.forEach(reviewItem->{
                reviewRepository.save(reviewItem);
                publishCollectedReview(reviewItem);
        });

        return reviewList;
    }

    public void publishCollectedReview(Review review){
        Message<Review> message = MessageBuilder.withPayload(review)
                //.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .setHeader(KafkaHeaders.MESSAGE_KEY, review.getId().getBytes())
                .build();
        try {
            channel.send(message);
            log.info("message sent " + message);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }

    }

}
