package com.galvanize.services;

import com.galvanize.entities.Movie;
import com.galvanize.repositories.MovieDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class MovieServiceTest {
    @Autowired
    private MovieService movieService;


    @Autowired
    private MovieDao movieDao;

    private Long movieid;
    private String imdbid = "1";
    private String actors = "actor1, actor2, actor3";
    private String director = "director";
    private String title = "title";
    private String year = "2020";
    private LocalDate released = LocalDate.now();

    private Movie movie1;
    private Movie movie2;
    private Movie movie3;
    private Movie movie4;
    private Movie movie5;
    private Movie movie6;

    @BeforeEach
    public void save_validMovie_returnsMovie() {
        //Setup
        movieid = 1L;
        imdbid = "1";
        actors = "actor1, actor2, actor3";
        director = "director";
        title = "title";
        year = "2020";
        LocalDate released = LocalDate.now();
        movie1 = new Movie(movieid, imdbid, actors, director, title, year, released);
        Movie actual1 = movieService.save(movie1);
        assertTrue(actual1.equals(movie1));
    }
    @Test
    public void testH2configuration() {
        //Setup
        System.out.println("test");
        //Exercise
    }
}