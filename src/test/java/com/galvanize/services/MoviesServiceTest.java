package com.galvanize.services;

import com.galvanize.repositories.MovieDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class MoviesServiceTest {
    @Autowired
    private MoviesService moviesService;


    @Autowired
    private MovieDao movieDao;

    @Test
    public void testH2configuration() {
        //Setup
        System.out.println("test");
        //Exercise
    }
}