package com.github.DominasPL.tennisapplication.domain.repositories;

import com.github.DominasPL.tennisapplication.domain.model.Comment;
import com.github.DominasPL.tennisapplication.dtos.CommentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT * FROM comments WHERE match_id = ?1 ORDER BY created DESC", nativeQuery = true)
    List<Comment> findByMatchId(Long id);


}
