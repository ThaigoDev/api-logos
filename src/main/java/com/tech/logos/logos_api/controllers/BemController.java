package com.tech.logos.logos_api.controllers;

import com.tech.logos.logos_api.domain.dtos.BemDTO.RequisicaoBemDTO;
import com.tech.logos.logos_api.domain.dtos.BemDTO.RespostaBemDTO;
import com.tech.logos.logos_api.domain.dtos.SetorDTO.RespostaSetorDTO;
import com.tech.logos.logos_api.services.BemService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("bens")
@RequiredArgsConstructor
public class BemController {
    private final BemService bemService;

    @PostMapping
    public ResponseEntity<RespostaBemDTO> salvarBem (@RequestBody RequisicaoBemDTO requisicaoBemDTO) {
        RespostaBemDTO bemSalvo =  bemService.salvar(requisicaoBemDTO);

        URI location  = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(bemSalvo.id())
                .toUri();

        return  ResponseEntity.created(location).body(bemSalvo);
    }

    @GetMapping
    public ResponseEntity<Page<RespostaBemDTO>> obterBens (
            @RequestParam(value = "pagina", defaultValue = "0")
            int pagina,
            @RequestParam(value = "tamanhoPagina", defaultValue = "10")
            int tamanhoPagina
            ) {

        Page<RespostaBemDTO> listaBens = bemService.obter(pagina,tamanhoPagina);
        return ResponseEntity.ok().body(listaBens);

    }
    @GetMapping("{id}")
    public ResponseEntity<RespostaBemDTO> obterPorId(@PathVariable("id") UUID id) {
        RespostaBemDTO bemObtido =  bemService.obterPorId(id);
        return ResponseEntity.ok().body(bemObtido);
    }
    @PutMapping("{id}")
    public ResponseEntity<RespostaBemDTO> atualizarBem(@PathVariable("id")UUID id, @RequestBody RequisicaoBemDTO requisicaoBemDTO) {
        RespostaBemDTO bemAtualizado  =  bemService.atualizar(id, requisicaoBemDTO);
         return ResponseEntity.ok().body(bemAtualizado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarBemPorId(@PathVariable("id") UUID id) {
        bemService.deletar(id);
        return  ResponseEntity.noContent().build();
    }


}
