package com.stefanini.hackathon.controller;

import com.stefanini.hackathon.dto.AlunoDTO;
import com.stefanini.hackathon.exception.AlunoNotFoundException;
import com.stefanini.hackathon.exception.TurmaNotFoundException;
import com.stefanini.hackathon.model.Aluno;
import com.stefanini.hackathon.mapper.AlunoDTOService;
import com.stefanini.hackathon.service.AlunoService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpStatus;

import java.util.List;

import javax.validation.Valid;

@RestController
public class AlunoController {

	private final AlunoService alunoService;
	private final AlunoDTOService alunoDTOService;

	@Autowired
	public AlunoController(AlunoService alunoService, AlunoDTOService alunoDTOService) {
		this.alunoService = alunoService;
		this.alunoDTOService = alunoDTOService;
	}

	@GetMapping(value = "/aluno")
	public List<Aluno> findAlunos() {
		List<Aluno> alunos = alunoService.findAllAlunos();
		return alunos;
	}

	@PostMapping("/aluno")
	public void Aluno(@RequestBody @Valid AlunoDTO dto) {
		alunoService.createAluno(dto);
	}

	@PutMapping("/{code}")
	public void updateAluno(@RequestBody @Valid AlunoDTO dto, @PathVariable Long code) throws AlunoNotFoundException {
		alunoService.updateAluno(dto, code);
	}

	@DeleteMapping("/{code}")
	public void deleteAluno(@PathVariable Long code) throws AlunoNotFoundException {
		alunoService.deleteAluno(code);
	}

	// @DeleteMapping("/aluno/{id}")
	// public void deleteAluno(@PathVariable Long id) {
	// alunoService.delete(id);
	// }

	// @PostMapping("/aluno")
	// public Aluno saveAluno(@RequestBody @Valid AlunoDTO alunoDTO) {
	// Aluno aluno = new Aluno();
	// BeanUtils.copyProperties(alunoDTO, aluno);
	// return aluno;
//	}

	// @PutMapping("aluno")
	// public void updateAluno(@RequestBody Aluno aluno) {
	// alunoService.update(aluno);
	// }
}
