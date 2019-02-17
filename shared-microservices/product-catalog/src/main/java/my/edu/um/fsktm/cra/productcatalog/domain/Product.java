package my.edu.um.fsktm.cra.productcatalog.domain;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

import javax.validation.constraints.NotNull;

public class Product {
    @Field
    @Id
    private long id;

    @NotNull(message = "productIdInChannel is missing")
    @Field
    private String productIdInChannel;
    @Field

    @NotNull(message = "prductSalesChannel is missing")
    private String prductSalesChannel;

    @NotNull(message = "name is missing")
    @Field
    private String name;

    @Field
    private boolean reviewCollectionActive=true;

    @NotNull(message = "channelURL is missing")
    @Field
    private String channelURL;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductIdInChannel() {
        return productIdInChannel;
    }

    public void setProductIdInChannel(String productIdInChannel) {
        this.productIdInChannel = productIdInChannel;
    }

    public String getPrductSalesChannel() {
        return prductSalesChannel;
    }

    public void setPrductSalesChannel(String prductSalesChannel) {
        this.prductSalesChannel = prductSalesChannel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isReviewCollectionActive() {
        return reviewCollectionActive;
    }

    public void setReviewCollectionActive(boolean reviewCollectionActive) {
        this.reviewCollectionActive = reviewCollectionActive;
    }

    public String getChannelURL() {
        return channelURL;
    }

    public void setChannelURL(String channelURL) {
        this.channelURL = channelURL;
    }
}
