package com.sas.desafio.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Simulado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private BigDecimal nota;

	@Column(name = "data_criacao")
	private LocalDate dataCriacao;

	public Simulado() {
		super();
	}

	public Simulado(Long id, String titulo, BigDecimal nota, LocalDate dataCriacao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.nota = nota;
		this.dataCriacao = dataCriacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public BigDecimal getNota() {
		return nota;
	}

	public void setNota(BigDecimal nota) {
		this.nota = nota;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public String toString() {
		return "Simulado [id=" + id + ", titulo=" + titulo + ", nota=" + nota + ", dataCriacao=" + dataCriacao + "]";
	}

}
