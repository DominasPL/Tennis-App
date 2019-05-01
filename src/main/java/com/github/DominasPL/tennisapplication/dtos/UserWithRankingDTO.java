package com.github.DominasPL.tennisapplication.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWithRankingDTO {
    private String username;
    private Long points;
    private Long matchesPlayed;
    private Long won;
    private Long lost;
    private Double winPercentage;
}
