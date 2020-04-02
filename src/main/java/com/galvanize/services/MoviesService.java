package com.galvanize.services;

import com.galvanize.entities.Movie;
import com.galvanize.repositories.MovieDao;
import org.springframework.stereotype.Service;

@Service
public class MoviesService {
    private MovieDao movieDao;

    public MoviesService(MovieDao movieDao){
        this.movieDao = movieDao;
    }
}
