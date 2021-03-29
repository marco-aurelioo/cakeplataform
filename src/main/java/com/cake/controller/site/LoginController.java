package com.cake.controller.site;

import com.cake.controller.BaseController;
import com.cake.dto.UserProfile;
import com.cake.service.CrudUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController extends BaseController {

    @Autowired
    private CrudUserService crudUserService;

    @GetMapping("/login")
    public String loginPage(
            Model model) {
        UserProfile userProfile = getLogedUser(model);
        if(userProfile != null){
            return "user/profile";
        }
        model.addAttribute("user",new UserProfile());
        return "login"; //view
    }

    @GetMapping("/cadastro")
    public String cadastroPage(
            Model model) {
        UserProfile userProfile = getLogedUser(model);
        if(userProfile != null){
            return "user/profile";
        }
        model.addAttribute("user",new UserProfile());
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrarPage(@ModelAttribute UserProfile novo,
            Model model) {
        model.addAttribute("user",novo);
        crudUserService.criarUsuario(novo);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(novo, novo.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        getLogedUser(model);
        return "user/profile";
    }

}
