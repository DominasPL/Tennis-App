package com.github.DominasPL.tennisapplication.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditUserDTO {

    private String username;
    private String firstName;
    private String lastName;
    private String phoneNumber;

}
