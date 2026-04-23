package br.com.cpet.backend.dtos.response;

import lombok.Builder;

@Builder
public record SobreDTO(

        String historia,
        String valores,
        String equipe,
        String imagem
) {}