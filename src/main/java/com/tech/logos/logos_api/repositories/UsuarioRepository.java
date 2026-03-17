package com.tech.logos.logos_api.repositories;

import com.tech.logos.logos_api.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Usuario findByNome(String nome);

    Optional<Usuario> findByEmail(String email);
}
