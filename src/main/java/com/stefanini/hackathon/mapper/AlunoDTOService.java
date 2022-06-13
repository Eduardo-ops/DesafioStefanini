package com.stefanini.hackathon.mapper;

import com.stefanini.hackathon.dto.AlunoDTO;
import com.stefanini.hackathon.exception.TurmaNotFoundException;
import com.stefanini.hackathon.model.Aluno;
import com.stefanini.hackathon.model.DadosPessoais;
import com.stefanini.hackathon.model.Turma;
import com.stefanini.hackathon.repository.TurmaRepository;
import com.stefanini.hackathon.service.DadosPessoaisService;
import com.stefanini.hackathon.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoDTOService {

    private final TurmaService turmaService;
    private final DadosPessoaisService dadosPessoaisService;

    @Autowired
    public AlunoDTOService(TurmaService turmaService, DadosPessoaisService dadosPessoaisService) {
        this.turmaService = turmaService;
        this.dadosPessoaisService = dadosPessoaisService;
    }


    public Aluno mapAluno(AlunoDTO aluno) throws TurmaNotFoundException {

        Turma turma;
        DadosPessoais dadosPessoais = new DadosPessoais(
                                                    null,
                                                        aluno.getCpf(),
                                                        aluno.getEmail());
        dadosPessoaisService.save(dadosPessoais);

        Aluno newAluno = new Aluno(null,
                                    aluno.getNome(),
                                    aluno.getMatricula(),
                dadosPessoaisService.save(dadosPessoais),
                turma = turmaService.findById(aluno.getIdTurma())
                                    );
        return newAluno;
    }
}
