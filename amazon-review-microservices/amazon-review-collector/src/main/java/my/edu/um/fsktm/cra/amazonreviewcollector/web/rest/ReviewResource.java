package my.edu.um.fsktm.cra.amazonreviewcollector.web.rest;

import com.couchbase.client.deps.com.fasterxml.jackson.databind.JsonNode;
import com.couchbase.client.java.document.json.JsonObject;
import my.edu.um.fsktm.cra.amazonreviewcollector.domain.Review;
import my.edu.um.fsktm.cra.amazonreviewcollector.enumeration.ECommerceChannel;
import my.edu.um.fsktm.cra.amazonreviewcollector.service.ReviewService;
import my.edu.um.fsktm.cra.amazonreviewcollector.web.rest.dto.InterviewAnalyticsDTO;
import org.springframework.web.bind.annotation.*;

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
    @DeleteMapping("/review")
    public void deletAll(){
        reviewService.deleteAll();
    }

    @GetMapping("/review/average/{channel}")
    public  List<InterviewAnalyticsDTO>  getAverageSentimentByMonth(@PathVariable List<ECommerceChannel> channel){
        System.out.println(channel);
        return reviewService.findAvarageSentimentByMonth(channel);
    }


}
