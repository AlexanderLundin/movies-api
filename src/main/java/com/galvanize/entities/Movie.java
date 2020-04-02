package com.galvanize.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

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
    @Column(name = "genre")
    @Enumerated
    Genre genre;

    public Movie() {
    }

    public Movie(String imdbid, String actors, String director, String title, String year, LocalDate released, Genre genre) {
        this.imdbid = imdbid;
        this.actors = actors;
        this.director = director;
        this.title = title;
        this.year = year;
        this.released = released;
        this.genre = genre;
    }

    public Movie(Long movieid, String imdbid, String actors, String director, String title, String year, LocalDate released, Genre genre) {
        this.movieid = movieid;
        this.imdbid = imdbid;
        this.actors = actors;
        this.director = director;
        this.title = title;
        this.year = year;
        this.released = released;
        this.genre = genre;
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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return Objects.equals(movieid, movie.movieid) &&
                Objects.equals(imdbid, movie.imdbid) &&
                Objects.equals(actors, movie.actors) &&
                Objects.equals(director, movie.director) &&
                Objects.equals(title, movie.title) &&
                Objects.equals(year, movie.year) &&
                Objects.equals(released, movie.released);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieid, imdbid, actors, director, title, year, released);
    }
}
