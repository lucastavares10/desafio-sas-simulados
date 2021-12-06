package com.sas.desafio.util.request;

import java.util.List;

public class SimuladoRequest {
	private String titulo;

	private List<Long> provasId;

	public SimuladoRequest() {
		super();
	}

	public SimuladoRequest(String titulo, List<Long> provasId) {
		super();
		this.titulo = titulo;
		this.provasId = provasId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Long> getProvasId() {
		return provasId;
	}

	public void setProvasId(List<Long> provasId) {
		this.provasId = provasId;
	}

	@Override
	public String toString() {
		return "SimuladoRequest [titulo=" + titulo + ", provasId=" + provasId + "]";
	}

}
