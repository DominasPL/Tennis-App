package com.github.DominasPL.tennisapplication.services;

import com.github.DominasPL.tennisapplication.domain.model.Ranking;
import com.github.DominasPL.tennisapplication.domain.model.User;
import com.github.DominasPL.tennisapplication.domain.model.UserDetails;
import com.github.DominasPL.tennisapplication.domain.repositories.RankingRepository;
import com.github.DominasPL.tennisapplication.domain.repositories.UserRepository;
import com.github.DominasPL.tennisapplication.dtos.EditUserDTO;
import com.github.DominasPL.tennisapplication.dtos.RegistrationFormDTO;
import com.github.DominasPL.tennisapplication.dtos.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RankingRepository rankingRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RankingRepository rankingRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.rankingRepository = rankingRepository;
    }

    @Transactional
    public void registerUser(RegistrationFormDTO form) {
        User user = Converters.convertToUser(form);
        user.setPassword(passwordEncoder.encode((user.getPassword())));
        logger.info("Rejestracja użytjownika: " + user);
        userRepository.save(user);
        //Stworzenie pustego userDetails (tylko z id uzytkownika)
        UserDetails userDetails = new UserDetails();
        userDetails.setId(user.getId());
        user.setUserDetails(userDetails);
        //Stworzenie pustego rankingu dla danego uzytkownika. Ilosc pkt na start = 500
        Ranking ranking = new Ranking();
        ranking.setId(user.getId());
        ranking.setMatchesPlayed(0L);
        ranking.setWon(0L);
        ranking.setLost(0L);
        ranking.setWinPercentage(0.0);
        ranking.setPoints(500L);
        user.setRanking(ranking);
        userRepository.save(user);
        logger.info("Użytkownik zarejestrowany: " + user);

    }

    @Transactional
    public void editUser(EditUserDTO editUserDTO) {
        Optional<User> optionalUser = userRepository.findByUsername(editUserDTO.getUsername());
        User loadedUser = optionalUser.orElse(null);
        User user = Converters.convertToUser(loadedUser, editUserDTO);
        logger.info("Edycja uzytkownika: " + user);
        userRepository.save(user);
        logger.info("Użytkownik zedytowany: " + user);

    }


    public List<User> findAllUsers() {

        List<User> allUsers = userRepository.findAll();
        if (allUsers == null) {
            logger.debug("Nie znaleziono użytkowników.");
            return null;
        }

        logger.debug("Znaleziono rankingi użytkowników.");
        return allUsers;
    }

    public UserDTO findUserByUsername(String username) {
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

    public UserDTO findUserByEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Email musi być podany!");
        }

        Optional<User> optionalUser = userRepository.findByEmail(email);

        User user = optionalUser.orElse(null);
        if (user == null) {
            logger.debug("Nie znaleziono użytkownika dla nazwy email: " + email);
            return null;
        }

        logger.debug("Znaleziono użytkownika dla nazwy email: " + email);
        UserDTO userDTO = Converters.convertToUserDTO(user);
        return userDTO;
    }

}


