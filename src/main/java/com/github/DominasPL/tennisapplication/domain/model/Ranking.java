package com.github.DominasPL.tennisapplication.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ranking")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ranking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long points;
    private Long matchesPlayed;
    private Long won;
    private Long lost;
    private Double winPercentage;

}
