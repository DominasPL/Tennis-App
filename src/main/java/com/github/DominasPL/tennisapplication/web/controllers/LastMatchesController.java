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

    @GetMapping
    public String showLastMatches(Model model) {

        List<Match2DTO> allMatches = userService.findLast50Matches();
        model.addAttribute("allMatches", allMatches);

        return "last-matches";

    }

    @GetMapping("/{match_id}")
    public String showComments(Model model, Principal principal, @PathVariable Long match_id) {

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
