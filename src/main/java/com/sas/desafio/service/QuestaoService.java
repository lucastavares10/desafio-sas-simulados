package com.sas.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sas.desafio.dto.ProximaQuestaoDTO;
import com.sas.desafio.model.Prova;
import com.sas.desafio.model.Questao;
import com.sas.desafio.model.RespostaAluno;
import com.sas.desafio.model.Simulado;
import com.sas.desafio.model.tipos.TipoSimuladoStatus;
import com.sas.desafio.repository.AlunoRepository;
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

	public void responderQuestao(RespostaAluno respostaAluno) {
		List<RespostaAluno> ra = respostaAlunoRepository.findAlreadyExist(respostaAluno.getAlunoId(),
				respostaAluno.getSimuladoId(), respostaAluno.getProvaId(), respostaAluno.getQuestaoId());
		List<Simulado> simulados = simuladoRepository.findAllbyAlunoAndStatus(respostaAluno.getAlunoId(),
				TipoSimuladoStatus.EM_ANDAMENTO);

		checkRespostaValida(respostaAluno, simulados);

		respostaAlunoRepository.deleteAll(ra);
		respostaAlunoRepository.save(respostaAluno);
	}

	public ProximaQuestaoDTO proximaQuestao(Long alunoId) {
		List<RespostaAluno> listaRespostas = respostaAlunoRepository.findAllByAluno(alunoId);
		List<Simulado> simulados = simuladoRepository.findAllbyAlunoAndStatus(alunoId, TipoSimuladoStatus.EM_ANDAMENTO);

		if (simulados.size() <= 0) {
			throw new EmptyResultDataAccessException("Não há simulados disponíveis para o aluno!", 1);
		}

		return searchProximaQuestao(alunoId, simulados, listaRespostas);
	}

	private void checkRespostaValida(RespostaAluno respostaAluno, List<Simulado> simulados) {
		Boolean exists = false;

		for (Simulado simulado : simulados) {
			for (Prova prova : simulado.getProvas()) {
				for (Questao questao : prova.getQuestoes()) {
					if (simulado.getId() == respostaAluno.getSimuladoId() && prova.getId() == respostaAluno.getProvaId()
							&& questao.getId() == respostaAluno.getQuestaoId()) {
						exists = true;
					}
				}
			}

		}

		if (exists == false) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Questão não disponível!");
		}

	}

	private ProximaQuestaoDTO searchProximaQuestao(Long alunoId, List<Simulado> simulados,
			List<RespostaAluno> listaRespostas) {
		ProximaQuestaoDTO proximaQuestao = new ProximaQuestaoDTO();

		for (Simulado simulado : simulados) {
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
