package com.tech.logos.logos_api.repositories;

import com.tech.logos.logos_api.domain.entities.Bem;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BemRepository extends JpaRepository<Bem, UUID> {

    Boolean existsByCodigoPatrimonial(@NotBlank(message = "Código Patrimonial é obrigatório, não pode ser 'null'") String s);

}
