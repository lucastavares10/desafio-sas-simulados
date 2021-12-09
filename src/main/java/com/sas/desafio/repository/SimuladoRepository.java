package com.sas.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sas.desafio.model.Simulado;

public interface SimuladoRepository extends JpaRepository<Simulado, Long> {

	@Query("SELECT s FROM Simulado s JOIN s.alunos a WHERE a.id = ?1 ORDER BY s.id")
	List<Simulado> findAllbyAluno(Long alunoId);

}
