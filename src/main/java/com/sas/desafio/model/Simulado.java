package com.sas.desafio.model;

import java.time.LocalDate;
import java.util.List;

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

import org.hibernate.annotations.DynamicInsert;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sas.desafio.model.tipos.TipoSimuladoStatus;

@Entity
@DynamicInsert
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Simulado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;

	@Enumerated(EnumType.STRING)
	private TipoSimuladoStatus status;

	@Column(name = "data_criacao")
	private LocalDate dataCriacao;

	@ManyToMany
	@JoinTable(name = "aluno_simulado", joinColumns = @JoinColumn(name = "simulado_id"), inverseJoinColumns = @JoinColumn(name = "aluno_id"))
	private List<Aluno> alunos;

	@ManyToMany
	@JoinTable(name = "simulado_prova", joinColumns = @JoinColumn(name = "simulado_id"), inverseJoinColumns = @JoinColumn(name = "prova_id"))
	private List<Prova> provas;

	public Simulado() {
		super();
	}

	public Simulado(String titulo, LocalDate dataCriacao, List<Prova> provas) {
		super();
		this.titulo = titulo;
		this.dataCriacao = dataCriacao;
		this.provas = provas;
	}

	public Simulado(Long id, String titulo, TipoSimuladoStatus status, LocalDate dataCriacao, List<Aluno> alunos,
			List<Prova> provas) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.status = status;
		this.dataCriacao = dataCriacao;
		this.alunos = alunos;
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

	public TipoSimuladoStatus getStatus() {
		return status;
	}

	public void setStatus(TipoSimuladoStatus status) {
		this.status = status;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public void addAlunos(Aluno newAluno) {
		List<Aluno> alunos = this.alunos;
		alunos.add(newAluno);

		this.alunos = alunos;
	}

	public List<Prova> getProvas() {
		return provas;
	}

	public void setProvas(List<Prova> provas) {
		this.provas = provas;
	}

	@Override
	public String toString() {
		return "Simulado [id=" + id + ", titulo=" + titulo + ", status=" + status + ", dataCriacao=" + dataCriacao
				+ ", alunos=" + alunos + ", provas=" + provas + "]";
	}

}
