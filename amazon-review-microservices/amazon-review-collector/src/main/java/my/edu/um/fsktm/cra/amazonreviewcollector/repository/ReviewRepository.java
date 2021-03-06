package my.edu.um.fsktm.cra.amazonreviewcollector.repository;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;

import my.edu.um.fsktm.cra.amazonreviewcollector.domain.Review;

import java.lang.String;
import java.time.LocalDate;
import java.util.List;
@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "review")
public interface ReviewRepository extends  N1qlCouchbaseRepository<Review,String> {
     Review findByTitleAndReviewDateAndCustomerProfileId(String title,LocalDate reviewDate,String customerProfileId);
}
