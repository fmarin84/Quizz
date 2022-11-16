package com.example.quizz.controller.Admin;

import com.example.quizz.UserDTO;
import com.example.quizz.entity.User;
import com.example.quizz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    UserService userService;

    @GetMapping("/user/registration")
    public String showRegistrationForm(Model model) {

        UserDTO userDto = new UserDTO();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @PostMapping("/user/registration")
    public String registerUserAccount(
            @ModelAttribute("user") @Valid UserDTO userDTO,
            BindingResult result) {

        if (!userDTO.getPassword().equals(userDTO.getConfirmParssword())){
            result.rejectValue("password", "error.user", "Les mots de passe doivent être identiques.");
            result.rejectValue("confirmParssword", "error.user", "Les mots de passe doivent être identiques.");
        }

        if(userService.findByEmail(userDTO.getEmail()).isPresent()){
            result.rejectValue("email", "error.user", "Ce compte existe déjà.");
        }

        if (result.hasErrors()) {
            return "registration";
        }
        else {
            userService.registerNewUserAccount(userDTO);
            return "registration-success";
        }
    }

    @GetMapping("/account")
    public String showMyInformation(Model model) {

        /* Authentication : Who is doing the request ? */
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Name: " + authentication.getName());
        System.out.println("authentication: " + authentication);
        System.out.println("principal: " + authentication.getPrincipal());

        model.addAttribute("principal", authentication.getPrincipal());
        model.addAttribute("user", userService.getUser(authentication.getName()));

        return "account";
    }
}