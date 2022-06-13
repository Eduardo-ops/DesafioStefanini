package com.stefanini.hackathon.service;

import com.stefanini.hackathon.dto.AlunoDTO;
import com.stefanini.hackathon.exception.AlunoNotFoundException;
import com.stefanini.hackathon.model.Aluno;
import com.stefanini.hackathon.repository.AlunoRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AlunoService {

	private final AlunoRepository alunoRepository;

	public AlunoService(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}

	public List<Aluno> findAllAlunos() {
		return alunoRepository.findAll();
	}

	public Aluno findById(Long id) throws AlunoNotFoundException {
		return alunoRepository.findById(id).orElseThrow(() -> new AlunoNotFoundException(id));
	}

	public void createAluno(AlunoDTO dto) {
		Aluno material = toAluno(dto);
		alunoRepository.save(material);
	}

	private Aluno toAluno(AlunoDTO dto) {
		Aluno aluno = new Aluno();
		aluno.setNome(dto.getNome());
		aluno.setMatricula(dto.getNome());
		return aluno;
	}

	public void updateAluno(AlunoDTO dto, Long code) throws AlunoNotFoundException {
		Aluno aluno = findById(code);
		updateData(dto, aluno);
		alunoRepository.save(aluno);
	}

	private void updateData(AlunoDTO dto, Aluno aluno) {
		aluno.setNome(dto.getNome());
		aluno.setMatricula(dto.getMatricula());
		aluno.setTurma(aluno.getTurma());
	}

	public void deleteAluno(Long code) throws AlunoNotFoundException {
		Aluno material = findById(code);
		alunoRepository.delete(material);
	}

	// public void delete(Long id) {
	// alunoRepository.deleteById(id);
	// }

	// public void update(Aluno aluno) {
	// Aluno alterado = alunoRepository.findById(aluno.getId()).get();
	// alterado.setDadosPessoais(aluno.getDadosPessoais());
	// alterado.setMatricula(aluno.getMatricula());
	// alterado.setNome(aluno.getNome());
	// alterado.setTurma(aluno.getTurma());
	// alunoRepository.save(aluno);
	// }

}
