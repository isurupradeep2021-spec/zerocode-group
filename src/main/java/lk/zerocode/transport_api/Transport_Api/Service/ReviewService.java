package lk.zerocode.transport_api.Transport_Api.Service;

import lk.zerocode.transport_api.Transport_Api.controller.request.ReviewRequest;
import lk.zerocode.transport_api.Transport_Api.controller.response.ReviewResponse;
import lk.zerocode.transport_api.Transport_Api.model.Review;

import java.util.List;

public interface ReviewService {

    void createReview(ReviewRequest reviewRequest);

    List<Review> getAllReview();




}
