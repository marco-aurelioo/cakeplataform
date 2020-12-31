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
        return "welcome"; //view
    }

    @GetMapping("/home")
    public String home(Model model) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        if(loggedInUser.getPrincipal() != null && loggedInUser.getPrincipal().toString().contains(":")) {
            String[] principalValues = loggedInUser.getPrincipal().toString().split(":");
            final UserEntity userLoged = userRepository
                .findByProviderIdAndProviderUserId(principalValues[0], principalValues[1]);
            model.addAttribute("user",userLoged);
        }
        return "welcome"; //view
    }

    // /hello?name=kotlin
    @GetMapping("/hello")
    public String mainWithParam(
            @RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {

        model.addAttribute("message", name);

        return "welcome"; //view
    }

    @GetMapping("/login")
    public String loginPage(
       Model model) {

        return "login"; //view
    }

}