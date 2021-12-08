package com.sas.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sas.desafio.model.Questao;
import com.sas.desafio.model.tipos.TipoNivel;

public interface QuestaoRepository extends JpaRepository<Questao, Long> {

	@Query("SELECT q FROM Questao q WHERE nivel = ?1 AND area_conhecimento = ?2")
	List<Questao> findAllWithParams(TipoNivel nivel, String area);

}
