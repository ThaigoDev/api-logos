package com.tech.logos.logos_api.controllers;

import com.tech.logos.logos_api.controllers.util.GeradorDeLocationURI;
import com.tech.logos.logos_api.domain.dtos.CriarContaDTO.RequisicaoCriarContaDTO;
import com.tech.logos.logos_api.domain.dtos.CriarContaDTO.RespostaCriarContaDTO;
import com.tech.logos.logos_api.domain.dtos.LoginDTO.RequisicaoLoginDTO;
import com.tech.logos.logos_api.domain.dtos.LoginDTO.RespostaLoginDTO;
import com.tech.logos.logos_api.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController  implements GeradorDeLocationURI {

    private final AuthService authService;

    @PostMapping
    public ResponseEntity<RespostaLoginDTO> login(@RequestBody RequisicaoLoginDTO requisicaoLoginDTO) {
        var usuarioAutenticado =   authService.login(requisicaoLoginDTO);
        return ResponseEntity.ok().body(usuarioAutenticado);
    }

    @PostMapping("/registrar")
    public  ResponseEntity<RespostaCriarContaDTO> registrar(@RequestBody  RequisicaoCriarContaDTO requisicaoCriarContaDTO) {
        var usuarioCriado=  authService.criarConta(requisicaoCriarContaDTO);
        return ResponseEntity.created(gerarLocationURI(usuarioCriado.id())).body(usuarioCriado);
    }

}
