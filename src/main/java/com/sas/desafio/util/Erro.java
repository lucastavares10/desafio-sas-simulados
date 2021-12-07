package com.sas.desafio.util;

public class Erro {

	private String mesangemUsuario;
	private String mensagemDesenvolvedor;

	public Erro(String mesangemUsuario, String mensagemDesenvolvedor) {
		super();
		this.mesangemUsuario = mesangemUsuario;
		this.mensagemDesenvolvedor = mensagemDesenvolvedor;
	}

	public String getMesangemUsuario() {
		return mesangemUsuario;
	}

	public String getMensagemDesenvolvedor() {
		return mensagemDesenvolvedor;
	}

}
