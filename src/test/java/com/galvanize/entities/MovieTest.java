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
        LocalDate released = LocalDate.now();
        //Exercise
        Movie movie = new Movie(imdbid, actors, director, title, year, released);
        //Assert
        assertNotNull(movie);
        //Teardown
    }
}