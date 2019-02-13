package my.edu.um.fsktm.cra.amazonreviewcollector.repository;

import com.couchbase.client.deps.com.fasterxml.jackson.databind.JsonNode;
import my.edu.um.fsktm.cra.amazonreviewcollector.web.rest.dto.InterviewAnalyticsDTO;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * Couchbase specific {@link org.springframework.data.repository.Repository} interface uses N1QL for all requests
 */
@NoRepositoryBean
public interface N1qlCouchbaseRepository<T, ID extends Serializable> extends CouchbasePagingAndSortingRepository<T, ID> {

    @Query("#{#n1ql.selectEntity} WHERE #{#n1ql.filter}")
    List<T> findAll();

    @Query("SELECT count(*) FROM #{#n1ql.bucket} WHERE #{#n1ql.filter}")
    long count();

    @Query("DELETE FROM #{#n1ql.bucket} WHERE #{#n1ql.filter}")
    T removeAll();


    default void deleteAll() {
        removeAll();
    }

}


