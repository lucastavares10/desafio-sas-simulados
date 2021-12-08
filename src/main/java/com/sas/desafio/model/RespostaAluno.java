package com.sas.desafio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sas.desafio.model.tipos.TipoResposta;

@Entity
@Table(name = "resposta_aluno")
public class RespostaAluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private TipoResposta resposta;

	@Column(name = "aluno_id")
	private Long alunoId;

	@Column(name = "simuladoId")
	private Long simuladoId;

	@Column(name = "prova_id")
	private Long provaId;

	@Column(name = "questao_id")
	private Long questaoId;

	public RespostaAluno() {
		super();
	}

	public RespostaAluno(Long id, TipoResposta resposta, Long alunoId, Long simuladoId, Long provaId, Long questaoId) {
		super();
		this.id = id;
		this.resposta = resposta;
		this.alunoId = alunoId;
		this.simuladoId = simuladoId;
		this.provaId = provaId;
		this.questaoId = questaoId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoResposta getResposta() {
		return resposta;
	}

	public void setResposta(TipoResposta resposta) {
		this.resposta = resposta;
	}

	public Long getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(Long alunoId) {
		this.alunoId = alunoId;
	}

	public Long getSimuladoId() {
		return simuladoId;
	}

	public void setSimuladoId(Long simuladoId) {
		this.simuladoId = simuladoId;
	}

	public Long getProvaId() {
		return provaId;
	}

	public void setProvaId(Long provaId) {
		this.provaId = provaId;
	}

	public Long getQuestaoId() {
		return questaoId;
	}

	public void setQuestaoId(Long questaoId) {
		this.questaoId = questaoId;
	}

	@Override
	public String toString() {
		return "RespostaAluno [id=" + id + ", resposta=" + resposta + ", alunoId=" + alunoId + ", simuladoId="
				+ simuladoId + ", provaId=" + provaId + ", questaoId=" + questaoId + "]";
	}

}
