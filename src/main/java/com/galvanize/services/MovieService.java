package com.galvanize.services;

import com.galvanize.entities.Genre;
import com.galvanize.entities.Movie;
import com.galvanize.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }


    //CREATE


    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }


    //READ


    public List<Movie> findAll() {
        return movieRepository.findAll();
    }


    public Movie findByImdbId(String imdbId) {
        Movie movie = movieRepository.findByImdbId(imdbId);
        return movie;
    }

    public List<Movie> findAllByTitle(String title) {
        return movieRepository.findAllByTitle(title);
    }

    public List<Movie> findAllByActorDirectorTitle(String actor, String director, String title) {
        return movieRepository.findAllByActorDirectorTitle(actor, director, title);
    }


    //UPDATE


    public Movie update(Long movieid, Movie movie) {
        if(movieRepository.existsById(movieid)){
            return movieRepository.save(movie);
        }else {
            return null;
        }
    }


    //DELETE


    public void delete(Long movieid) {
        if(movieRepository.existsById(movieid)){
            movieRepository.deleteById(movieid);
        }
    }
}
