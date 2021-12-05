package com.sas.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sas.desafio.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
