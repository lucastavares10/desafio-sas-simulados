package com.sas.desafio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sas.desafio.model.tipos.TipoNivel;
import com.sas.desafio.model.tipos.TipoResposta;

@Entity
public class Questao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String pergunta;

	@Enumerated(EnumType.STRING)
	private TipoNivel nivel;

	@Enumerated(EnumType.STRING)
	@Column(name = "resposta_correta")
	private TipoResposta respostaCorreta;

	public Questao() {
		super();
	}

	public Questao(Long id, String pergunta, TipoNivel nivel, TipoResposta respostaCorreta) {
		super();
		this.id = id;
		this.pergunta = pergunta;
		this.nivel = nivel;
		this.respostaCorreta = respostaCorreta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public TipoNivel getNivel() {
		return nivel;
	}

	public void setNivel(TipoNivel nivel) {
		this.nivel = nivel;
	}

	public TipoResposta getRespostaCorreta() {
		return respostaCorreta;
	}

	public void setRespostaCorreta(TipoResposta respostaCorreta) {
		this.respostaCorreta = respostaCorreta;
	}

	@Override
	public String toString() {
		return "Questao [id=" + id + ", pergunta=" + pergunta + ", nivel=" + nivel + ", respostaCorreta="
				+ respostaCorreta + "]";
	}

}
