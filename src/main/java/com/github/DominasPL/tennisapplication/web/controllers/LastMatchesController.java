package com.github.DominasPL.tennisapplication.web.controllers;

import com.github.DominasPL.tennisapplication.domain.model.Comment;
import com.github.DominasPL.tennisapplication.domain.model.Match;
import com.github.DominasPL.tennisapplication.dtos.CommentDTO;
import com.github.DominasPL.tennisapplication.dtos.Match2DTO;
import com.github.DominasPL.tennisapplication.dtos.MatchDTO;
import com.github.DominasPL.tennisapplication.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        //TODO nie pobierac wszystkich meczów z bazy. Zrobić limit do 50 ostatnich spotkań.
        List<Match2DTO> allMatches = userService.findAllMatches();
        model.addAttribute("allMatches", allMatches);

        return "last-matches";

    }

    @GetMapping("/comments")
    public String showComments(Model model, @RequestParam Long id, @RequestParam String player1, @RequestParam String player2, @RequestParam String date, @RequestParam String winner) {

        List<CommentDTO> allCommentsByMatchId = userService.findAllCommentsByMatchId(id);
        Comment comment = new Comment();
        model.addAttribute("comment", comment);

        model.addAttribute("comments", allCommentsByMatchId);
        model.addAttribute("player1", player1);
        model.addAttribute("player2", player2);
        model.addAttribute("date", date);
        model.addAttribute("winner", winner);
        model.addAttribute("match_id", id);
        return "comments";

    }

    @PostMapping("/comments")
    public String addComment(@ModelAttribute Comment comment, @RequestParam Long id) {

        userService.saveComment(id, comment);

        return "redirect:/last-matches";
    }


}
