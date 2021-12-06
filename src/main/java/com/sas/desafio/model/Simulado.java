package com.sas.desafio.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sas.desafio.model.tipos.TipoSimuladoStatus;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Simulado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private BigDecimal nota;

	@Enumerated(EnumType.STRING)
	private TipoSimuladoStatus status;

	@Column(name = "data_criacao")
	private LocalDate dataCriacao;

	@ManyToMany(mappedBy = "simulados")
	private List<Aluno> alunos;

	@ManyToMany
	@JoinTable(name = "simulado_prova", joinColumns = @JoinColumn(name = "simulado_id"), inverseJoinColumns = @JoinColumn(name = "prova_id"))
	private List<Prova> provas;

	public Simulado() {
		super();
	}

	public Simulado(Long id, String titulo, BigDecimal nota, TipoSimuladoStatus status, LocalDate dataCriacao,
			List<Prova> provas) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.nota = nota;
		this.status = status;
		this.dataCriacao = dataCriacao;
		this.provas = provas;
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

	public TipoSimuladoStatus getStatus() {
		return status;
	}

	public void setStatus(TipoSimuladoStatus status) {
		this.status = status;
	}

	public List<Prova> getProvas() {
		return provas;
	}

	public void setProvas(List<Prova> provas) {
		this.provas = provas;
	}

	@Override
	public String toString() {
		return "Simulado [id=" + id + ", titulo=" + titulo + ", nota=" + nota + ", status=" + status + ", dataCriacao="
				+ dataCriacao + ", provas=" + provas + "]";
	}

}
