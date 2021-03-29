package com.cake.controller.site;

import com.cake.controller.BaseController;
import com.cake.dto.UserProfile;
import com.cake.service.UserService;
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


    @GetMapping("/profile")
    public String getUser(Model model) {
        UserProfile userProfile = getLogedUser(model);
        if(userProfile != null){
            model.addAttribute("user", userProfile);
            return "user/profile";
        }
        model.addAttribute("user",new UserProfile());
        return "cadastro";
    }

    @PostMapping("/profile")
    public String updateUser(
            @ModelAttribute UserProfile user,
            Model model) {
        UserProfile userProfile = getLogedUser(model);
        if(userProfile != null){
            service.updateUser(user);
            model.addAttribute("user", user);
            return "user/profile";
        }
        model.addAttribute("user",new UserProfile());
        return "cadastro";
    }

}
