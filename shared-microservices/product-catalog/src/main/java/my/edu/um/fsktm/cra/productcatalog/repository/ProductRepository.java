package my.edu.um.fsktm.cra.productcatalog.repository;

import my.edu.um.fsktm.cra.productcatalog.domain.Product;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "product")
public interface ProductRepository extends  N1qlCouchbaseRepository<Product,Long> {
   Product findByProductIdInChannelAndPrductSalesChannel(String productIdInChannel,String prductSalesChannel);

}
