package br.com.marcelo.exerciciossb.controllers;

import br.com.marcelo.exerciciossb.model.entities.Produto;
import br.com.marcelo.exerciciossb.model.repositories.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/pagina/{numeroPagina}/{qtdPagina}")
    public Iterable<Produto> obterProdutosPorPagina(@PathVariable int numeroPagina, @PathVariable int qtdPagina) {
        if (qtdPagina >= 5) qtdPagina = 5;
        Pageable page = PageRequest.of(numeroPagina, qtdPagina);
        return produtoRepository.findAll(page);
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProduto(@Valid @PathVariable int id) {

         if (!produtoRepository.existsById(id)) {
             return ResponseEntity.notFound().build();
         }

         produtoRepository.deleteById(id);

         return ResponseEntity.noContent().build();
    }

}
