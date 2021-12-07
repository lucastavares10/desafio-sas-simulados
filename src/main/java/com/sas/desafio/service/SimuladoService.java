package com.sas.desafio.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sas.desafio.model.Prova;
import com.sas.desafio.model.Simulado;
import com.sas.desafio.repository.ProvaRepository;
import com.sas.desafio.repository.SimuladoRepository;
import com.sas.desafio.util.SimuladoRequest;

@Service
public class SimuladoService {

	@Autowired
	private ProvaRepository provaRepository;

	@Autowired
	private SimuladoRepository simuladoRepository;

	public Simulado criarSimulado(SimuladoRequest simuladoRequest) {
		List<Prova> provasSalvas = provaRepository.findAllById(simuladoRequest.getProvasId());

		checkSimulados(simuladoRequest.getProvasId(), provasSalvas);

		Simulado novoSimulado = new Simulado(simuladoRequest.getTitulo(), LocalDate.now(), provasSalvas);

		simuladoRepository.save(novoSimulado);

		return novoSimulado;
	}

	public void checkSimulados(List<Long> requestIds, List<Prova> provasSalvas) {

		List<Long> notContainsId = new ArrayList<Long>();

		for (int i = 0; i < requestIds.size(); i++) {
			Boolean has = false;

			for (int j = 0; j < provasSalvas.size(); j++) {
				if (requestIds.get(i) == provasSalvas.get(j).getId()) {
					has = true;
				}
			}

			if (has == false) {
				notContainsId.add(requestIds.get(i));
			}

		}

		if (notContainsId.size() > 0) {
			throw new EmptyResultDataAccessException("Provas não encontradas: " + notContainsId.toString(),
					requestIds.size());
		}

	}

}
