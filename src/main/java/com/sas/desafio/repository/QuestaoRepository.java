package com.sas.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sas.desafio.model.Questao;

public interface QuestaoRepository extends JpaRepository<Questao, Long> {

}
