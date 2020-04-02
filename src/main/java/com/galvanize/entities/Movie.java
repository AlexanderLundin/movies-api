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
    public Long getMovieid() {
        return movieid;
    }

    public void setMovieid(Long movieid) {
        this.movieid = movieid;
    }

    public String getImdbid() {
        return imdbid;
    }

    public void setImdbid(String imdbid) {
        this.imdbid = imdbid;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public LocalDate getReleased() {
        return released;
    }

    public void setReleased(LocalDate released) {
        this.released = released;
    }
}
