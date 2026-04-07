package com.tech.logos.logos_api.services;

import com.tech.logos.logos_api.domain.dtos.BemDTO.RequisicaoBemDTO;
import com.tech.logos.logos_api.domain.dtos.BemDTO.RespostaBemDTO;
import com.tech.logos.logos_api.domain.entities.Bem;
import com.tech.logos.logos_api.exceptions.RegistroExistenteException;
import com.tech.logos.logos_api.mappers.BemMapper;
import com.tech.logos.logos_api.repositories.BemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BemService {
    private final BemRepository bemRepository;
    private final BemMapper mapper;

    public RespostaBemDTO salvar( RequisicaoBemDTO requisicaoBemDTO) {
        Boolean bemEncontrado =  bemRepository.existsByCodigoPatrimonial(requisicaoBemDTO.codigo_patrimonial());

        if(bemEncontrado) {
         throw new RegistroExistenteException("Já existe um registro com este codigo patrimonial");
        }

        return mapper.paraDTO(bemRepository.save(mapper.paraEntidade(requisicaoBemDTO))) ;
    }

    public Page<RespostaBemDTO> obter(int pagina, int tamanhoPagina) {
        return bemRepository.findAll(PageRequest.of(pagina, tamanhoPagina))
                .map(mapper::paraDTO);
    }

    public RespostaBemDTO atualizar(UUID id, RequisicaoBemDTO requisicaoBemDTO) {

        Bem bemEncontrado =  bemRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Bem não encontrado!"));
        Bem requisicaoBemConvertido = mapper.paraEntidade(requisicaoBemDTO);
        requisicaoBemConvertido.setId(bemEncontrado.getId());
         return mapper.paraDTO(bemRepository.save(requisicaoBemConvertido));

    }

    public void deletar(UUID id) {
        Bem bemEcontrado =  bemRepository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException( HttpStatus.NOT_FOUND, "Bem não encontrado!"));
        bemRepository.delete(bemEcontrado);
    }

    public RespostaBemDTO obterPorId(UUID id) {
    return mapper.paraDTO(bemRepository
            .findById(id)
            .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possível encontrar esse bem!")));
    }
}
