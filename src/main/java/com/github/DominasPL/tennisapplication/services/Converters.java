package com.github.DominasPL.tennisapplication.services;

import com.github.DominasPL.tennisapplication.domain.model.*;
import com.github.DominasPL.tennisapplication.domain.repositories.UserRepository;
import com.github.DominasPL.tennisapplication.dtos.*;

import java.util.ArrayList;
import java.util.List;

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
        Ranking ranking = user.getRanking();
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(userDetails.getFirstName());
        userDTO.setLastName(userDetails.getLastName());
        userDTO.setPhoneNumber(userDetails.getPhoneNumber());
        userDTO.setPoints(ranking.getPoints());
        userDTO.setWinPercentage(ranking.getWinPercentage());
        return userDTO;
    }


    public static List<MatchDTO> convertToMatchDTO(User user) {
        List<Match> matches = user.getMatches();
        List<MatchDTO> matchesDTO = new ArrayList<>();
        for (Match match: matches) {
            MatchDTO matchDTO = new MatchDTO();
            matchDTO.setDate(match.getDate());
            matchDTO.setWinner(match.getWinner());
            List<User> users = match.getUsers();
            for (User user1: users) {
                if (!user1.getUsername().equals(user.getUsername())) {
                    matchDTO.setOpponent(user1.getUsername());
                }
            }
            matchesDTO.add(matchDTO);
        }

        return matchesDTO;
    }

    public static List<Match2DTO> convertToMatch2DTO(List<Match> allMatches) {
        List<Match2DTO> matches = new ArrayList<>();
        for (Match match: allMatches) {
            Match2DTO match2DTO = new Match2DTO();
            match2DTO.setId(match.getId());
            match2DTO.setDate(match.getDate());
            match2DTO.setWinner(match.getWinner());
            List<User> users = match.getUsers();
            int index = 0;
            for (User user : users) {
                if (index == 0) {
                    match2DTO.setPlayer1(user.getUsername());
                    index++;
                } else {
                    match2DTO.setPlayer2(user.getUsername());
                }
            }
            matches.add(match2DTO);
        }

        return matches;
    }

    public static List<CommentDTO> convertToCommentDTO(List<Comment> allCommentsByMatchId) {
        List<CommentDTO> comments = new ArrayList<>();
        for (Comment comment: allCommentsByMatchId) {
            CommentDTO commentDTO = new CommentDTO();
            commentDTO.setCreated(comment.getCreated());
            commentDTO.setText(comment.getText());
            comments.add(commentDTO);
        }

        return comments;
    }
}
