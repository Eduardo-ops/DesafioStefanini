package com.stefanini.hackathon.mapper;

import com.stefanini.hackathon.dto.TurmaDTO;
import com.stefanini.hackathon.model.Turma;
import org.springframework.stereotype.Service;

@Service
public class TurmaDTOService {

     public Turma mapTurma(TurmaDTO turma){

        Turma newTurma = new Turma(null, turma.getNome(), null, null);
        return newTurma;
    }
}
