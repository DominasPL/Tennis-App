package com.github.DominasPL.tennisapplication.dtos;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationFormDTO {

    @NotNull @Size(min = 3, max = 20)
    private String username;
    @NotNull @Size(min = 3, max = 20)
    private String password;
    @NotNull @Size(min = 3, max = 20)
    private String confirmedPassword;
    @Email
    private String email;

}
