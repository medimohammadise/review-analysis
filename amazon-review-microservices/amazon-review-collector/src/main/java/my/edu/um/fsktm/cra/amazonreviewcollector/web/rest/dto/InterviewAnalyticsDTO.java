package my.edu.um.fsktm.cra.amazonreviewcollector.web.rest.dto;

public class InterviewAnalyticsDTO {
    private String sentiment;
    private String year;
    private String month;
    public InterviewAnalyticsDTO(){

    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public InterviewAnalyticsDTO(String seniment, String year, String month) {
        this.sentiment=seniment;
        this.year=year;
        this.month=month;

    }



    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }
}
