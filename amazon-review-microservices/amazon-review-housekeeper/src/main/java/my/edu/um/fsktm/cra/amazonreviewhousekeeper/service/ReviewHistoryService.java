package my.edu.um.fsktm.cra.amazonreviewhousekeeper.service;

import my.edu.um.fsktm.cra.amazonreviewhousekeeper.domain.ReviewCollectionHistory;

public interface ReviewHistoryService {
    public ReviewCollectionHistory saveReviewHistory(ReviewCollectionHistory reviewHistory);
}
