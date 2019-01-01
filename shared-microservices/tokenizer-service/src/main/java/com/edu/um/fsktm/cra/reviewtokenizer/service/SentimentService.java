package com.edu.um.fsktm.cra.reviewtokenizer.service;

import com.edu.um.fsktm.cra.reviewtokenizer.utils.PartOfSpeech;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.tokensregex.TokenSequenceMatcher;
import edu.stanford.nlp.ling.tokensregex.TokenSequencePattern;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;
import org.ejml.simple.SimpleMatrix;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
@Service
public class SentimentService {
    StanfordCoreNLP tokenizer;
    StanfordCoreNLP pipeline;
    public SentimentService(){
        Properties tokenizerproperties = new Properties();
        tokenizerproperties.put("annotators", "tokenize, ssplit, pos, lemma, ner, parse");
        this.tokenizer = new StanfordCoreNLP(tokenizerproperties);

        Properties pipelineProperties = new Properties();
        pipelineProperties.setProperty("ssplit.isOneSentence", "true");
        pipelineProperties.setProperty("annotators", "parse, sentiment");
        pipelineProperties.setProperty("enforceRequirements", "false");
        this.pipeline = new StanfordCoreNLP(pipelineProperties);

    }
    public List<String>  findPOSTaggerInText(String input) {
        //String input = "Great product. Is fast, colorful and beautiful design.";
        Annotation annotation = this.tokenizer.process(input);
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
        return output;
    }

    public double sentiment(String input) {
        HashMap<String,Object> response=new  HashMap<String,Object>();
        Annotation annotation = this.tokenizer.process(input);
        this.pipeline.annotate(annotation);

        List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);
        double sentiment = 0;
        int sentenceCount = annotation.get(CoreAnnotations.SentencesAnnotation.class).size();
        for( int j = 0; j < sentenceCount; j++ ) {
            CoreMap sentence = annotation.get(CoreAnnotations.SentencesAnnotation.class).get(j);
            Tree tree = sentence.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
            SimpleMatrix vector = RNNCoreAnnotations.getPredictions(tree);
            sentiment += (vector.get(1)*0.25+vector.get(2)*0.5+vector.get(3)*0.75+vector.get(4))/(double)sentenceCount;
        }
        return sentiment;

    }
}
