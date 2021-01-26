package com.cake.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController extends  BaseController{

    @GetMapping("/login")
    public String loginPage(
            Model model) {
        getLogedUser(model);
        return "login"; //view
    }



}
