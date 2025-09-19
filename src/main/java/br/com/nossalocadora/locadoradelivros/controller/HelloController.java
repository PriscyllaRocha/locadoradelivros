package br.com.nossalocadora.locadoradelivros.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "API da Locadora está funcionando. Bem vindo!";
    }
}
