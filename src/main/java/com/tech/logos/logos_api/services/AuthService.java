package com.tech.logos.logos_api.services;

import com.tech.logos.logos_api.domain.dtos.LoginDTO.RequisicaoLoginDTO;
import com.tech.logos.logos_api.domain.dtos.LoginDTO.RespostaLoginDTO;
import com.tech.logos.logos_api.domain.entities.Usuario;
import com.tech.logos.logos_api.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
@RequiredArgsConstructor
public class AuthService {
    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final PasswordEncoder encoder;

    public Usuario obterUsuarioPorNome(String nome) {
        return usuarioRepository.findByNome(nome);
    }

    public RespostaLoginDTO login(RequisicaoLoginDTO requisicaoLoginDTO) {

        Usuario usuarioEncontrado =  usuarioRepository.findByEmail(requisicaoLoginDTO.email()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuário não encontrado"));

        if(!encoder.matches(requisicaoLoginDTO.senha(),usuarioEncontrado.getSenha_hash())) {
            throw new RuntimeException("Senha incorreta");
        }

        String token = jwtService.gerarToken(usuarioEncontrado.getEmail());
        return new RespostaLoginDTO(token);

    }
}
