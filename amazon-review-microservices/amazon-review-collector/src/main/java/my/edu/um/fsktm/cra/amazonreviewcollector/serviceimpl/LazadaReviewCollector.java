package my.edu.um.fsktm.cra.amazonreviewcollector.serviceimpl;

import my.edu.um.fsktm.cra.amazonreviewcollector.domain.Review;
import my.edu.um.fsktm.cra.amazonreviewcollector.repository.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LazadaReviewCollector implements my.edu.um.fsktm.cra.amazonreviewcollector.service.LazadaReviewCollector {
    RestTemplate restTemplate;
    ReviewRepository reviewRepository;
    public LazadaReviewCollector(RestTemplate restTemplate, ReviewRepository reviewRepository){
        this.restTemplate=restTemplate;
        this.reviewRepository=reviewRepository;
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
                reviewList.add(new Review(productId, (item.get("buyerId") instanceof Long?Long.valueOf((Long)item.get("buyerId")).toString(): Integer.valueOf((Integer)item.get("buyerId")).toString())
                        , (String)item.get("reviewTitle"), (String)item.get("buyerName"), (String)item.get("reviewContent"), (String)item.get("reviewDate"), 0));
            });
            Map pagingInfo = (Map) lazadaResultMap.get("paging");
            totalPages = (int) pagingInfo.get("totalPages");
            PageNo++;
        }
        while (PageNo<totalPages);
        reviewList.forEach(reviewItem->{
                reviewRepository.save(reviewItem);
        });

        return reviewList;
    }
}
