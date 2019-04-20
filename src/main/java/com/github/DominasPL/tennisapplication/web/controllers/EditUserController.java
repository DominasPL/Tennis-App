package com.github.DominasPL.tennisapplication.web.controllers;

import com.github.DominasPL.tennisapplication.domain.model.UserDetails;
import com.github.DominasPL.tennisapplication.dtos.EditUserDTO;
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
@RequestMapping("/edit")
public class EditUserController {

    public static final Logger logger = LoggerFactory.getLogger(EditUserController.class);

    private UserService userService;

    public EditUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String editUserDetails(Model model, Principal principal) {
        UserDTO userDTO = userService.findUserByUsername(principal.getName());
        logger.info(userDTO.toString());
        EditUserDTO editUserDTO = new EditUserDTO();
        editUserDTO.setUsername(userDTO.getUsername());
        editUserDTO.setFirstName(userDTO.getFirstName());
        editUserDTO.setLastName(userDTO.getLastName());
        editUserDTO.setPhoneNumber(userDTO.getPhoneNumber());
        model.addAttribute("user", editUserDTO);
        return "edit-user-details";
    }

    @PostMapping
    public String editUserDetailsPost(@Valid @ModelAttribute("user") EditUserDTO editUserDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "edit-user-details";
        }

        userService.editUser(editUserDTO);

        return "redirect:/";
    }
//
//    public boolean checkIsPhoneNumberAvailable(UserDTO userDTO) {
//        UserDetails userDetails = findUserDetailsByPhoneNumber();
//        if (userDetails == null) {
//            return true;
//        }
//
//        return false;
//    }
//

}
