package my.edu.um.fsktm.cra.productcatalog.serviceimpl.dto;

public class ProductDTO {
    private long id;
    private String productIdInChannel;
    private String prductSalesChannel;
    private String name;
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

    public String getChannelURL() {
        return channelURL;
    }

    public void setChannelURL(String channelURL) {
        this.channelURL = channelURL;
    }
}
