package com.cake.controller;

import com.cake.dto.NewUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController extends  BaseController{

    @GetMapping("/login")
    public String loginPage(
            Model model) {
        getLogedUser(model);
        return "login"; //view
    }

    @GetMapping("/cadastro")
    public String cadastroPage(
            Model model) {
        getLogedUser(model);
        model.addAttribute("newuser",new NewUser());
        return "cadastro"; //view
    }

    @PostMapping("/cadastro")
    public String cadastrarPage(@ModelAttribute NewUser novo,
            Model model) {
        getLogedUser(model);
        model.addAttribute("newuser",novo);

        return "cadastro"; //view
    }
}
