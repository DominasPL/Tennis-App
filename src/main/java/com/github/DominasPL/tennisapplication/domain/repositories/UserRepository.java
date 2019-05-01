package com.github.DominasPL.tennisapplication.domain.repositories;


import com.github.DominasPL.tennisapplication.domain.model.Match;
import com.github.DominasPL.tennisapplication.domain.model.User;
import com.github.DominasPL.tennisapplication.dtos.UserWithRankingDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    @Query(value = "SELECT users.id, email, password, username FROM users JOIN ranking ON users.id = ranking.id ORDER BY points DESC LIMIT 50;", nativeQuery = true)
    List<User> findLastFifty();

}
