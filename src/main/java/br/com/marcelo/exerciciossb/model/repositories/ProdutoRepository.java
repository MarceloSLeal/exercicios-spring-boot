package br.com.marcelo.exerciciossb.model.repositories;

import br.com.marcelo.exerciciossb.model.entities.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {



}
