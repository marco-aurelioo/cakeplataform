package com.cake.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class ReceitasController {


    public ResponseEntity<?> findReceita(String nome){
        return ResponseEntity.ok("");
    }

    public ResponseEntity<?> minhasReceitas(){
        return ResponseEntity.ok("");
    }


}
