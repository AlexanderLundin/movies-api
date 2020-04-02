package com.galvanize.services;

import com.galvanize.entities.Movie;
import com.galvanize.repositories.MovieDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private MovieDao movieDao;

    public MovieService(MovieDao movieDao){
        this.movieDao = movieDao;
    }


    //CREATE


    public Movie save(Movie movie) {
        return movieDao.save(movie);
    }


    //READ


    public List<Movie> findAll() {
        return movieDao.findAll();
    }


    public Movie findByImdbId(String imdbId) {
        Movie movie = movieDao.findByImdbId(imdbId);
        return movie;
    }

    public List<Movie> findAllByTitle(String title) {
        return movieDao.findAllByTitle(title);
    }
}