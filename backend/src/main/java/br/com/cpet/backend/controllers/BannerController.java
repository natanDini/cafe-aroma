package br.com.cpet.backend.controllers;

import br.com.cpet.backend.dtos.response.BannerDTO;
import br.com.cpet.backend.services.BannerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/banner")
@Tag(name = "Banner", description = "Gestão de banners informativos da interface principal.")
public class BannerController {

    private final BannerService bannerService;

    @Operation(summary = "Recuperar banner ativo", description = "Busca as informações do banner principal configurado para exibição atual.")
    @GetMapping
    public ResponseEntity<BannerDTO> getBanner() throws Exception {
        return ResponseEntity.ok(bannerService.getBanner());
    }
}