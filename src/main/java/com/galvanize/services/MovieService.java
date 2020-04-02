package com.galvanize.services;

import com.galvanize.entities.Genre;
import com.galvanize.entities.Movie;
import com.galvanize.repositories.MovieDao;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Movie> findAllByActorDirectorGenreTitle(String actor, String director, Genre genre, String title) {
        return movieDao.findAllByActorDirectorGenreTitle(actor, director, genre, title);
    }


    //UPDATE


    public Movie update(Long movieid, Movie movie) {
        if(movieDao.existsById(movieid)){
            return movieDao.save(movie);
        }else {
            return null;
        }
    }


    //DELETE


    public void delete(Long movieid) {
        if(movieDao.existsById(movieid)){
            movieDao.deleteById(movieid);
        }
    }
}
