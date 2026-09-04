package br.com.fatec.apiexemplo.controller;

import br.com.fatec.apiexemplo.model.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OlaController {
    @GetMapping("/ola")
    public String ola() {
        return " Olá Mundo!";
    }








}
