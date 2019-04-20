package com.github.DominasPL.tennisapplication.domain.repositories;

import com.github.DominasPL.tennisapplication.domain.model.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RankingRepository extends JpaRepository<Ranking, Long> {



}
