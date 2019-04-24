package com.github.DominasPL.tennisapplication.dtos;

import com.github.DominasPL.tennisapplication.domain.model.UserDetails;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String username;
    private String email;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private Long points;
    private Double winPercentage;
}
