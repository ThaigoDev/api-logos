package com.tech.logos.logos_api.repositories;

import com.tech.logos.logos_api.domain.entities.Setor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SetorRepository  extends JpaRepository<Setor, UUID> {
    void findByNome(String nome);

    boolean existsByNome(String nome);
}
