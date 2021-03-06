package com.galvanize.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.entities.Genre;
import com.galvanize.entities.Movie;
import com.galvanize.services.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@ActiveProfiles("test")
class MovieControllerTest {

    @Autowired
    MockMvc mvc;


    @Autowired
    private MovieService movieService;


    @Autowired
    ObjectMapper objectMapper;

    private List<Movie> movieListInDB = new ArrayList<>();

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

    public List<Movie> mapResultActionsToMovieList (ResultActions resultActions) throws UnsupportedEncodingException, JsonProcessingException {
        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        List<Movie> movieList = Arrays.asList(objectMapper.readValue(contentAsString, Movie[].class));
        return movieList;
    }

    public Movie mapResultActionsToMovie (ResultActions resultActions) throws UnsupportedEncodingException, JsonProcessingException {
        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        //objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        Movie movie = objectMapper.readValue(contentAsString, Movie.class);
        return movie;
    }


    //CREATE


    @Test
    public void postMovie_daoWithoutThisMovieExisting_returnsMovie() throws Exception {
        //Setup
        String url = "/api/movies";
        Movie expected = new Movie();
        //Exercise
        ResultActions resultActions = mvc.perform(post(url)
                .content(objectMapper.writeValueAsString(expected))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
        )
                .andExpect(status().isOk());
        Movie actual = mapResultActionsToMovie(resultActions);
        //Assert
        assertNotNull(actual);
        //Teardown
        movieService.delete(actual.getMovieid());
    }

    //READ


    @Test
    public void getAllMovies_movieRepositoryWithMovies_returnsList() throws Exception {
        //Setup
        String url = "/api/movies";
        List<Movie> expected = movieListInDB;
        //Exercise
        ResultActions resultActions = mvc.perform(get(url));
        List<Movie> actual = mapResultActionsToMovieList(resultActions);
        //Assert
        assertEquals(expected.size(), actual.size());
        //Teardown
    }

    @Test
    public void getMovieByImbdid_movieRepositoryWithMovies_returnsList() throws Exception {
        //Setup
        Movie expected = movieListInDB.get(1);
        String url = "/api/movies/imdbid/" + expected.getImdbid();
        //Exercise
        ResultActions resultActions = mvc.perform(get(url));
        Movie actual = mapResultActionsToMovie(resultActions);
        //Assert
        assertNotNull(actual.equals(expected));
        //Teardown
    }

    @Test
    public void getAllMoviesByTitle_movieRepositoryWithMovies_returnsList() throws Exception {
        //Setup
        List<Movie> expected = movieListInDB;
        Movie movie = movieListInDB.get(1);
        String title = movie.getTitle();
        String url = "/api/movies/title/" + title;
        //Exercise
        ResultActions resultActions = mvc.perform(get(url));
        List<Movie> actual = mapResultActionsToMovieList(resultActions);
        //Assert
        assertEquals(expected.size(), actual.size());
        //Teardown
    }

    @Test
    public void getAllMoviesBySearch_movieRepositoryWithMovies_returnsList() throws Exception {
        //Setup
        List<Movie> expected = movieListInDB;
        Movie movie = movieListInDB.get(1);
        String actor = null;
        String director = null;
        String title = movie.getTitle();
        String url = "/api/movies/search/" + actor + "/" + director + "/" + title;
        //Exercise
        ResultActions resultActions = mvc.perform(get(url));
        //Assert
        //Teardown
    }


    //UPDATE

    @Test
    public void patchMovie_daoWithThisMovieExisting_returnsMovie() throws Exception {
        //Setup
        Movie movie = movieListInDB.get(1);
        String url = "/api/movies/" + movie.getMovieid();
        Movie expected = new Movie();
        //Exercise
        ResultActions resultActions = mvc.perform(patch(url)
                .content(objectMapper.writeValueAsString(expected))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
        )
                .andExpect(status().isOk());
        //Assert
        //Teardown
    }


    //DELETE


    @Test
    public void deleteMovie_daoWithThisMovieExisting_returnsMovie() throws Exception {
        //Setup
        Movie movie = new Movie();
        movie = movieService.save(movie);
        String url = "/api/movies/" + movie.getMovieid();
        //Exercise
        ResultActions resultActions = mvc.perform(delete(url))
                .andExpect(status().isOk());
        Movie actual = movieService.findByImdbId(movie.getImdbid());
        //Assert
        assertNull(actual);
        //Teardown
    }
}