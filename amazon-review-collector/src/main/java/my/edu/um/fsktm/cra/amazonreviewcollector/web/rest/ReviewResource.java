package my.edu.um.fsktm.cra.amazonreviewcollector.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.edu.um.fsktm.cra.amazonreviewcollector.service.ReviewService;

@RestController
@RequestMapping("/api")
public class ReviewResource {
	ReviewService reviewService;
	public ReviewResource(ReviewService reviewService) {
		this.reviewService=reviewService;
	}
	 @GetMapping("/review")
	public void saveReview() {
		reviewService.saveReview("");
	}

}
