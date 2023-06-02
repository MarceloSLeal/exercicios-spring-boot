package br.com.marcelo.exerciciossb.controllers;

import br.com.marcelo.exerciciossb.models.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @GetMapping("/qualquer")
    public Cliente obterCliente() {
        return new Cliente(28, "Pedro", "123.456.789-00");
    }

}
