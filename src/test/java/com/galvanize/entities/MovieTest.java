package com.galvanize.entities;

import org.junit.jupiter.api.Test;

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
}