package com.github.DominasPL.tennisapplication.services;

import com.github.DominasPL.tennisapplication.domain.model.User;
import com.github.DominasPL.tennisapplication.domain.model.UserDetails;
import com.github.DominasPL.tennisapplication.domain.repositories.UserRepository;
import com.github.DominasPL.tennisapplication.dtos.EditUserDTO;
import com.github.DominasPL.tennisapplication.dtos.RegistrationFormDTO;
import com.github.DominasPL.tennisapplication.dtos.UserDTO;

public class Converters {

    private UserRepository userRepository;

    public Converters(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static User convertToUser(RegistrationFormDTO form) {
        User user = new User();
        user.setUsername(form.getUsername());
        user.setPassword(form.getPassword());
        user.setEmail(form.getEmail());
        return user;
    }

    public static User convertToUser(User user, EditUserDTO editUserDTO) {
        UserDetails userDetails = user.getUserDetails();
        userDetails.setFirstName(editUserDTO.getFirstName());
        userDetails.setLastName(editUserDTO.getLastName());
        userDetails.setPhoneNumber(editUserDTO.getPhoneNumber());
        return user;
    }


    public static UserDTO convertToUserDTO(User user) {
        UserDetails userDetails = user.getUserDetails();
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(userDetails.getFirstName());
        userDTO.setLastName(userDetails.getLastName());
        userDTO.setPhoneNumber(userDetails.getPhoneNumber());
        return userDTO;
    }



}
