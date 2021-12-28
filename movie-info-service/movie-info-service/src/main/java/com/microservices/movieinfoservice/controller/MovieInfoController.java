package com.microservices.movieinfoservice.controller;

import com.microservices.movieinfoservice.beans.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieInfoController {

    @GetMapping("movies/{movieId}")
    public Movie getMovie(@PathVariable("movieId") String movieId){
        return new Movie(movieId,"TestMovieName","description");
    }
}
