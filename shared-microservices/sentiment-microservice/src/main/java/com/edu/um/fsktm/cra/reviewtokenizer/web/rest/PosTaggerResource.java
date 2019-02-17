package com.edu.um.fsktm.cra.reviewtokenizer.web.rest;

import com.edu.um.fsktm.cra.reviewtokenizer.service.SentimentMessagePublisherService;
import com.edu.um.fsktm.cra.reviewtokenizer.service.SentimentService;
import com.edu.um.fsktm.cra.reviewtokenizer.web.rest.dto.Review;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/nlp")
public class PosTaggerResource {
    SentimentService sentimentService;
    SentimentMessagePublisherService sentimentMessagePublisherService;
    public PosTaggerResource (SentimentService sentimentService,
                              SentimentMessagePublisherService sentimentMessagePublisherService
    ){
        this.sentimentService = sentimentService;
        this.sentimentMessagePublisherService=sentimentMessagePublisherService;
    }
    @GetMapping("/postagger")
    public List<String> findPOSTaggerInText(@RequestParam String input) {
        return sentimentService.findPOSTaggerInText(input);

    }

    @GetMapping("/sentiment")
    public Double getSentiment(@RequestParam String input) {
        return sentimentService.sentiment(input);

    }

    @GetMapping("/test-sentiment-message")
    public void testSentimentMessage(@RequestParam String input) {
        Review review=new Review();
        review.setId(1l);
        review.setProductId("1");
        review.setSentiment(4);
        sentimentMessagePublisherService.sendMessage(review);

    }

}
