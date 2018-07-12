package com.edu.um.fsktm.cra.reviewtokenizer.web.rest;

import com.edu.um.fsktm.cra.reviewtokenizer.service.PosTaggerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/postagger")
public class PosTaggerResource {
    PosTaggerService posTaggerService;
    public PosTaggerResource (PosTaggerService posTaggerService){
        this.posTaggerService=posTaggerService;
    }
    @GetMapping()
    public List<String> findPOSTaggerInText(@RequestParam String input) {
        return posTaggerService.findPOSTaggerInText(input);

    }

}
