package com.github.DominasPL.tennisapplication.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentMatchDTO {

    private LocalDateTime created;
    private String text;
    private Long match_id;
    private String createdBy;


}
