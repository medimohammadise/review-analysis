package my.edu.um.fsktm.cra.amazonreviewcollector.serviceimpl;

import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.N1qlQueryResult;
import my.edu.um.fsktm.cra.amazonreviewcollector.domain.Review;
import my.edu.um.fsktm.cra.amazonreviewcollector.repository.N1qlCouchbaseRepository;
import my.edu.um.fsktm.cra.amazonreviewcollector.repository.ReviewRepository;
import my.edu.um.fsktm.cra.amazonreviewcollector.service.ReviewService;
import my.edu.um.fsktm.cra.amazonreviewcollector.service.messaging.NewReviewCollectedEvent;
import my.edu.um.fsktm.cra.amazonreviewcollector.service.messaging.ReviewEvent;
import my.edu.um.fsktm.cra.amazonreviewcollector.web.rest.dto.InterviewAnalyticsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ReviewServiceImpl implements ReviewService{
    Logger log=LoggerFactory.getLogger(getClass());
	private final ReviewRepository reviewRepository;
	private final AmazonReviewCollector amazonReviewCollector;
    private final MessageChannel channel;
    private final  N1qlCouchbaseRepository n1qlCouchbaseRepository;
	public ReviewServiceImpl(ReviewRepository reviewRepository,AmazonReviewCollector amazonReviewCollector,@Qualifier("newreview-grabChannel")MessageChannel channel,
                             N1qlCouchbaseRepository n1qlCouchbaseRepository) {
		this.reviewRepository=reviewRepository;
		this.amazonReviewCollector=amazonReviewCollector;
		this.channel=channel;
		this.n1qlCouchbaseRepository=n1qlCouchbaseRepository;
    }
	@Override
	public void extractAndsaveReview(String productId,String channelURL,LocalDateTime reviewStartDate) {
		List<Review> reviews= amazonReviewCollector.extractLatestReviews(channelURL,productId,reviewStartDate);

		reviews.forEach(c->{
				Review existingReview=null;
				try {
					String title=c.getTitle().replaceAll("\"", "\\\\\"f");
					c.setTitle(title);
				 existingReview=reviewRepository.findByTitleAndReviewDateAndCustomerProfileId(c.getTitle(),c.getReviewDate().toString(), c.getCustomerProfileId());
				}
				catch(Exception e)
				{
					System.out.println("Exception occured for "+ c.getTitle()+" "+ c.getReviewDate()+" "+ c.getCustomerProfileId());
					System.out.println(e.getMessage());
				}

				if (existingReview==null) reviewRepository.save(c);
            publishCollectedReview(c);

			});

        //sendReviewCollectedMessage(productId,reviews);



    }
    public void sendReviewCollectedMessage(String productId,List<Review> reviews){
	    log.info("number of reviews collected : "+reviews.stream().count() );
        if (reviews.stream().count()>0) {
            NewReviewCollectedEvent newReviewCollectedEvent = new NewReviewCollectedEvent();
            newReviewCollectedEvent.setProductId(productId);
            newReviewCollectedEvent.setEventDateTime(LocalDateTime.now());
            newReviewCollectedEvent.setNumberOfReviews(reviews.stream().count());
            //newReviewCollectedEvent.setNewReviewStartDateTime(reviews.stream().map(review -> review.getReviewDate()).max(LocalDateTime::compareTo).get());
            newReviewCollectedEvent.setNewReviewStartDateTime(LocalDateTime.now());
            Message<NewReviewCollectedEvent> message = MessageBuilder.withPayload(newReviewCollectedEvent)
                //.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .setHeader(KafkaHeaders.MESSAGE_KEY, newReviewCollectedEvent.getProductId().getBytes())
                .build();
            try {
                channel.send(message);
                log.info("message sent " + message);
            } catch (Exception ex) {
                log.error(ex.getMessage());
            }
        }
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

    @Override
    public void saveReview(ReviewEvent analysedReview) {
        Optional<Review> review=reviewRepository.findById(analysedReview.getReviewId());
        if (review.isPresent())
            review.get().setSentiment(analysedReview.getSentiment());
            reviewRepository.save(review.get());
    }

    public void deleteAll(){
        reviewRepository.deleteAll();
    }

    @Override
    public  List<InterviewAnalyticsDTO>  findAvarageSentimentByMonth() {
        List<InterviewAnalyticsDTO> jsonList=new ArrayList<>();
        N1qlQueryResult r5= n1qlCouchbaseRepository.getCouchbaseOperations().getCouchbaseBucket().query(N1qlQuery.simple("SELECT avg(sentiment) as sentiment,DATE_PART_STR(reviewDate,'year') as year,DATE_PART_STR(reviewDate,'month') as month \n" +
                "from review group by DATE_PART_STR(reviewDate,'year'),DATE_PART_STR(reviewDate,'month')\n" +
                "order by year,month") );
        System.out.println("return count --->"+r5.allRows().size());
        r5.allRows().stream().forEach(row->{
           if (!row.value().isEmpty() && row.value().get("sentiment")!=null)
            jsonList.add(new InterviewAnalyticsDTO(row.value().get("sentiment").toString(),row.value().get("year").toString(),row.value().get("month").toString()));

        });
        return jsonList;
    }
}
