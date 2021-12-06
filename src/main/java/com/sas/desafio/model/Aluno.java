package com.sas.desafio.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;

	@ManyToMany
	@JoinTable(name = "aluno_simulado", joinColumns = @JoinColumn(name = "aluno_id"), inverseJoinColumns = @JoinColumn(name = "simulado_id"))
	private List<Simulado> simulados;

	public Aluno() {
		super();
	}

	public Aluno(Long id, String nome, String cpf, List<Simulado> simulados) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.simulados = simulados;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Simulado> getSimulados() {
		return simulados;
	}

	public void setSimulados(List<Simulado> simulados) {
		this.simulados = simulados;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", simulados=" + simulados + "]";
	}

}
