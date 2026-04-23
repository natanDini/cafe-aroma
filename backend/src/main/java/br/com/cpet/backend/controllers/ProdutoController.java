package br.com.cpet.backend.controllers;

import br.com.cpet.backend.dtos.response.ProdutoDTO;
import br.com.cpet.backend.services.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produto")
@Tag(name = "Produto", description = "Gerenciamento e consulta do catálogo de produtos.")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Operation(summary = "Listar produtos por categoria", description = "Recupera todos os produtos vinculados a uma categoria específica através do seu ID.")
    @GetMapping("/{categoriaId}")
    public ResponseEntity<List<ProdutoDTO>> getProdutosByCategoriaId(@PathVariable Long categoriaId) throws Exception {
        return ResponseEntity.ok(produtoService.getProdutosByCategoriaId(categoriaId));
    }
}