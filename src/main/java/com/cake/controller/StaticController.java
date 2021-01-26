package com.cake.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticController extends BaseController{


    @GetMapping("/politicas-do-site.html")
    public String politica(Model model) {
        getLogedUser(model);
        return "politica";
    }

    @GetMapping("/termos-de-uso.html")
    public String termos(Model model) {
        getLogedUser(model);
        return "termo";
    }

    @GetMapping("/sobre-o-site.html")
    public String sobre(Model model) {
        getLogedUser(model);
        return "sobre";
    }

}
