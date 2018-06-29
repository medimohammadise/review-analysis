package my.edu.um.fsktm.cra.amazonreviewhousekeeper.serviceimpl;

import my.edu.um.fsktm.cra.amazonreviewhousekeeper.domain.ReviewCollectionHistory;
import my.edu.um.fsktm.cra.amazonreviewhousekeeper.service.ReviewHistoryService;
import org.springframework.stereotype.Service;

@Service
public class ReviewHistoryServiceImpl implements ReviewHistoryService {
    ReviewHistoryRepository reviewHistoryRepository;
    public ReviewHistoryServiceImpl(ReviewHistoryRepository reviewHistoryRepository){
        this.reviewHistoryRepository=reviewHistoryRepository;
    }
    @Override
    public ReviewCollectionHistory saveReviewHistory(ReviewCollectionHistory reviewHistory) {

        return reviewHistoryRepository.save(reviewHistory);
    }
}
