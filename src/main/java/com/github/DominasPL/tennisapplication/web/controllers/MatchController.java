package com.github.DominasPL.tennisapplication.web.controllers;

import com.github.DominasPL.tennisapplication.domain.model.Ranking;
import com.github.DominasPL.tennisapplication.domain.model.User;
import com.github.DominasPL.tennisapplication.dtos.MatchDTO;
import com.github.DominasPL.tennisapplication.dtos.UserDTO;
import com.github.DominasPL.tennisapplication.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/new-match")
public class MatchController {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserService userService;
    private UserDTO randomUser;

    public MatchController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String newMatch(Model model, Principal principal) {
        List<MatchDTO> userMatches = userService.findUserMatches(principal.getName());

        model.addAttribute("loggedUser", principal.getName());
        model.addAttribute("userMatches", userMatches);
        return "new-match";
    }

    @GetMapping("/show-available-opponents")
    public String showOpponent(Principal principal, Model model) {

        List<UserDTO> availableOpponents = findAvailableOpponents(principal);
        model.addAttribute("opponents", availableOpponents);

        return "show-available-opponents";
    }

    @GetMapping("/show-available-opponents/new-opponent")
    public String drawOpponent(Model model, Principal principal) {

        drawOpponent(principal);

        model.addAttribute("randomOpponent", randomUser);

        return "new-opponent";
    }

    @GetMapping("/show-available-opponents/new-opponent/duel")
    public String duel(Model model, Principal principal) {
        UserDTO loggedUser = userService.findUserByUsername(principal.getName());
        List<UserDTO> loggedUserAndRandomUser = new ArrayList<>();
        loggedUserAndRandomUser.add(loggedUser);
        loggedUserAndRandomUser.add(randomUser);

        String winnerUsername = duel(loggedUserAndRandomUser);
        UserDTO winner = userService.findUserByUsername(winnerUsername);

        model.addAttribute("winner", winner);
        return "duel";
    }

    @ModelAttribute("users")
    public List<User> getUsers() {
        return userService.findAllUsers();
    }

    public List<UserDTO> findAvailableOpponents(Principal principal) {

        UserDTO user = userService.findUserByUsername(principal.getName());
        Long userPoints = userService.findUserPoints(user);
        List<Ranking> allRankings = userService.findAllRankings();
        List<UserDTO> opponents = new ArrayList<>();

        for (Ranking ranking: allRankings) {
            if (userService.findUserById(ranking.getId()).getUsername().equals(principal.getName())) {

            }
            else if (ranking.getPoints() <= userPoints + 200 && ranking.getPoints() >= userPoints - 200) {
                opponents.add(userService.findUserById(ranking.getId()));
            }
        }

        return opponents;
    }

    public void drawOpponent(Principal principal) {
        List<UserDTO> availableOpponents = findAvailableOpponents(principal);
        Random random = new Random();
        int index = random.nextInt(availableOpponents.size());
        randomUser = availableOpponents.get(index);
    }

    public String  duel(List<UserDTO> users) {
        String winner = userService.duel(users);
        return winner;
    }

}
