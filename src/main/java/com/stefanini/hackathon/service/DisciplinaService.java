package com.stefanini.hackathon.service;

import com.stefanini.hackathon.exception.DisciplinaNotFoundException;
import com.stefanini.hackathon.model.Disciplina;
import com.stefanini.hackathon.repository.DisciplinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public List<Disciplina> findAllDisciplinas(){
        return disciplinaRepository.findAll();
    }

    public Disciplina findById(Long id) throws DisciplinaNotFoundException {
        return disciplinaRepository.findById(id)
                .orElseThrow(()-> new DisciplinaNotFoundException(id));
    }

    public Disciplina save(Disciplina disciplina){
        return disciplinaRepository.save(disciplina);
    }

}
