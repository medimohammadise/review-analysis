package my.edu.um.fsktm.cra.amazonreviewcollector.service;

import my.edu.um.fsktm.cra.amazonreviewcollector.domain.Review;

import java.util.List;

public interface LazadaReviewCollector {

    List<Review> collectReviewForProduct(String productId);
}
