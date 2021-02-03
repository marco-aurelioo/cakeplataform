package com.cake.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController extends BaseController {

    @GetMapping("/user/{username}")
    public String politica(Model model) {
        getLogedUser(model);
        return "user/profile";
    }
}
