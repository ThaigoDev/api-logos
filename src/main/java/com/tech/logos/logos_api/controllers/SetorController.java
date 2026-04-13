package com.tech.logos.logos_api.controllers;

import com.tech.logos.logos_api.controllers.util.GeradorDeLocationURI;
import com.tech.logos.logos_api.domain.dtos.SetorDTO.RequisicaoSetorDTO;
import com.tech.logos.logos_api.domain.dtos.SetorDTO.RespostaSetorDTO;
import com.tech.logos.logos_api.services.SetorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("setores")
@RequiredArgsConstructor
public class SetorController  implements GeradorDeLocationURI {

    private  final SetorService setorService;

    @PostMapping
    public ResponseEntity<RespostaSetorDTO> cadastrarSetor(@RequestBody RequisicaoSetorDTO requisicaoSetorDTO) {
        System.out.println(requisicaoSetorDTO);
        RespostaSetorDTO setorSalvo =  setorService.salvar(requisicaoSetorDTO);
        return ResponseEntity.created(gerarLocationURI(setorSalvo.id())).body(setorSalvo);
    }
    @GetMapping
    public ResponseEntity<Page<RespostaSetorDTO>> listarSetores(
            @RequestParam(value = "pagina", defaultValue = "0")
            Integer pagina,
            @RequestParam(value = "tamanhoPagina",defaultValue = "10")
            Integer tamanhoPagina
            ) {
        Page<RespostaSetorDTO> listaDeSetores = setorService.listar(pagina, tamanhoPagina);
        return ResponseEntity.ok().body(listaDeSetores);
    }
    @GetMapping("{id}")
    public ResponseEntity<RespostaSetorDTO>  buscarSetor(@PathVariable("id")UUID idSetor) {
        RespostaSetorDTO setorEncontrado =  setorService.buscarPorId(idSetor);
        return ResponseEntity.ok().body(setorEncontrado);
    }
    @PutMapping("{id}")
    public ResponseEntity<RespostaSetorDTO> atualizarSetor(@PathVariable("id")UUID setorid, @RequestBody RequisicaoSetorDTO requisicaoSetorDTO) {
        RespostaSetorDTO setorEditado = setorService.atualizar(setorid, requisicaoSetorDTO);
        return ResponseEntity.ok().body(setorEditado);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> removerSetor(@PathVariable("id") UUID setorId) {
        setorService.remover(setorId);
        return  ResponseEntity.ok().build();
    }


}
