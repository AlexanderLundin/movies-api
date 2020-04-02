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


    private List<Movie> movieListInDB = new ArrayList<>();;


    //CREATE


    @BeforeEach
    public void save_validMovie_returnsMovie() {
        //Setup
        Movie movie;
        String actors = "actor1, actor2, actor3";
        String director = "director";
        String title = "title";
        String year = "2020";
        LocalDate released = LocalDate.now();
        Long movieid;
        String imdbid;
        for (long i = 1L; i < 6L ; i++) {
            movieid = i;
            imdbid = Long.toString(i);
            movie = new Movie(movieid, imdbid, actors, director, title, year, released, Genre.ACTION);
            movieService.save(movie);
            movieListInDB.add(movie);
        }
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
        String imdbId = movieListInDB.get(1).getImdbid();
        //Exercise
        Movie actual = movieService.findByImdbId(imdbId);
        //Assert
        assertEquals(movieListInDB.get(1).getImdbid(), actual.getImdbid());
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
        String title = movieListInDB.get(1).getTitle();
        //Exercise
        List<Movie> actual = movieService.findAllByTitle(title);
        //Assert
        assertEquals(movieListInDB.size(), actual.size());
        //Teardown
    }

    @Test
    public void findAllByActorDirectorGenreTitle_allParametersPresent_returnsList() {
        //Setup
        String actor = "actor1";
        String director = movieListInDB.get(1).getDirector();
        Genre genre = Genre.ROMANCE;
        String title = movieListInDB.get(1).getTitle();
        //Exercise
        List<Movie> actual = movieService.findAllByActorDirectorGenreTitle(actor,director,genre,title);
        //Assert
        assertEquals(0, actual.size());
        //Teardown
    }

    @Test
    public void findAllByActorDirectorGenreTitle_actorAndTitleParametersPresent_returnsList() {
        //Setup
        String actor = "actor1";
        String director = null;
        Genre genre = null;
        String title = movieListInDB.get(1).getTitle();
        //Exercise
        List<Movie> actual = movieService.findAllByActorDirectorGenreTitle(actor,director,genre,title);
        //Assert
        assertEquals(movieListInDB.size(), actual.size());
        //Teardown
    }

    @Test
    public void findAllByActorDirectorGenreTitle_directorAndTitleParametersPresent_returnsList() {
        //Setup
        String actor = null;
        String director = movieListInDB.get(1).getDirector();
        Genre genre = null;
        String title = movieListInDB.get(1).getTitle();
        //Exercise
        List<Movie> actual = movieService.findAllByActorDirectorGenreTitle(actor,director,genre,title);
        //Assert
        assertEquals(movieListInDB.size(), actual.size());
        //Teardown
    }

    @Test
    public void findAllByActorDirectorGenreTitle_titleParameterPresent_returnsList() {
        //Setup
        String actor = null;
        String director = null;
        Genre genre = null;
        String title = movieListInDB.get(1).getTitle();
        //Exercise
        List<Movie> actual = movieService.findAllByActorDirectorGenreTitle(actor,director,genre,title);
        //Assert
        assertEquals(movieListInDB.size(), actual.size());
        //Teardown
    }


    //UPDATE


    @Test
    public void update_movieDaoContainsMovies_returnsMovie() {
        //Setup
        Movie expected = new Movie();
        expected = movieService.save(expected);
        expected.setImdbid("888");
        //Exercise
        Movie actual = movieService.update(expected.getMovieid(), expected);
        //Assert
        assertEquals(expected.getMovieid(), actual.getMovieid());
        //Teardown
    }


    //DELETE


    @Test
    public void delete_movieDaoContainsMovies_returnsVoid() {
        //Setup
        Movie expected = new Movie();
        expected = movieService.save(expected);
        expected.setImdbid("454");
        //Exercise
        movieService.delete(expected.getMovieid());
        Movie actual = movieService.findByImdbId(expected.getImdbid());
        //Assert
        assertNull(actual);
    }
}