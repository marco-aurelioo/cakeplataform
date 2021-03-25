package com.cake.controller;

import com.cake.dto.NewUser;
import com.cake.dto.UserProfile;
import com.cake.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController extends BaseController {

    private UserService service;

    public ProfileController(UserService service){
        this.service = service;
    }


    @GetMapping("/user/{username}")
    public String getUser(Model model) {
        getLogedUser(model);
        return "user/profile";
    }

    @PostMapping("/user/{username}")
    public String updateUser(
            @ModelAttribute UserProfile update,
            Model model) {
        getLogedUser(model);
        service.updateUser(update);
        return "user/profile";
    }

}
