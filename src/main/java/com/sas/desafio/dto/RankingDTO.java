package com.sas.desafio.dto;

import java.math.BigDecimal;

public class RankingDTO {

	private String nome;

	private BigDecimal nota;

	private Integer ranking;

	public RankingDTO() {
		super();
	}

	public RankingDTO(String nome, BigDecimal nota, Integer ranking) {
		super();
		this.nome = nome;
		this.nota = nota;
		this.ranking = ranking;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getNota() {
		return nota;
	}

	public void setNota(BigDecimal nota) {
		this.nota = nota;
	}

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	@Override
	public String toString() {
		return "RankingDTO [nome=" + nome + ", nota=" + nota + ", Ranking=" + ranking + "]";
	}

}
