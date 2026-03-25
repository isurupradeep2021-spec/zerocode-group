package lk.zerocode.transport_api.Transport_Api.Service.Impl;

import lk.zerocode.transport_api.Transport_Api.Service.ReviewService;
import lk.zerocode.transport_api.Transport_Api.controller.request.ReviewRequest;
import lk.zerocode.transport_api.Transport_Api.controller.response.ReviewResponse;
import lk.zerocode.transport_api.Transport_Api.model.Review;
import lk.zerocode.transport_api.Transport_Api.repository.ReviewRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepositary reviewRepositary;

    @Override
    public void createReview(ReviewRequest reviewRequest) {

        Review review = new Review();

        review.setId(reviewRequest.getId());
        review.setDriverName(reviewRequest.getDriverName());
        review.setMessage(reviewRequest.getMessage());

        reviewRepositary.createReview(review);
    }


    @Override
    public List<Review> getAllReview() {


      return   reviewRepositary.findAllReviews();


    }

    @Override
    public Review getReviewById(Long id) {


      return   reviewRepositary.findReviewById( id);
    }
}
