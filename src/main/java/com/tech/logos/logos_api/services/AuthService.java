package com.tech.logos.logos_api.services;

import com.tech.logos.logos_api.domain.dtos.CriarContaDTO.RequisicaoCriarContaDTO;
import com.tech.logos.logos_api.domain.dtos.CriarContaDTO.RespostaCriarContaDTO;
import com.tech.logos.logos_api.domain.dtos.LoginDTO.RequisicaoLoginDTO;
import com.tech.logos.logos_api.domain.dtos.LoginDTO.RespostaLoginDTO;
import com.tech.logos.logos_api.domain.entities.Usuario;
import com.tech.logos.logos_api.mappers.UsuarioMapper;
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
    private final UsuarioMapper mapper;

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

    public RespostaCriarContaDTO criarConta(RequisicaoCriarContaDTO requisicaoCriarContaDTO) {
        var usuarioEncontrado = usuarioRepository.findByEmail(requisicaoCriarContaDTO.email());

        if(usuarioEncontrado.isPresent()) {
            throw new RuntimeException("Usuário já existe na base de dados");

        }

        var usuarioEntidade =  mapper.paraEntidade(requisicaoCriarContaDTO);

        usuarioEntidade.setSenha_hash(encoder.encode(requisicaoCriarContaDTO.senha()));

        return mapper.paraDTO(usuarioRepository.save(usuarioEntidade));

    }
}
