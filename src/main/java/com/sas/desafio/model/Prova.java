package com.sas.desafio.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Prova {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "area_conhecimento")
	private String areaConhecimento;

	@ManyToMany(mappedBy = "provas")
	private List<Simulado> simulados;

	@ManyToMany
	@JoinTable(name = "prova_questoes", joinColumns = @JoinColumn(name = "prova_id"), inverseJoinColumns = @JoinColumn(name = "questao_id"))
	private List<Questao> questoes;

	public Prova() {
		super();
	}

	public Prova(Long id, String areaConhecimento, List<Questao> questoes) {
		super();
		this.id = id;
		this.areaConhecimento = areaConhecimento;
		this.questoes = questoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAreaConhecimento() {
		return areaConhecimento;
	}

	public void setAreaConhecimento(String areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

	@Override
	public String toString() {
		return "Prova [id=" + id + ", areaConhecimento=" + areaConhecimento + ", questoes=" + questoes + "]";
	}

}
