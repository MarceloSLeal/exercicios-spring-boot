package br.com.marcelo.exerciciossb.controllers;

import br.com.marcelo.exerciciossb.model.entities.Produto;
import br.com.marcelo.exerciciossb.model.repositories.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public @ResponseBody Produto novoProduto(@Valid Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping
    public Iterable<Produto> obterProdutos() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Produto> obterProdutoPorId(@PathVariable int id) {
        return produtoRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Produto alterarProduto(@Valid @PathVariable int id, @RequestBody Produto produto) {
        Optional<Produto> updateProduto = produtoRepository.findById(id);

        updateProduto.get().setNome(produto.getNome());
        updateProduto.get().setPreco(produto.getPreco());
        updateProduto.get().setDesconto(produto.getDesconto());

        produtoRepository.save(updateProduto.get());

        return updateProduto.get();
    }

}
