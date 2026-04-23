package br.com.cpet.backend.dtos.request;

public record ContatoDTO (

        String nome,
        String email,
        String mensagem
){}