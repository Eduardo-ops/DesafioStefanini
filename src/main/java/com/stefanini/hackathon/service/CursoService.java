package com.stefanini.hackathon.service;

import com.stefanini.hackathon.dto.AlunoDTO;
import com.stefanini.hackathon.dto.CursoDTO;
import com.stefanini.hackathon.exception.AlunoNotFoundException;
import com.stefanini.hackathon.exception.CursoNotFoundException;
import com.stefanini.hackathon.model.Aluno;
import com.stefanini.hackathon.model.Curso;
import com.stefanini.hackathon.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CursoService {

	private final CursoRepository cursoRepository;

	public CursoService(CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}

	public List<Curso> findAllCursos() {
		return cursoRepository.findAll();
	}

	public Curso findById(Long id) throws CursoNotFoundException {
		return cursoRepository.findById(id).orElseThrow(() -> new CursoNotFoundException(id));
	}

	public void createCurso(CursoDTO dto) {
		Curso curso = toCurso(dto);
		cursoRepository.save(curso);
	}

	private Curso toCurso(CursoDTO dto) {
		Curso curso = new Curso();
		curso.setName(dto.getName());
		curso.setTotalGrade(dto.getTotalGrade());
		return curso;
	}

	public void updateCurso(CursoDTO dto, Long code) throws CursoNotFoundException {
		Curso curso = findById(code);
		updateData(dto, curso);
		cursoRepository.save(curso);
	}

	private void updateData(CursoDTO dto, Curso curso) {
		curso.setName(dto.getName());
		curso.setTotalGrade(dto.getTotalGrade());
	}

	public void deleteCurso(Long code) throws CursoNotFoundException {
		Curso curso = findById(code);
		cursoRepository.delete(curso);
	}

	// public Curso save(Curso curso) {
	// return cursoRepository.save(curso);
	// }

	// public void deleteCurso(Long id) {
	// cursoRepository.deleteById(id);
	// }

	// public void updateCurso(Curso curso) {
	// Curso update = cursoRepository.findById(curso.getId()).get();
	// update.setName(curso.getName());
	// update.setDisciplinas(curso.getDisciplinas());
	// update.setTotalGrade(update.getTotalGrade());
	// cursoRepository.save(curso);
	// }

}
