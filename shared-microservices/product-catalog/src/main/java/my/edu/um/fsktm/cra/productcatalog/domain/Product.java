package my.edu.um.fsktm.cra.productcatalog.domain;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

public class Product {
    @Field
    @Id
    public long id;
    @Field
    public String productIdInChannel;
    @Field
    public String prductSalesChannel;
    @Field
    public String name;

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
}
