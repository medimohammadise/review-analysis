package com.edu.um.fsktm.cra.reviewtokenizer.service;

import com.edu.um.fsktm.cra.reviewtokenizer.utils.PartOfSpeech;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.tokensregex.TokenSequenceMatcher;
import edu.stanford.nlp.ling.tokensregex.TokenSequencePattern;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
@Service
public class PosTaggerService {
    public List<String>  findPOSTaggerInText(String input) {
        Properties properties = new Properties();
        properties.put("annotators", "tokenize, ssplit, pos, lemma, ner, parse");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(properties);

        //String input = "Great product. Is fast, colorful and beautiful design.";
        Annotation annotation = pipeline.process(input);
        List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);
        List<String> output = new ArrayList<>();
        String regex = "([{pos:/NN|NNS|NNP|"+ PartOfSpeech.ADVERB+"|"+PartOfSpeech.ADJECTIVE+"/}])"; //Noun
        for (CoreMap sentence : sentences) {
            List<CoreLabel> tokens = sentence.get(CoreAnnotations.TokensAnnotation.class);
            TokenSequencePattern pattern = TokenSequencePattern.compile(regex);
            TokenSequenceMatcher matcher = pattern.getMatcher(tokens);
            while (matcher.find()) {
                output.add(matcher.group());
            }
        }
        System.out.println("Input: "+input);
        System.out.println("Output: "+output);
        return output;
    }
}
