package com.tech.logos.logos_api.services;

import com.tech.logos.logos_api.domain.entities.Usuario;
import com.tech.logos.logos_api.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public Usuario obterUsuarioPorNome(String nome) {
        return usuarioRepository.findByNome(nome);
    }
}
