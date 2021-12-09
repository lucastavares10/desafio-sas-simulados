package com.sas.desafio.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "simulado_id")
	private Long simuladoId;

	@Column(name = "aluno_id")
	private Long alunoId;

	private BigDecimal nota;

	public Nota() {
		super();
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

	public Long getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(Long alunoId) {
		this.alunoId = alunoId;
	}

	public BigDecimal getNota() {
		return nota;
	}

	public void setNota(BigDecimal nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "NotaAluno [id=" + id + ", simuladoId=" + simuladoId + ", alunoId=" + alunoId + ", nota=" + nota + "]";
	}

}
