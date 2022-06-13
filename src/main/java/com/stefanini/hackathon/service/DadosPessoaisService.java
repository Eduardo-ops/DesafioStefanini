package com.stefanini.hackathon.service;

import com.stefanini.hackathon.exception.DadosPessoaisNotFoundException;
import com.stefanini.hackathon.model.DadosPessoais;
import com.stefanini.hackathon.repository.DadosPessoaisRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DadosPessoaisService {

    private final DadosPessoaisRepository dadosPessoaisRepository;

    public DadosPessoaisService(DadosPessoaisRepository dadosPessoaisRepository) {
        this.dadosPessoaisRepository = dadosPessoaisRepository;
    }

    public List<DadosPessoais> findAllDadosPessoaiss(){
        return dadosPessoaisRepository.findAll();
    }

    public DadosPessoais findById(Long id) throws DadosPessoaisNotFoundException {
        return dadosPessoaisRepository.findById(id)
                .orElseThrow(()-> new DadosPessoaisNotFoundException(id));
    }

    public DadosPessoais save(DadosPessoais dadosPessoais){
        return dadosPessoaisRepository.save(dadosPessoais);
    }

}
