package com.galvanize.entities;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    public void defaultConstructor_returnsMovie() {
        //Setup
        //Exercise
        Movie movie = new Movie();
        //Assert
        assertNotNull(movie);
        //Teardown
    }

    @Test
    public void parameterConstructor_returnsMovie() {
        //Setup
        String imdbid = "1";
        String actors = "actor1, actor2, actor3";
        String director = "director";
        String title = "title";
        String year = "2020";
        Genre genre = Genre.ACTION;
        LocalDate released = LocalDate.now();
        //Exercise
        Movie movie = new Movie(imdbid, actors, director, title, year, released, genre);
        //Assert
        assertNotNull(movie);
        //Teardown
    }

    @Test
    public void settersAndGetters_returnsMovie() {
        //Setup
        Movie movie = new Movie();
        Long movieid = 1L;
        String imdbid = "1";
        String actors = "actor1, actor2, actor3";
        String director = "director";
        String title = "title";
        String year = "2020";
        Genre genre = Genre.ACTION;
        LocalDate released = LocalDate.now();
        //Exercise
        movie.setActors(actors);
        movie.setDirector(director);
        movie.setImdbid(imdbid);
        movie.setMovieid(movieid);
        movie.setTitle(title);
        movie.setYear(year);
        movie.setReleased(released);
        movie.setGenre(genre);
        //Assert
        assertEquals(actors, movie.getActors());
        assertEquals(director, movie.getDirector());
        assertEquals(imdbid, movie.getImdbid());
        assertEquals(movieid, movie.getMovieid());
        assertEquals(title, movie.getTitle());
        assertEquals(year, movie.getYear());
        assertEquals(released, movie.getReleased());
        assertEquals(genre, movie.getGenre());
        //Teardown
    }
}