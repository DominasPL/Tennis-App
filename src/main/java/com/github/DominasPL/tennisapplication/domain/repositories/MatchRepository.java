package com.github.DominasPL.tennisapplication.domain.repositories;

import com.github.DominasPL.tennisapplication.domain.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MatchRepository extends JpaRepository<Match, Long> {

    @Query(value = "SELECT * FROM matches ORDER BY date DESC LIMIT 1", nativeQuery = true)
    Optional<Match> findFirstOrderByDateDesc();

    Optional<Match> findById(Long id);

    @Query(value = "SELECT * FROM matches ORDER BY date DESC LIMIT 50;", nativeQuery = true)
    List<Match> findLast50Matches();


}
