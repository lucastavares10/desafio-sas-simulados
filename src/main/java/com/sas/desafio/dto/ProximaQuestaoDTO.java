package com.sas.desafio.dto;

import com.sas.desafio.model.Questao;

public class ProximaQuestaoDTO {

	private Long alunoId;

	private Long simuladoId;

	private Long provaId;

	private Questao questao;

	public ProximaQuestaoDTO() {
		super();
	}

	public ProximaQuestaoDTO(Long alunoId, Long simuladoId, Long provaId, Questao questao) {
		super();
		this.alunoId = alunoId;
		this.simuladoId = simuladoId;
		this.provaId = provaId;
		this.questao = questao;
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

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	@Override
	public String toString() {
		return "ProximaQuestaoDTO [alunoId=" + alunoId + ", simuladoId=" + simuladoId + ", provaId=" + provaId
				+ ", questao=" + questao + "]";
	}

}
