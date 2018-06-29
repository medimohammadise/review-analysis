package my.edu.um.fsktm.cra.amazonreviewcollector.service;

import java.time.LocalDate;

public interface ReviewService {
    public void saveReview(String productId, LocalDate reviewStartDate);
}
