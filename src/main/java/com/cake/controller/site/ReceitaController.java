package com.cake.controller.site;

import com.cake.controller.BaseController;
import com.cake.dto.UserProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReceitaController extends BaseController {

    @GetMapping("/c")
    public String receia(
            Model model) {
        UserProfile userProfile = getLogedUser(model);
        return "receitas/listas"; //view
    }

    @GetMapping("/receitas/minhas")
    public String minhas(
            Model model) {
        UserProfile userProfile = getLogedUser(model);
        if(userProfile == null){
            return "cadastro";
        }
        return "receitas/minhas";
    }

    @GetMapping("/receitas/nova")
    public String novaReceita(
            Model model) {
        UserProfile userProfile = getLogedUser(model);
        if(userProfile == null){
            return "cadastro";
        }
        return "receitas/nova";
    }

}
