package com.github.DominasPL.tennisapplication.web.controllers;

import com.github.DominasPL.tennisapplication.dtos.*;
import com.github.DominasPL.tennisapplication.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/last-matches")
public class LastMatchesController {

    private static final Logger logger = LoggerFactory.getLogger(LastMatchesController.class);


    private UserService userService;

    public LastMatchesController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{page}")
    public String showLastMatches(Model model, @PathVariable Long page) {

        List<Match2DTO> allMatches = userService.findLast50Matches();

        if (page == 1) {
            List<Match2DTO> first25Matches = allMatches.subList(0, 25);
            model.addAttribute("matches", first25Matches);
        } else if (page == 2) {
            List<Match2DTO> last25Matches = allMatches.subList(25, 50);
            model.addAttribute("matches", last25Matches);
        } else {
            return "index";
        }

        model.addAttribute("page", page);

        return "last-matches";

    }

    @GetMapping("/{page}/{match_id}")
    public String showComments(Model model, Principal principal, @PathVariable Long page, @PathVariable Long match_id) {

        List<CommentDTO> allCommentsByMatchId = userService.findAllCommentsByMatchId(match_id);
        CommentMatchDTO commentMatchDTO = new CommentMatchDTO();
        Match2DTO matchById = userService.findMatchById(match_id);

        model.addAttribute("comments", allCommentsByMatchId);
        model.addAttribute("commentMatchDTO", commentMatchDTO);
        model.addAttribute("match", matchById);
        model.addAttribute("loggedUser", principal.getName());
        return "comments";

    }

    @PostMapping("/add-comment")
    public String addComment(@ModelAttribute CommentMatchDTO commentMatchDTO) {

        userService.saveComment(commentMatchDTO);

        return "redirect:/last-matches/"+commentMatchDTO.getMatch_id();
    }


}
