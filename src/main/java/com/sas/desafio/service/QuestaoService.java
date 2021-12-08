package com.sas.desafio.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sas.desafio.dto.ProximaQuestaoDTO;
import com.sas.desafio.model.Aluno;
import com.sas.desafio.model.Gabarito;
import com.sas.desafio.model.Prova;
import com.sas.desafio.model.Questao;
import com.sas.desafio.model.RespostaAluno;
import com.sas.desafio.model.Simulado;
import com.sas.desafio.model.tipos.TipoResposta;
import com.sas.desafio.repository.AlunoRepository;
import com.sas.desafio.repository.ProvaRepository;
import com.sas.desafio.repository.RespostaAlunoRepository;
import com.sas.desafio.repository.SimuladoRepository;

@Service
public class QuestaoService {

	@Autowired
	RespostaAlunoRepository respostaAlunoRepository;

	@Autowired
	AlunoRepository alunoRepository;

	@Autowired
	SimuladoRepository simuladoRepository;

	public ProximaQuestaoDTO proximaQuestao(Long alunoId) {
		ProximaQuestaoDTO proximaQuestao = new ProximaQuestaoDTO();
		List<RespostaAluno> listaRespostas = respostaAlunoRepository.findAllByAluno(alunoId);

		Aluno aluno = alunoRepository.getById(alunoId);

		if (aluno.getSimulados().size() <= 0) {
			throw new EmptyResultDataAccessException("Aluno não está participando de nenhum simulado!", 1);
		}

		for (Simulado simulado : aluno.getSimulados()) {

			for (Prova prova : simulado.getProvas()) {

				for (Questao questao : prova.getQuestoes()) {
					Boolean solved = false;
					for (RespostaAluno respostaAluno : listaRespostas) {
						if (simulado.getId() == respostaAluno.getSimuladoId()
								&& prova.getId() == respostaAluno.getProvaId()
								&& questao.getId() == respostaAluno.getQuestaoId()) {
							solved = true;
						}
					}

					if (solved == false) {
						proximaQuestao.setAlunoId(alunoId);
						proximaQuestao.setProvaId(prova.getId());
						proximaQuestao.setSimuladoId(simulado.getId());
						proximaQuestao.setQuestao(questao);

						return proximaQuestao;
					}
				}
			}
		}

		return proximaQuestao;
	}

}
