package com.sas.desafio.util;

import java.util.List;

public class ProvaRequest {
	private String titulo;

	private List<Long> questoesId;

	private String areaConhecimento;

	public ProvaRequest() {
		super();
	}

	public ProvaRequest(String titulo, List<Long> questoesId, String areaConhecimento) {
		super();
		this.titulo = titulo;
		this.questoesId = questoesId;
		this.areaConhecimento = areaConhecimento;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Long> getQuestoesId() {
		return questoesId;
	}

	public void setQuestoesId(List<Long> questoesId) {
		this.questoesId = questoesId;
	}

	public String getAreaConhecimento() {
		return areaConhecimento;
	}

	public void setAreaConhecimento(String areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}

	@Override
	public String toString() {
		return "ProvaRequest [titulo=" + titulo + ", questoesId=" + questoesId + ", areaConhecimento="
				+ areaConhecimento + "]";
	}

}
