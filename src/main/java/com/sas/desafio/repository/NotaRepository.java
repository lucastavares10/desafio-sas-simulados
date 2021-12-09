package com.sas.desafio.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sas.desafio.model.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {

	@Query("SELECT n FROM Nota n WHERE n.simuladoId = ?1 ORDER BY n.nota DESC")
	List<Nota> findAllRankings(Long simuladoId, Pageable pageable);

}
