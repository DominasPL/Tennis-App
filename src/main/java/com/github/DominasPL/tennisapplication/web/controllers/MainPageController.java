package com.github.DominasPL.tennisapplication.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MainPageController {

    @GetMapping
    public String displayMainPage() {

        return "index";
    }


}
