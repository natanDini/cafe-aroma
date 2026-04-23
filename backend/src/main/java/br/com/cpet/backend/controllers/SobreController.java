package br.com.cpet.backend.controllers;

import br.com.cpet.backend.dtos.response.SobreDTO;
import br.com.cpet.backend.services.SobreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sobre")
@Tag(name = "Sobre", description = "Gerenciamento das informações institucionais da empresa.")
public class SobreController {

    private final SobreService sobreService;

    @Operation(summary = "Recuperar informações institucionais", description = "Retorna os dados detalhados sobre a empresa, como história, valores e equipe.")
    @GetMapping
    public ResponseEntity<SobreDTO> getSobre() throws Exception {
        return ResponseEntity.ok(sobreService.getSobre());
    }
}