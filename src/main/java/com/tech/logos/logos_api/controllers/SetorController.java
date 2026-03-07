package com.tech.logos.logos_api.controllers;

import com.tech.logos.logos_api.controllers.util.GeradorDeLocationURI;
import com.tech.logos.logos_api.domain.dtos.setorDTO.RequisicaoSetorDTO;
import com.tech.logos.logos_api.domain.dtos.setorDTO.RespostaSetorDTO;
import com.tech.logos.logos_api.services.SetorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/setores")
@RequiredArgsConstructor
public class SetorController  implements GeradorDeLocationURI {

    private  final SetorService setorService;

    @PostMapping
    public ResponseEntity<RespostaSetorDTO> cadastrarSetor(@RequestBody RequisicaoSetorDTO requisicaoSetorDTO) {
        RespostaSetorDTO setorSalvo =  setorService.salvar(requisicaoSetorDTO);
        return ResponseEntity.created(gerarLocationURI(setorSalvo.id())).body(setorSalvo);
    }


}
