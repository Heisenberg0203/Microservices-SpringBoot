package com.microservices.moviecatalogservice.controller;

import com.microservices.moviecatalogservice.bean.CatalogItem;
import com.microservices.moviecatalogservice.bean.Movie;
import com.microservices.moviecatalogservice.bean.Rating;
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

    @GetMapping("catalog/{userId}")
    public List<CatalogItem> getCatalogs(@PathVariable("userId") String userId){

        // step1: get all rated movieIds,
        List<Rating> ratings = Arrays.asList(
                new Rating("111",4),
                new Rating("122",3)
        );

        // step2: for each movieId get description from movie-info service
        RestTemplate  restTemplate = new RestTemplate();
        List<CatalogItem> catalogItems = new ArrayList<>();

        for(Rating rating:ratings){
            Movie movie = restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(), Movie.class);
            catalogItems.add(new CatalogItem(movie.getMovieName(),movie.getDescription(),rating.getRating()));
        }

        return  catalogItems;

//        dummy api
//        return Collections.singletonList(
//                new CatalogItem("Transformer","Test",4.0f)
//        );
    }
}
