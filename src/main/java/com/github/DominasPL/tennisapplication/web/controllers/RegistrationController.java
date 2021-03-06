package com.github.DominasPL.tennisapplication.web.controllers;

import com.github.DominasPL.tennisapplication.domain.repositories.UserRepository;
import com.github.DominasPL.tennisapplication.dtos.RegistrationFormDTO;
import com.github.DominasPL.tennisapplication.dtos.UserDTO;
import com.github.DominasPL.tennisapplication.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    private UserService userService;
    private UserRepository userRepository;

    public RegistrationController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String prepareRegistrationForm(Model model) {
        model.addAttribute("registrationForm", new RegistrationFormDTO());

        return "registration-page";
    }

    @PostMapping
    public String processRegistration(@Valid @ModelAttribute("registrationForm") RegistrationFormDTO form, BindingResult result) {
        if (result.hasErrors()) {
            return "registration-page";
        }

        if (!checkPasswordsEquality(form)) {
            result.rejectValue("password", null, "Hasło i powtórzone hasło niezgodne.");
            return "registration-page";
        }

        //na koncu bo łączymy się z baza danych w celu sprawdzenia czy uztkownik istnieje w bazie danych
        if (!checkIsUsernameAvailable(form)) {
            result.rejectValue("username",null, "Nazwa użytkownika już zajęta.");
            return "registration-page";
        }

        if (!checkIsEmailAvailable(form)) {
            result.rejectValue("email",null, "Email jest już zajęty.");
            return "registration-page";
        }

        userService.registerUser(form);
        return "redirect:/";

    }

    private boolean checkIsUsernameAvailable(RegistrationFormDTO form) {
        UserDTO user = userService.findUserByUsername(form.getUsername());
        if (user == null) {
            return true;
        }

        return false;
    }

    private boolean checkIsEmailAvailable(RegistrationFormDTO form) {
        UserDTO user = userService.findUserByEmail(form.getEmail());
        if (user == null) {
            return true;
        }

        return false;
    }


    private boolean checkPasswordsEquality(RegistrationFormDTO form) {

        return form.getPassword().equals(form.getConfirmedPassword());

    }

}
