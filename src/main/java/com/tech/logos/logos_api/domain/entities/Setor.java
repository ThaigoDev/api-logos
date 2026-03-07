package com.tech.logos.logos_api.domain.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Setor")
public class Setor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column()
    private String nome;

    private String descricao;

    @CreatedDate
    private LocalDateTime data_criacao;

}
