package com.cake.controller;

import com.cake.dto.UserProfile;
import com.cake.entity.UserEntity;
import com.cake.repository.UserRepository;
import com.cake.service.CrudUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;

public class BaseController {

    @Autowired
    private CrudUserService service;

    protected boolean getLogedUser(Model model) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        if (loggedInUser.getPrincipal() != null && loggedInUser.getPrincipal().toString().contains(":")) {
            if (loggedInUser.getPrincipal() instanceof UserDetails) {
                model.addAttribute("user", loggedInUser.getPrincipal());
            } else {
                String[] principalValues = loggedInUser.getPrincipal().toString().split(":");
                UserProfile userLoged =
                        service.findByProviderIdAndProviderUserId(principalValues[0], principalValues[1]);
                model.addAttribute("user", userLoged);
            }
            return true;
        }
        return false;
    }

}
