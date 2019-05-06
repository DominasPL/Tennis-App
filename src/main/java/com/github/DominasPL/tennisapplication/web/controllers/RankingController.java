package com.github.DominasPL.tennisapplication.web.controllers;

import com.github.DominasPL.tennisapplication.domain.model.Ranking;
import com.github.DominasPL.tennisapplication.domain.model.User;
import com.github.DominasPL.tennisapplication.dtos.UserWithRankingDTO;
import com.github.DominasPL.tennisapplication.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/ranking")
public class RankingController {

    private static final Logger logger = LoggerFactory.getLogger(RankingController.class);


    private UserService userService;

    public RankingController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{page}")
    public String displayUsersRanking(@PathVariable Long page, Model model) {
        List<UserWithRankingDTO> allUsersSorted = userService.findLast50UsersSorted();

        if (page == 1) {
            List<UserWithRankingDTO> first25 = allUsersSorted.subList(0, 25);
            for (UserWithRankingDTO user: first25) {
                logger.info(user.toString());
            }
            model.addAttribute("users", first25);
        } else if (page == 2) {
            List<UserWithRankingDTO> last25 = allUsersSorted.subList(25, 50);
            model.addAttribute("users", last25);
        } else {
            return "index";
        }

        model.addAttribute("page", page);

        return "ranking";
    }

}
