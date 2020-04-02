package com.galvanize.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long movieid;
    @Column(name = "imdbid")
    String imdbid;
    @Column(name = "actors")
    String actors;
    @Column(name = "director")
    String director;
    @Column(name = "title")
    String title;
    @Column(name = "year")
    String year;
    @Column(name = "released")
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
