package br.com.cpet.backend.dtos.response;

import lombok.Builder;

@Builder
public record BannerDTO(

        String titulo,
        String subtitulo,
        String logo
) {}