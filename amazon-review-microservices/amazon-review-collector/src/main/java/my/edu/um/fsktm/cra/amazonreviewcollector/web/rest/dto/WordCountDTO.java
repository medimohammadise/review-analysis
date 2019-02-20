package my.edu.um.fsktm.cra.amazonreviewcollector.web.rest.dto;

import io.swagger.models.auth.In;

public class WordCountDTO {
    private String text;
    private int weight;

    public WordCountDTO(String text, int weight) {
        this.text = text;
        this.weight = weight;
    }

    public String getText() {
        return text;
    }

    public void setText(String name) {
        this.text = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
