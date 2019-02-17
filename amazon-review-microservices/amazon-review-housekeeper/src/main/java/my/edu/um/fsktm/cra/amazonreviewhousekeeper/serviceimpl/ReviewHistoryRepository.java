package my.edu.um.fsktm.cra.amazonreviewhousekeeper.serviceimpl;

import my.edu.um.fsktm.cra.amazonreviewhousekeeper.domain.ReviewCollectionHistory;
import my.edu.um.fsktm.cra.amazonreviewhousekeeper.repository.N1qlCouchbaseRepository;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "review")
public interface ReviewHistoryRepository extends N1qlCouchbaseRepository<ReviewCollectionHistory,String> {

}
