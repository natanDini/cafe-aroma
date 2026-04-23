package br.com.cpet.backend.repositories;

import br.com.cpet.backend.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findAllByCategoriaId(Long categoriaId);
}