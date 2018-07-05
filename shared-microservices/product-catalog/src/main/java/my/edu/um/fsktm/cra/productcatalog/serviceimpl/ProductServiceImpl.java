package my.edu.um.fsktm.cra.productcatalog.serviceimpl;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.document.JsonLongDocument;
import com.couchbase.client.java.error.DocumentDoesNotExistException;
import my.edu.um.fsktm.cra.productcatalog.domain.Product;
import my.edu.um.fsktm.cra.productcatalog.repository.ProductRepository;
import my.edu.um.fsktm.cra.productcatalog.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Optional.*;

@Service
public class ProductServiceImpl implements ProductService {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository=productRepository;
    }


    @Override
    public Product saveProduct(Product product) {
        Product existingProduct=null;
        //Optional<Product> existingProductOpt=Optional.ofNullable(existingProduct);
        existingProduct= productRepository.findByProductIdInChannelAndPrductSalesChannel(product.getProductIdInChannel(),product.prductSalesChannel);
        if (existingProduct==null) {
            Long maxId = productRepository.findAll().stream().map(v -> v.getId()).mapToLong(v -> v).max().orElse(1);
            product.setId(maxId);
            return productRepository.save(product);
        }
        else
        {
            existingProduct.setName(product.getName());
            existingProduct.setPrductSalesChannel(product.getPrductSalesChannel());
            existingProduct.setProductIdInChannel(product.getPrductSalesChannel());
            return productRepository.save(existingProduct);
        }

    }
}
