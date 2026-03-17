package com.tech.logos.logos_api.controllers;

import com.tech.logos.logos_api.domain.dtos.LoginDTO.RequisicaoLoginDTO;
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
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public ResponseEntity<Void> login(@RequestBody RequisicaoLoginDTO requisicaoLoginDTO) {

        var usuarioAutenticado =   authService.login(requisicaoLoginDTO);

        return ResponseEntity.ok().build();
    }



}
