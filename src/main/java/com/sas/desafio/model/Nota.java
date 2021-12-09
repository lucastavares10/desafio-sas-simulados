package com.sas.desafio.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Nota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "simulado_id")
	private Long simuladoId;

	@OneToOne
	@JoinColumn(name = "aluno_id", referencedColumnName = "id")
	private Aluno aluno;

	private BigDecimal nota;

	public Nota() {
		super();
		this.nota = new BigDecimal("0");
	}

	public Nota(Long id, Long simuladoId, Aluno aluno, BigDecimal nota) {
		super();
		this.id = id;
		this.simuladoId = simuladoId;
		this.aluno = aluno;
		this.nota = nota;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSimuladoId() {
		return simuladoId;
	}

	public void setSimuladoId(Long simuladoId) {
		this.simuladoId = simuladoId;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public BigDecimal getNota() {
		return nota;
	}

	public void setNota(BigDecimal nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Nota [id=" + id + ", simuladoId=" + simuladoId + ", aluno=" + aluno + ", nota=" + nota + "]";
	}

}
