package com.microservices.ratingdataservice.controller;

import com.microservices.ratingdataservice.beans.Rating;
import com.microservices.ratingdataservice.beans.UserRatings;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class RatingDataController {

    @GetMapping("ratingdata/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId,4);
    }

    @GetMapping("ratingdata/users/{userId}")
    public UserRatings getUserRatings(@PathVariable("userId") String userId){
        List<Rating> ratings = Arrays.asList(
                new Rating("111",4),
                new Rating("122",3)
        );
        UserRatings userRatings = new UserRatings();
        userRatings.setUserId(userId);
        userRatings.setUserRatings(ratings);
        return userRatings;
    }
}
