package my.edu.um.fsktm.cra.amazonreviewcollector.repository;

import my.edu.um.fsktm.cra.amazonreviewcollector.web.rest.dto.InterviewAnalyticsDTO;
import org.joda.time.DateTime;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.core.query.ViewIndexed;

import my.edu.um.fsktm.cra.amazonreviewcollector.domain.Review;

import java.lang.String;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "review")
public interface ReviewRepository extends  N1qlCouchbaseRepository<Review,String> {
     Review findByTitleAndReviewDateAndCustomerProfileId(String title, String reviewDate, String customerProfileId);




}
