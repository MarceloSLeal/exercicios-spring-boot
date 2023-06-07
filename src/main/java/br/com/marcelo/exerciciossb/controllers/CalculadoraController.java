package br.com.marcelo.exerciciossb.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    // DESAFIO criar os seguintes endpoints recebendo parâmetros e retornando o resultado
    // /calculadora/somar/10/20
    // /calculadora/subtrair?a=10&b=20

    // http://localhost:8080/calculadora/somar/10/10
    @GetMapping("/somar/{a}/{b}")
    public int somar(@PathVariable int a, @PathVariable int b) {
        return a + b;
    }

    // http://localhost:8080/calculadora/subtrair?a=40&b=20
    @GetMapping("/subtrair")
    public int subtrair(@RequestParam(name = "a") int a, @RequestParam(name = "b") int b) {
        return a - b;
    }

}
