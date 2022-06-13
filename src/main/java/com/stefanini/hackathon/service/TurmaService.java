package com.stefanini.hackathon.service;

import com.stefanini.hackathon.exception.TurmaNotFoundException;
import com.stefanini.hackathon.model.Turma;
import com.stefanini.hackathon.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TurmaService {

    private final TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public List<Turma> findAllTurmas(){
        return turmaRepository.findAll();
    }

    public Turma findById(Long id) throws TurmaNotFoundException {
        return turmaRepository.findById(id)
                .orElseThrow(()-> new TurmaNotFoundException(id));
    }

    public Turma save(Turma turma){
        return turmaRepository.save(turma);
    }

}
