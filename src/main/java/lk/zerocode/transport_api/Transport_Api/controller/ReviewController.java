package lk.zerocode.transport_api.Transport_Api.controller;

import lk.zerocode.transport_api.Transport_Api.Service.ReviewService;
import lk.zerocode.transport_api.Transport_Api.controller.request.ReviewRequest;
import lk.zerocode.transport_api.Transport_Api.controller.response.ReviewResponse;
import lk.zerocode.transport_api.Transport_Api.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

//method 1
    @PostMapping("/reviews")
    public void createReview(@RequestBody ReviewRequest reviewRequest){

        reviewService.createReview(reviewRequest);

    }

//method 2

    public  List<ReviewResponse> getAllReview() {

        List<Review> reviewList = reviewService.getAllReview();
        List<ReviewResponse> reviewResponseList = new ArrayList<ReviewResponse>();


        for (Review review : reviewList) {

            ReviewResponse reviewResponse = new ReviewResponse();
            reviewResponse.setId(review.getId());
            reviewResponse.setDriverName(review.getDriverName());
            reviewResponse.setMessage(review.getMessage());
            reviewResponseList.add(reviewResponse);

        }

        return reviewResponseList;
    }






}
