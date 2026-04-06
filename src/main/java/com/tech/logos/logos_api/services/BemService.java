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
import org.springframework.stereotype.Service;

import java.util.List;

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
}
