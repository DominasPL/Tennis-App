package com.github.DominasPL.tennisapplication.services;

import com.github.DominasPL.tennisapplication.domain.model.User;
import com.github.DominasPL.tennisapplication.domain.repositories.UserRepository;
import com.github.DominasPL.tennisapplication.dtos.RegistrationFormDTO;
import com.github.DominasPL.tennisapplication.dtos.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.login.Configuration;
import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void registerUser(RegistrationFormDTO form) {
        User user = Converters.convertToUser(form);

        logger.info("Rejestracja użytjownika: " + user);
        userRepository.save(user);
        logger.info("Użytkownika zarejestrowany: " + user);

    }

    public UserDTO findUser(String username) {
        if (username == null) {
            throw new IllegalArgumentException("Nazwa użytkownika musi być podana!");
        }

        Optional<User> optionalUser = userRepository.findByUsername(username);

        User user = optionalUser.orElse(null); // zwroci usera albo bedzie null
        if (user == null) {
            logger.debug("Nie znaleziono użytkownika dla nazwy: " + username);
            return null;
        }

        logger.debug("Znaleziono użytkownika dla nazwy: " + username);
        UserDTO userDTO = Converters.convertToUserDTO(user); // jezeli user jest to konwersja do user dto
        return userDTO;
    }


}


