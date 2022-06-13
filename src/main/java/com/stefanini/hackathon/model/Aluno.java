package com.stefanini.hackathon.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Data
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String matricula;

	@OneToOne
	private DadosPessoais dadosPessoais;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "turma_id")
	private Turma turma;

	public Aluno() {

	}

	public Aluno(Object object, String string, String string2, DadosPessoais dadosPessoais2, Turma turma2) {
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.dadosPessoais = dadosPessoais;
		this.turma = turma;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}

	public void setDadosPessoais(DadosPessoais dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

}
