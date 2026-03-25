package lk.zerocode.transport_api.Transport_Api.controller;

import lk.zerocode.transport_api.Transport_Api.Service.ReviewService;
import lk.zerocode.transport_api.Transport_Api.controller.request.ReviewRequest;
import lk.zerocode.transport_api.Transport_Api.controller.response.ReviewResponse;
import lk.zerocode.transport_api.Transport_Api.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/reviews")
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

//method 3


    @GetMapping("/review/{id}")
    public ReviewResponse reviewGetId(@PathVariable Long id){

       Review review = reviewService.getReviewById(id);
        ReviewResponse reviewResponse = new ReviewResponse();
        reviewResponse.setId(review.getId());
        reviewResponse.setDriverName(review.getDriverName());
        reviewResponse.setMessage(review.getMessage());
        return reviewResponse;


    }

//method 4
    @PutMapping("/review/{review-id}")
    public void reviewUpdate(@PathVariable("review-id") Long id, @RequestBody ReviewRequest reviewRequest){

        reviewService.updateReview(id, reviewRequest);


        System.out.println("Review updated");

    }







}
