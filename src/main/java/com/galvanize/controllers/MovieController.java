package com.galvanize.controllers;

import com.galvanize.entities.Movie;
import com.galvanize.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    //READ


    @GetMapping("/movies")
    public List<Movie> getAllMovies(){
        return movieService.findAll();
    }
}
