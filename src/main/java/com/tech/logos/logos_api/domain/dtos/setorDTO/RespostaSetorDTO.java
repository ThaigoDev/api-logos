package com.tech.logos.logos_api.domain.dtos.setorDTO;

import java.time.LocalDateTime;
import java.util.UUID;

public record RespostaSetorDTO(UUID id, String nome, String descricao, LocalDateTime data_criacao) {
}
