package com.cake.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IngredientesController {


    public ResponseEntity<?> findIngrediente(String ingrediete){
        return ResponseEntity.ok("");
    }

    public ResponseEntity<?> postIngrediene(String nome){
        return ResponseEntity.ok("");
    }

}
