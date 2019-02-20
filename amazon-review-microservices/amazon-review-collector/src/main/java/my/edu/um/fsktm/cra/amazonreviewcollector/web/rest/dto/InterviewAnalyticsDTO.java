package my.edu.um.fsktm.cra.amazonreviewcollector.web.rest.dto;

import my.edu.um.fsktm.cra.amazonreviewcollector.enumeration.ECommerceChannel;

public class InterviewAnalyticsDTO {
    private ECommerceChannel channel;
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

    public InterviewAnalyticsDTO(ECommerceChannel channel,String seniment, String year, String month) {
        this.channel=channel;
        this.sentiment=seniment;
        this.year=year;
        this.month=month;
    }

    public ECommerceChannel getChannel() {
        return channel;
    }

    public void setChannel(ECommerceChannel channel) {
        this.channel = channel;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }
}
