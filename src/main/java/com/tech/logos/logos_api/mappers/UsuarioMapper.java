package com.tech.logos.logos_api.mappers;

import com.tech.logos.logos_api.domain.dtos.CriarContaDTO.RequisicaoCriarContaDTO;
import com.tech.logos.logos_api.domain.dtos.CriarContaDTO.RespostaCriarContaDTO;
import com.tech.logos.logos_api.domain.entities.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario paraEntidade (RequisicaoCriarContaDTO requisicaoCriarContaDTO);
    RespostaCriarContaDTO paraDTO (Usuario usuario);

}
