package com.sas.desafio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prova {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "area_conhecimento")
	private String areaConhecimento;

	private Boolean finalizada;

	public Prova() {
		super();
	}

	public Prova(Long id, String areaConhecimento, Boolean finalizada) {
		super();
		this.id = id;
		this.areaConhecimento = areaConhecimento;
		this.finalizada = finalizada;
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

	@Override
	public String toString() {
		return "Prova [id=" + id + ", areaConhecimento=" + areaConhecimento + ", finalizada=" + finalizada + "]";
	}

}
