package com.github.DominasPL.tennisapplication.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "matches")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    private String winner;
    @ManyToMany(mappedBy = "matches")
    private List<User> users = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "match_id")
    private List<Comment> comments;

    @PrePersist
    public void prePersist() {
        date = LocalDateTime.now();
    }

}
