package com.sas.desafio.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.desafio.model.Gabarito;
import com.sas.desafio.model.Prova;
import com.sas.desafio.model.Questao;
import com.sas.desafio.model.tipos.TipoResposta;
import com.sas.desafio.repository.ProvaRepository;

@Service
public class GabaritoService {

	@Autowired
	private ProvaRepository provaRepository;

	public List<Gabarito> listaTodosGabaritos() {
		List<Gabarito> gabaritos = new ArrayList<Gabarito>();

		List<Prova> provas = provaRepository.findAll();

		for (Prova prova : provas) {
			gabaritos.add(retornaGabarito(prova));
		}

		return gabaritos;
	}

	public Gabarito retornaGabarito(Prova prova) {
		Gabarito novoGabarito = new Gabarito();

		novoGabarito.setIdProva(prova.getId());
		novoGabarito.setAreaConhecimento(prova.getAreaConhecimento());
		novoGabarito.setRespostas(getRespostasMap(prova.getQuestoes()));

		return novoGabarito;
	}

	private List<Map<Integer, TipoResposta>> getRespostasMap(List<Questao> questoes) {
		List<Map<Integer, TipoResposta>> respostasMap = new ArrayList<Map<Integer, TipoResposta>>();

		for (int i = 0; i < questoes.size(); i++) {
			Map<Integer, TipoResposta> novaResposta = new HashMap<>();
			
			novaResposta.put(i + 1, questoes.get(i).getRespostaCorreta());
			
			respostasMap.add(novaResposta);
		}

		return respostasMap;
	}

}
