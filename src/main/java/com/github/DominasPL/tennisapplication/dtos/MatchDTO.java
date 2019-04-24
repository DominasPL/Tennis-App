package com.github.DominasPL.tennisapplication.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchDTO {

    private LocalDateTime date;
    private String winner;
    private String opponent;
}
