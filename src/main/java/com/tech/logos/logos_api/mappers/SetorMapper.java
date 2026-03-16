package com.tech.logos.logos_api.mappers;

import com.tech.logos.logos_api.domain.dtos.SetorDTO.RequisicaoSetorDTO;
import com.tech.logos.logos_api.domain.dtos.SetorDTO.RespostaSetorDTO;
import com.tech.logos.logos_api.domain.entities.Setor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SetorMapper {

    RespostaSetorDTO mapearParaDTO(Setor setor);
    Setor mapearParaEntidade (RequisicaoSetorDTO requisicaoSetorDTO);
}
