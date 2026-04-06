package com.tech.logos.logos_api.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table( name = "Bem")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Bem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name= "codigo_patrimonial")
    private String codigoPatrimonial;

    private String descricao;

    private BigDecimal valor;

    private String estado_conservacao;

    private String situacao;

    private LocalDateTime data_aquisicao;

    private String foto_url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "setor_id")
    private Setor setor;

    @CreatedDate
    private  LocalDateTime criado_em;

    @LastModifiedDate
    private  LocalDateTime atualizado_em;

}
