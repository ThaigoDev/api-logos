package com.tech.logos.logos_api.mappers;

import com.tech.logos.logos_api.domain.dtos.setorDTO.RequisicaoSetorDTO;
import com.tech.logos.logos_api.domain.dtos.setorDTO.RespostaSetorDTO;
import com.tech.logos.logos_api.domain.entities.Setor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SetorMapper {

    RespostaSetorDTO toDTO(Setor setor);
    Setor toEntity (RequisicaoSetorDTO requisicaoSetorDTO);
}
