package com.microservices.moviecatalogservice.controller;

import com.microservices.moviecatalogservice.bean.CatalogItem;
import com.microservices.moviecatalogservice.bean.Movie;
import com.microservices.moviecatalogservice.bean.Rating;
import com.microservices.moviecatalogservice.bean.UserRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController

public class MovieCatalog {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("catalog/{userId}")
    public List<CatalogItem> getCatalogs(@PathVariable("userId") String userId){
        List<CatalogItem> catalogItems = new ArrayList<>();
        //RestTemplate  restTemplate = new RestTemplate(); //replaced with Autowired bean object


        // step1: get all rated movieIds,
        UserRatings userRatings = restTemplate.getForObject("http://rating-data-service/ratingdata/users/"+userId, UserRatings.class);

        // step2: for each movieId get description from movie-info service
        for(Rating rating:userRatings.getUserRatings()){
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
            catalogItems.add(new CatalogItem(movie.getMovieName(),movie.getDescription(),rating.getRating()));
        }

        return  catalogItems;

//        dummy api
//        return Collections.singletonList(
//                new CatalogItem("Transformer","Test",4.0f)
//        );
    }
}
