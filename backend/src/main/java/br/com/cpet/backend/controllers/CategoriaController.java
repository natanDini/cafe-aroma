package br.com.cpet.backend.controllers;

import br.com.cpet.backend.dtos.response.CategoriaDTO;
import br.com.cpet.backend.services.CategoriaService;
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
@RequestMapping("/categoria")
@Tag(name = "Categoria", description = "Gerenciamento do catálogo de categorias de produtos.")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @Operation(summary = "Listar todas as categorias", description = "Retorna a lista completa de categorias cadastradas no sistema.")
    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> getCategorias() throws Exception {
        return ResponseEntity.ok(categoriaService.getCategorias());
    }

    @Operation(summary = "Buscar categoria por ID", description = "Recupera os detalhes específicos de uma categoria através do seu identificador único.")
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> getCategoriaById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(categoriaService.getCategoriaById(id));
    }
}