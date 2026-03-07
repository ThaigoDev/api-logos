package com.tech.logos.logos_api.services;

import com.tech.logos.logos_api.domain.dtos.setorDTO.RequisicaoSetorDTO;
import com.tech.logos.logos_api.domain.dtos.setorDTO.RespostaSetorDTO;
import com.tech.logos.logos_api.exceptions.JaExisteException;
import com.tech.logos.logos_api.mappers.SetorMapper;
import com.tech.logos.logos_api.repositories.SetorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SetorService {

    private  final SetorRepository setorRepository;
    private  final SetorMapper  mapper;

    public RespostaSetorDTO salvar(RequisicaoSetorDTO requisicaoSetorDTO) {

        if(setorRepository.existsByNome(requisicaoSetorDTO.nome())) {
            throw  new JaExisteException("Já existe um setor com esse nome");
        }
        return  mapper.toDTO(setorRepository.save(mapper.toEntity(requisicaoSetorDTO)));

    }
}
