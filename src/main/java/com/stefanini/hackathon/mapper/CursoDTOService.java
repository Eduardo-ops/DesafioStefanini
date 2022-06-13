package com.stefanini.hackathon.mapper;

import com.stefanini.hackathon.dto.CursoDTO;
import com.stefanini.hackathon.exception.TurmaNotFoundException;
import com.stefanini.hackathon.model.Curso;
import org.springframework.stereotype.Service;

@Service
public class CursoDTOService {

     public Curso mapCurso(CursoDTO curso) throws TurmaNotFoundException {

        Curso newCurso = new Curso(null, curso.getName(), null, curso.getTotalGrade());
        return newCurso;
    }
}
