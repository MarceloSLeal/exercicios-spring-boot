package br.com.marcelo.exerciciossb.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {

    // DESAFIO criar os seguintes endpoints recebendo parâmetros e retornando o resultado
    // /calculadora/somar/10/20
    // /calculadora/subtrair?a=10&b=20

    // http://localhost:8080/somar?a=10&b=20
    @GetMapping("/somar")
    public String somar(@RequestParam String a, @RequestParam String b) {
        int c = Integer.parseInt(a) + Integer.parseInt(b);
        return String.valueOf(c);
    }

    // http://localhost:8080/subtrair?a=50&b=20
    @GetMapping("/subtrair")
    public String subtrair(@RequestParam String a, @RequestParam String b) {
        int c = Integer.parseInt(a) - Integer.parseInt(b);
        return String.valueOf(c);
    }

}
