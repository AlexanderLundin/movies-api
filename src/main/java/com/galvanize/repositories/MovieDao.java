package com.galvanize.repositories;

import com.galvanize.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieDao extends JpaRepository <Movie, Long> {

    @Query(value = "SELECT * FROM movies m where m.imdbId = ?1",
            nativeQuery=true
    )
    Movie findByImdbId(String imdbId);

    @Query(value = "SELECT * FROM movies m WHERE m.title = ?1", nativeQuery=true)
    List<Movie> findAllByTitle(String title);
}
