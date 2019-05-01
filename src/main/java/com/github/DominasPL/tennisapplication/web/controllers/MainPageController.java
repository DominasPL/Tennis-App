package com.github.DominasPL.tennisapplication.web.controllers;

import com.github.DominasPL.tennisapplication.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.applet.Main;

@Controller
@RequestMapping("/")
public class MainPageController {

    @GetMapping
    public String displayMainPage() {

        return "index";
    }


}
