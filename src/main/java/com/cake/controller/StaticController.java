package com.cake.controller;

import com.cake.entity.UserEntity;
import com.cake.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/politicas-do-site.html")
    public String politica(Model model) {
        return "politica";
    }

    @GetMapping("/termos-de-uso.html")
    public String termos(Model model) {
        return "termo";
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
