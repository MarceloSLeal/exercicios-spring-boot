package br.com.marcelo.exerciciossb.model.repositories;

import br.com.marcelo.exerciciossb.model.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    public Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);

}
