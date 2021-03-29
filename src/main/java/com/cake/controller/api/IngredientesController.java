package com.cake.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IngredientesController {

    @GetMapping("/receitas/ingredientes")
    public ResponseEntity<?> findIngrediente(
            @RequestParam(name="pop") String pop){
        return ResponseEntity.ok("[\"Teste\",\""+pop+"\"]");
    }

    public ResponseEntity<?> postIngrediene(String nome){
        return ResponseEntity.ok("");
    }

}
