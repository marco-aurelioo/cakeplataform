package com.cake.controller;

import com.cake.dto.NewUser;
import com.cake.service.CrudUserService;
import com.cake.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController extends  BaseController{

    @Autowired
    private CrudUserService crudUserService;

    @GetMapping("/login")
    public String loginPage(
            Model model) {
        getLogedUser(model);
        return "login"; //view
    }

    @GetMapping("/cadastro")
    public String cadastroPage(
            Model model) {
        if(getLogedUser(model)){
            return "user/profile";
        }
        model.addAttribute("newuser",new NewUser());
        return "cadastro"; //view
    }

    @PostMapping("/cadastro")
    public String cadastrarPage(@ModelAttribute NewUser novo,
            Model model) {
        model.addAttribute("newuser",novo);
        crudUserService.criarUsuario(novo);
        return "cadastro"; //view
    }
}
