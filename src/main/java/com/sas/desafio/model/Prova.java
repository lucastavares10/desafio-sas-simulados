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

@Entity
public class Prova {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "area_conhecimento")
	private String areaConhecimento;

	private Boolean finalizada;

	@ManyToMany(mappedBy = "provas")
	private List<Simulado> simulados;

	@ManyToMany
	@JoinTable(name = "prova_questoes", joinColumns = @JoinColumn(name = "prova_id"), inverseJoinColumns = @JoinColumn(name = "questao_id"))
	private List<Questao> questoes;

	public Prova() {
		super();
	}

	public Prova(Long id, String areaConhecimento, Boolean finalizada, List<Questao> questoes) {
		super();
		this.id = id;
		this.areaConhecimento = areaConhecimento;
		this.finalizada = finalizada;
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

	public Boolean getFinalizada() {
		return finalizada;
	}

	public void setFinalizada(Boolean finalizada) {
		this.finalizada = finalizada;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

	@Override
	public String toString() {
		return "Prova [id=" + id + ", areaConhecimento=" + areaConhecimento + ", finalizada=" + finalizada
				+ ", questoes=" + questoes + "]";
	}

}
