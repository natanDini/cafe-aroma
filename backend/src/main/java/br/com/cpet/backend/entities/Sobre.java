package br.com.cpet.backend.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Sobre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String historia;

    @Column(nullable = false)
    private String valores;

    @Column(nullable = false)
    private String equipe;

    @Column(nullable = false)
    private String imagem;
}