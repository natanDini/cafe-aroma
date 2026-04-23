package br.com.cpet.backend.dtos.response;

import lombok.Builder;

@Builder
public record ProdutoDTO (

        String nome,
        String descricao,
        String preco,
        String imagem
){}