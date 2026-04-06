package com.tech.logos.logos_api.mappers;

import com.tech.logos.logos_api.domain.dtos.BemDTO.RequisicaoBemDTO;
import com.tech.logos.logos_api.domain.dtos.BemDTO.RespostaBemDTO;
import com.tech.logos.logos_api.domain.entities.Bem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BemMapper {

    RespostaBemDTO paraDTO(Bem bem);

    @Mapping(source = "setor_id",target = "setor.id")
    Bem paraEntidade(RequisicaoBemDTO requisicaoBemDTO);

}
