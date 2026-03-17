package com.tech.logos.logos_api.domain.dtos.LoginDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RequisicaoLoginDTO(
        @NotBlank(message = "E-mail é obrigatório, não pode ser 'null'")
        @Email(message = "Insira um e-mail válido")
        String email,
        @NotBlank(message = "Senha é obridatória, não pode ser 'null'")
        @Size(min = 4, max = 10, message = "A senha deve ter entre 6 a 10 caracteres")
        String senha) {
}
