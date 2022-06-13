package com.stefanini.hackathon.mapper;

import com.stefanini.hackathon.dto.DisciplinaDTO;
import com.stefanini.hackathon.exception.CursoNotFoundException;
import com.stefanini.hackathon.exception.TurmaNotFoundException;
import com.stefanini.hackathon.model.Curso;
import com.stefanini.hackathon.model.Disciplina;
import com.stefanini.hackathon.model.Turma;
import com.stefanini.hackathon.service.CursoService;
import com.stefanini.hackathon.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaDTOService {

    private final TurmaService turmaService;
    private final CursoService cursoService;

    @Autowired
    public DisciplinaDTOService(TurmaService turmaService, CursoService cursoService) {
        this.turmaService = turmaService;
        this.cursoService = cursoService;
    }


    public Disciplina mapDisciplina(DisciplinaDTO disciplina) throws TurmaNotFoundException, CursoNotFoundException {

        Turma turma = turmaService.findById(disciplina.getTurma());
        Curso curso = cursoService.findById(disciplina.getCurso());

        Disciplina newDisciplina = new Disciplina(null,
                disciplina.getNome(),
                disciplina.getCodigo(),
                disciplina.getConteudoProgramatico(),
                disciplina.getNumeroCreditos(),
                disciplina.getTotalHoras(),
                turma,
                curso);
        return newDisciplina;
    }
}
