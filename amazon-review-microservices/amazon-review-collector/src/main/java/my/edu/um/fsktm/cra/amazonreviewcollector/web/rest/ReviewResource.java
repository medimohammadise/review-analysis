package my.edu.um.fsktm.cra.amazonreviewcollector.web.rest;

import my.edu.um.fsktm.cra.amazonreviewcollector.domain.Review;
import my.edu.um.fsktm.cra.amazonreviewcollector.service.ReviewService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewResource {
    ReviewService reviewService;
    public ReviewResource(ReviewService reviewService){
        this.reviewService=reviewService;

    }
    @PostMapping("/review-event")
    public void generateEvent(){
        Review review=new Review("1","1","testTitle","testAuthor","This is a test message", LocalDate.now());
        reviewService.publishCollectedReview(review);
    }
}
