package com.tech.logos.logos_api.security;

import com.tech.logos.logos_api.domain.entities.Usuario;
import com.tech.logos.logos_api.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetalhesDoUsuarioService  implements UserDetailsService {
    private final UsuarioService usuarioService;
    @Override
    public UserDetails loadUserByUsername(String nomeUsuario) throws UsernameNotFoundException {
        Usuario usuarioEncontrado  = usuarioService.obterUsuarioPorNome(nomeUsuario);

        return User.builder()
                .username(usuarioEncontrado.getNome())
                .password(usuarioEncontrado.getSenha_hash())
                .build();
    }
}
