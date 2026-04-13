package com.tech.logos.logos_api.domain.dtos.BemDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record RequisicaoBemDTO(
        @NotBlank(message = "Código Patrimonial é obrigatório, não pode ser 'null'")
        String codigo_patrimonial,

        String descricao,

        @NotNull(message = "Valor é obrigatório, não pode ser 'null'")
        BigDecimal valor,
        @NotBlank(message = "Estado de Conservação é obrigatório, não pode ser 'null'")
        String estado_conservacao,

        @NotBlank(message = "Situação é obrigatório, não pode ser 'null'")
        String situacao,

        @NotBlank(message = "Data de Aquisição é obrigatória, não pode ser 'null'")
        LocalDateTime data_aquisicao,

        String foto_url,
        @NotNull(message = "Setor é obrigatório, não pode ser 'null'")
        UUID setor_id
) {
}
