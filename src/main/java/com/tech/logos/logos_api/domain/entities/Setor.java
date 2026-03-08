package com.tech.logos.logos_api.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Setor")
@Data
public class Setor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 20, nullable = false)
    private String nome;
    @Column(length = 50, nullable = true)
    private String descricao;

    @CreatedDate
    private LocalDateTime data_criacao;

}
