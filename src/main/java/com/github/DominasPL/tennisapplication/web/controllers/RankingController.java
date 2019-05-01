package com.github.DominasPL.tennisapplication.web.controllers;

import com.github.DominasPL.tennisapplication.domain.model.Ranking;
import com.github.DominasPL.tennisapplication.domain.model.User;
import com.github.DominasPL.tennisapplication.dtos.UserWithRankingDTO;
import com.github.DominasPL.tennisapplication.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
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
    public List<UserWithRankingDTO> getUsers() {

        List<UserWithRankingDTO> allUsersSorted = userService.findLast50UsersSorted();

        return allUsersSorted;
    }


}
