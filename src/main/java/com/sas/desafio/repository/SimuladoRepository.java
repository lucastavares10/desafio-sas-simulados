package com.sas.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sas.desafio.model.Simulado;
import com.sas.desafio.model.tipos.TipoSimuladoStatus;

public interface SimuladoRepository extends JpaRepository<Simulado, Long> {

	@Query("SELECT s FROM Simulado s JOIN s.alunos a WHERE a.id = ?1 AND s.status = ?2 ORDER BY s.id")
	List<Simulado> findAllbyAlunoAndStatus(Long alunoId, TipoSimuladoStatus status);

}
