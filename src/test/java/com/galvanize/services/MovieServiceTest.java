package com.galvanize.services;

import com.galvanize.entities.Genre;
import com.galvanize.entities.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class MovieServiceTest {


    @Autowired
    private MovieService movieService;


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

    private List<Movie> movieListInDB = new ArrayList<>();;


    //CREATE


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
        movie1 = new Movie(movieid, imdbid, actors, director, title, year, released, Genre.ACTION);
        Movie actual1 = movieService.save(movie1);
        movieid = 2L;
        imdbid = "2";
        movie2 = new Movie(movieid, imdbid, actors, director, title, year, released, Genre.ROMANCE);
        Movie actual2 = movieService.save(movie2);
        movieListInDB.add(movie1);
        movieListInDB.add(movie2);
        assertNotNull(actual1);
        assertNotNull(actual2);
    }

    @Test
    public void testH2configuration_executesWithoutError() {
        //Setup
        System.out.println("test");
        //Exercise
    }


    //READ


    @Test
    public void findAll_movieDaoContainsMovies_returnsList() {
        //Setup
        //Exercise
        List<Movie> actual = movieService.findAll();
        //Assert
        assertEquals(movieListInDB.size(), actual.size());
        //Teardown
    }

    @Test
    public void findByImdbId_movieDaoContainsMovie_returnsMovie() {
        //Setup
        String imdbId = movie1.getImdbid();
        //Exercise
        Movie actual = movieService.findByImdbId(imdbId);
        //Assert
        assertEquals(movie1, actual);
        //Teardown
    }

    @Test
    public void findByImdbId_movieDaoDoesNotContainMovie_returnsNull() {
        //Setup
        String imdbId = "";
        //Exercise
        Movie actual = movieService.findByImdbId(imdbId);
        //Assert
        assertNull(actual);
        //Teardown
    }

    @Test
    public void findAllByTitle_movieDaoContainsMovies_returnsList() {
        //Setup
        String title = movie1.getTitle();
        //Exercise
        List<Movie> actual = movieService.findAllByTitle(title);
        //Assert
        assertEquals(movieListInDB.size(), actual.size());
        //Teardown
    }

    @Test
    public void findAllByActorDirectorGenreTitle_movieDaoContainsMovies_returnsList() {
        //Setup
        String actor = "actor1";
        director = movie1.getDirector();
        Genre genre = Genre.ROMANCE;
        title = movie1.getTitle();
        //Exercise
        List<Movie> actual = movieService.findAllByActorDirectorGenre(actor,director,genre,title);
        //Assert
        assertEquals(1, actual.size());
        //Teardown
    }

    @Test
    public void findAllByTitle2_movieDaoContainsMovies_returnsList() {
        //Setup
        String actor = null;
        director = null;
        Genre genre = null;
        title = movie1.getTitle();
        //Exercise
        List<Movie> actual = movieService.findAllByActorDirectorGenre(actor,director,genre,title);
        //Assert
        assertEquals(2, actual.size());
        //Teardown
    }
}