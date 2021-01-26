package com.cake.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController extends BaseController{


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



}