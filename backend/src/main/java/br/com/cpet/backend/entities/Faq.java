package br.com.cpet.backend.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Faq {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String pergunta;

    @Column(nullable = false)
    private String resposta;
}