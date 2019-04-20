package com.github.DominasPL.tennisapplication.web.controllers;

import com.github.DominasPL.tennisapplication.domain.model.Ranking;
import com.github.DominasPL.tennisapplication.domain.model.User;
import com.github.DominasPL.tennisapplication.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ranking")
public class RankingController {

    private UserService userService;

    public RankingController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String displayUsersRanking() {

        return "ranking";
    }

    @ModelAttribute("users")
    public List<User> getUsers() {
        return userService.findAllUsers();
    }


}
