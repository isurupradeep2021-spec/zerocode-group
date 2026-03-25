package lk.zerocode.transport_api.Transport_Api.repository;

import lk.zerocode.transport_api.Transport_Api.model.Review;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ReviewRepositary {
    List<Review> reviewList = new ArrayList<>();

    public void createReview(Review review){
        reviewList.add(review);
    }

    public List<Review> findAllReviews() {
        return reviewList;
    }

    public Review findReviewById(Long reviewId) {
        for (Review review : reviewList) {

            if (review.getId() == reviewId) {
                return review;
            }
        }
        return null;
    }
}
