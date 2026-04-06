package com.tech.logos.logos_api.domain.dtos.BemDTO;

import com.tech.logos.logos_api.domain.entities.Setor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record RespostaBemDTO (
        UUID id,
        String codigo_patrimonial,
        String descricao,
        BigDecimal valor,
        String estado_conservacao,
        String situacao,
        LocalDateTime data_aquisicao,
        String foto_url,
        Setor setor
) {
}
