package com.tech.logos.logos_api.exceptions;

import com.tech.logos.logos_api.domain.dtos.exceptionDTO.MensagemErroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerExceptions {

    @ExceptionHandler(JaExisteException.class)
    public MensagemErroDTO handleJaExisteRegistro(JaExisteException e) {
        return new  MensagemErroDTO(HttpStatus.CONFLICT.value(), e.getMessage());
    }

}
