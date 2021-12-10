package com.sas.desafio.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sas.desafio.dto.RankingDTO;
import com.sas.desafio.service.RankingService;

@RestController
@RequestMapping("/ranking")
public class RankingResource {

	@Autowired
	private RankingService rankingService;

	@GetMapping("/{simuladoId}")
	public List<RankingDTO> lista(@PathVariable Long simuladoId) {
		
		return rankingService.retornaRanking(simuladoId);
	}

}
