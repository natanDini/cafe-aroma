package br.com.cpet.backend.dtos.response;

import lombok.Builder;

@Builder
public record CategoriaDTO (

        String nome,
        String descricao,
        String imagem
) {}