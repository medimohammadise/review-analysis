package my.edu.um.fsktm.cra.amazonreviewcollector.web.rest;

import my.edu.um.fsktm.cra.amazonreviewcollector.service.LazadaReviewCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LazadaReviewResource {
    LazadaReviewCollector lazadaReviewCollector;
    public LazadaReviewResource(LazadaReviewCollector lazadaReviewCollector){
        this.lazadaReviewCollector=lazadaReviewCollector;
    }

    @GetMapping("/review/lazada")
    public void getAverageSentimentByMonth(){
          lazadaReviewCollector.collectReviewForProduct("445081958");
    }

}
