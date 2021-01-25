package com.cake.controller;

import com.cake.entity.UserEntity;
import com.cake.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class WelcomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String main(Model model) {
        getLogedUser(model);
        return "welcome";
    }

    @GetMapping("/index")
    public String home(Model model) {
        getLogedUser(model);
        return "welcome"; //view
    }

    private void getLogedUser(Model model) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        if(loggedInUser.getPrincipal() != null && loggedInUser.getPrincipal().toString().contains(":")) {
            String[] principalValues = loggedInUser.getPrincipal().toString().split(":");
            final UserEntity userLoged = userRepository
                .findByProviderIdAndProviderUserId(principalValues[0], principalValues[1]);
            model.addAttribute("user",userLoged);
        }
    }


}