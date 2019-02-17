package my.edu.um.fsktm.cra.productcatalog.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.document.JsonLongDocument;
import com.couchbase.client.java.error.DocumentDoesNotExistException;
import my.edu.um.fsktm.cra.productcatalog.config.DatabaseConfiguration;
import my.edu.um.fsktm.cra.productcatalog.domain.Product;
import my.edu.um.fsktm.cra.productcatalog.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api")
public class ProductResource {
    private final ProductService productService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    Optional<JsonLongDocument>  productCounter;

    public ProductResource(ProductService productService,Optional<JsonLongDocument>  productCounter) {
        this.productService=productService;
    }
   /* @Bean
    public Optional<JsonLongDocument> productCounter(Bucket couchbaseBucket){
        try {
            return Optional.of(couchbaseBucket.counter("productCounter", 0,1));
        }
        catch (DocumentDoesNotExistException documentDoesNotExistException)
        {

             log.info("counter was not initialized because document does not exists yet");
        }
        return Optional.empty();
    }*/
    @PutMapping("product")
    @Timed
    public Product saveProduct(@RequestBody Product product){
       // product.setId( productCounter.get().content());
        return productService.saveProduct(product);
    }
}
