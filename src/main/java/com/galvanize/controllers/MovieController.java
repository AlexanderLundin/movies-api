package com.galvanize.controllers;

import com.galvanize.entities.Movie;
import com.galvanize.services.MovieService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/movies/imdbid/{imdbid}")
    public Movie getMovieByImbdid(@PathVariable(name="imdbid") String imdbid){
        return movieService.findByImdbId(imdbid);
    }

    @GetMapping("/movies/title/{title}")
    public List<Movie> getAllMoviesByTitle(@PathVariable(name="title") String title){
        return movieService.findAllByTitle(title);
    }
}
