package com.sas.desafio.model;

import java.util.List;
import java.util.Map;

import com.sas.desafio.model.tipos.TipoResposta;

public class Gabarito {

	private Long idProva;

	private String areaConhecimento;

	private List<Map<Integer, TipoResposta>> respostas;

	public Gabarito() {
		super();
	}

	public Gabarito(Long idProva, String areaConhecimento, List<Map<Integer, TipoResposta>> respostas) {
		super();
		this.idProva = idProva;
		this.areaConhecimento = areaConhecimento;
		this.respostas = respostas;
	}

	public Long getIdProva() {
		return idProva;
	}

	public void setIdProva(Long idProva) {
		this.idProva = idProva;
	}

	public String getAreaConhecimento() {
		return areaConhecimento;
	}

	public void setAreaConhecimento(String areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}

	public List<Map<Integer, TipoResposta>> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Map<Integer, TipoResposta>> respostas) {
		this.respostas = respostas;
	}

	@Override
	public String toString() {
		return "Gabarito [idProva=" + idProva + ", areaConhecimento=" + areaConhecimento + ", respostas=" + respostas
				+ "]";
	}

}
