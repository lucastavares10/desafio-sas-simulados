package com.sas.desafio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sas.desafio.dto.RankingDTO;
import com.sas.desafio.model.Nota;
import com.sas.desafio.repository.NotaRepository;

@Service
public class RankingService {

	@Autowired
	private NotaRepository notaRepository;

	public List<RankingDTO> retornaRanking(Long simuladoId) {

		List<RankingDTO> ranking = new ArrayList<RankingDTO>();
		List<Nota> notas = notaRepository.findAllRankings(simuladoId, PageRequest.of(0, 5));

		for (int i = 0; i < notas.size(); i++) {
			Integer position = 1 + i;

			if (i > 0 && notas.get(i - 1).getNota().equals(notas.get(i).getNota())) {
				position = ranking.get(i - 1).getRanking();
			}

			ranking.add(new RankingDTO(notas.get(i).getAluno().getNome(), notas.get(i).getNota(), position));
		}

		return ranking;

	}

}
