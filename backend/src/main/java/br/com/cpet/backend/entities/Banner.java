package br.com.cpet.backend.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String logo;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String subtitulo;
}