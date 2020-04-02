package com.galvanize.entities;

import java.time.LocalDate;

public class Movie {
    Long movieid;
    String imdbid;
    String actors;
    String director;
    String title;
    String year;
    LocalDate released;

    public Movie() {
    }

    public Movie(String imdbid, String actors, String director, String title, String year, LocalDate released) {
        this.imdbid = imdbid;
        this.actors = actors;
        this.director = director;
        this.title = title;
        this.year = year;
        this.released = released;
    }

}
