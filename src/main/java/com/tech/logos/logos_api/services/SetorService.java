package com.tech.logos.logos_api.services;

import com.tech.logos.logos_api.domain.dtos.setorDTO.RequisicaoSetorDTO;
import com.tech.logos.logos_api.domain.dtos.setorDTO.RespostaSetorDTO;
import com.tech.logos.logos_api.domain.entities.Setor;
import com.tech.logos.logos_api.exceptions.RegistroExistenteException;
import com.tech.logos.logos_api.mappers.SetorMapper;
import com.tech.logos.logos_api.repositories.SetorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SetorService {

    private  final SetorRepository setorRepository;
    private  final SetorMapper   mapper;

    public RespostaSetorDTO salvar(RequisicaoSetorDTO requisicaoSetorDTO) {

        if(setorRepository.existsByNome(requisicaoSetorDTO.nome())) {
            throw  new RegistroExistenteException("Já existe um setor com esse nome");
        }
        Setor setorConvertidoParaEntidade = mapper.mapearParaEntidade(requisicaoSetorDTO);
        return  mapper.mapearParaDTO(setorRepository.save(setorConvertidoParaEntidade));

    }

    public Page<RespostaSetorDTO> listar(Integer pagina, Integer tamanhoPagina) {
      return  setorRepository.findAll(PageRequest.of(pagina,tamanhoPagina)).map(mapper::mapearParaDTO);
    }

    public RespostaSetorDTO buscarPorId(UUID idSetor) {
       Setor setorEncontrado =  setorRepository.findById(idSetor).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Esse setor não existe"));
       return mapper.mapearParaDTO(setorEncontrado);
    }

    public RespostaSetorDTO atualizar(UUID setorid, RequisicaoSetorDTO requisicaoSetorDTO) {
        Setor setorEncontrado = setorRepository.findById(setorid).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Setor não encontrado"));
        setorEncontrado.setNome(requisicaoSetorDTO.nome());
        setorEncontrado.setDescricao(requisicaoSetorDTO.descricao());
         return  mapper.mapearParaDTO(setorRepository.save(setorEncontrado));
    }

    public void remover(UUID setorId) {
        Setor setorEncontrado  = setorRepository.findById(setorId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Setor não foi encontrado"));
        setorRepository.delete(setorEncontrado);
    }
}
