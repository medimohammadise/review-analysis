package com.edu.um.fsktm.cra.reviewtokenizer.web.rest;

import com.edu.um.fsktm.cra.reviewtokenizer.service.PosTaggerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/nlp")
public class PosTaggerResource {
    PosTaggerService posTaggerService;
    public PosTaggerResource (PosTaggerService posTaggerService){
        this.posTaggerService=posTaggerService;
    }
    @GetMapping("/postagger")
    public List<String> findPOSTaggerInText(@RequestParam String input) {
        return posTaggerService.findPOSTaggerInText(input);

    }

    @GetMapping("/sentiment")
    public Double getSentiment(@RequestParam String input) {
        return posTaggerService.sentiment(input);

    }

}
