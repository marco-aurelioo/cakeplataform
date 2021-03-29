package com.cake.controller;

import com.cake.dto.UserProfile;
import com.cake.entity.UserEntity;
import com.cake.repository.UserRepository;
import com.cake.service.CrudUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;

public class BaseController {

    @Autowired
    private CrudUserService service;

    protected UserProfile getLogedUser(Model model) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        UserProfile user = null;
        if (loggedInUser.getPrincipal() != null &&
                loggedInUser.getPrincipal().toString().contains(":")) {
            if (loggedInUser.getPrincipal() instanceof UserDetails) {
                User userSec = (User) loggedInUser.getPrincipal();
                user = service.getUserProfile(userSec.getUsername());
            } else {
                String[] principalValues = loggedInUser.getPrincipal().toString().split(":");
                UserProfile userLoged =
                        service.findByProviderIdAndProviderUserId(principalValues[0], principalValues[1]);
                user = userLoged;
            }
        }
        if (user != null) {
            model.addAttribute("user", user);
        }
        return user;
    }

}
