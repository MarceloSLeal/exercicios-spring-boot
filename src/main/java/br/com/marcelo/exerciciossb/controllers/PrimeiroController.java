package br.com.marcelo.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class PrimeiroController {


    @GetMapping("/ola")
    public String ola() {
        return "Olá Spring Boot!";
    }

}
