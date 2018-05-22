package my.edu.um.fsktm.cra.amazonreviewcollector.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import my.edu.um.fsktm.cra.amazonreviewcollector.domain.Review;
import my.edu.um.fsktm.cra.amazonreviewcollector.repository.ReviewRepository;
import my.edu.um.fsktm.cra.amazonreviewcollector.service.ReviewService;


@Service
public class ReviewServiceImpl implements ReviewService{
	ReviewRepository reviewRepository;
	AmazonReviewCollector amazonReviewCollector;
	public ReviewServiceImpl(ReviewRepository reviewRepository,AmazonReviewCollector amazonReviewCollector) {
		this.reviewRepository=reviewRepository;
		this.amazonReviewCollector=amazonReviewCollector;
	}
	@Override
	public void saveReview(String productId) {
		List<Review> reviews= amazonReviewCollector.extractLatestReviews("https://www.amazon.com/product-reviews/",productId);
		
		reviews.forEach(c->{
				Review existingReview=null;
				try {
					String title=c.getTitle().replaceAll("\"", "\\\\\"f");
					c.setTitle(title);
				 existingReview=reviewRepository.findByTitleAndReviewDateAndCustomerProfileId(c.getTitle(),c.getReviewDate(), c.getCustomerProfileId());
				}
				catch(Exception e)
				{
					System.out.println("Exception occured for "+ c.getTitle()+" "+ c.getReviewDate()+" "+ c.getCustomerProfileId());
					System.out.println(e.getMessage());
				}
					
				if (existingReview==null) reviewRepository.save(c);
			
			});
		System.out.println(reviews.size()+" saved in the system ");
		
	}

}
