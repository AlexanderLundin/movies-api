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


    //CREATE


    @PostMapping("/movies")
    public Movie postMovie(@RequestBody Movie movie){
        return movieService.save(movie);
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

    @GetMapping("/movies/search/{actor}/{director}/{title}")
    public List<Movie> getAllMoviesByActorDirectorTitle(
            @PathVariable(required = false, name="actor") String actor,
            @PathVariable(required = false, name="director") String director,
            @PathVariable(name="title") String title
    ){
        return movieService.findAllByActorDirectorTitle(actor,director,title);
    }


    //UPDATE

    @PatchMapping("/movies/{movieid}")
    public Movie patchMovie(@PathVariable Long movieid, @RequestBody Movie movie){
        return movieService.update(movieid, movie);
    }


    //DELETE

    @DeleteMapping("/movies/{movieid}")
    public void deleteMovie(@PathVariable Long movieid){
        movieService.delete(movieid);
    }
}
