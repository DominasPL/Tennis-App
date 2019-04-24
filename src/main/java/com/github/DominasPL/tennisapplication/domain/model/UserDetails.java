package com.github.DominasPL.tennisapplication.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDetails {
    //TODO przeniesc walidacje do EditUserDTO
    @Id
    private Long id;
    @Size(max = 100)
    private String firstName;
    @Size(max = 100)
    private String lastName;
    @Pattern(regexp="(^$|[0-9]{9})")
    private String phoneNumber;

}
