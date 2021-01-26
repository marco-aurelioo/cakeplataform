package com.cake.controller;

import com.cake.entity.UserEntity;
import com.cake.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

public class BaseController {

    @Autowired
    private UserRepository userRepository;

    protected void getLogedUser(Model model) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        if(loggedInUser.getPrincipal() != null && loggedInUser.getPrincipal().toString().contains(":")) {
            String[] principalValues = loggedInUser.getPrincipal().toString().split(":");
            final UserEntity userLoged = userRepository
                    .findByProviderIdAndProviderUserId(principalValues[0], principalValues[1]);
            model.addAttribute("user",userLoged);
        }
    }

}
