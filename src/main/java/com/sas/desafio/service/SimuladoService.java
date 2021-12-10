package com.sas.desafio.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sas.desafio.model.Aluno;
import com.sas.desafio.model.Gabarito;
import com.sas.desafio.model.Nota;
import com.sas.desafio.model.Prova;
import com.sas.desafio.model.Questao;
import com.sas.desafio.model.RespostaAluno;
import com.sas.desafio.model.Simulado;
import com.sas.desafio.model.tipos.TipoSimuladoStatus;
import com.sas.desafio.repository.AlunoRepository;
import com.sas.desafio.repository.NotaRepository;
import com.sas.desafio.repository.ProvaRepository;
import com.sas.desafio.repository.RespostaAlunoRepository;
import com.sas.desafio.repository.SimuladoRepository;
import com.sas.desafio.util.SimuladoRequest;

@Service
public class SimuladoService {

	@Autowired
	private ProvaRepository provaRepository;

	@Autowired
	private SimuladoRepository simuladoRepository;

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private NotaRepository notaRepository;

	@Autowired
	RespostaAlunoRepository respostaAlunoRepository;

	public Simulado criarSimulado(SimuladoRequest simuladoRequest) {
		List<Prova> provasSalvas = provaRepository.findAllById(simuladoRequest.getProvasId());

		checkSimulados(simuladoRequest.getProvasId(), provasSalvas);

		Simulado novoSimulado = new Simulado(simuladoRequest.getTitulo(), LocalDate.now(), provasSalvas);

		simuladoRepository.save(novoSimulado);

		return novoSimulado;
	}

	public void inscreveAluno(Long simuladoId, Long alunoId) {
		Simulado simuladoSalvo = simuladoRepository.getById(simuladoId);
		Aluno alunoSalvo = alunoRepository.getById(alunoId);

		checkSimuladoStatus(simuladoSalvo);

		Boolean hasIncricao = false;

		for (Aluno aluno : simuladoSalvo.getAlunos()) {
			if (aluno.getId() == alunoSalvo.getId()) {
				hasIncricao = true;
			}
		}

		if (!hasIncricao) {
			simuladoSalvo.addAlunos(alunoSalvo);
			simuladoRepository.save(simuladoSalvo);
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aluno já inscrito no simulado informado!");
		}

	}

	public BigDecimal calculaNota(List<RespostaAluno> respostas, Gabarito gabarito) {
		BigDecimal nota = new BigDecimal(0);

		return nota;
	}

	public void encerraSimulado(Long id) {
		Simulado simuladoSalvo = simuladoRepository.getById(id);
		List<RespostaAluno> listaRespostas = respostaAlunoRepository.findAllBySimulado(simuladoSalvo.getId());

		checkSimuladoStatus(simuladoSalvo);

		notaRepository.saveAll(calculaNotaAlunos(simuladoSalvo, listaRespostas));

		simuladoSalvo.setStatus(TipoSimuladoStatus.CONCLUIDO);
		simuladoRepository.save(simuladoSalvo);
	}

	private void checkSimuladoStatus(Simulado simulado) {

		if (simulado.getStatus() != TipoSimuladoStatus.EM_ANDAMENTO) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Simulado não disponível! Status: " + simulado.getStatus());
		}

	}

	private void checkSimulados(List<Long> requestIds, List<Prova> provasSalvas) {
		List<Long> notContainsId = new ArrayList<Long>();

		if (requestIds.size() <= 0) {
			throw new NullPointerException("Por favor, insira os ids das provas que compõem o simulado! ");
		}

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

	private List<Nota> calculaNotaAlunos(Simulado simuladoSalvo, List<RespostaAluno> listaRespostas) {
		List<Nota> notasAlunos = new ArrayList<Nota>();

		for (Aluno aluno : simuladoSalvo.getAlunos()) {
			BigDecimal somaProvas = new BigDecimal(0);
			Nota notaAluno = new Nota();

			for (Prova prova : simuladoSalvo.getProvas()) {
				Integer countQf = 0;
				Integer countQm = 0;
				Integer countQd = 0;

				for (Questao questao : prova.getQuestoes()) {
					for (RespostaAluno resposta : listaRespostas) {

						if (aluno.getId() == resposta.getAlunoId() && prova.getId() == resposta.getProvaId()
								&& questao.getId() == resposta.getQuestaoId()
								&& questao.getRespostaCorreta() == resposta.getResposta()) {

							switch (questao.getNivel()) {
							case FACIL:
								countQf++;
								break;
							case MEDIA:
								countQm++;
								break;
							case DIFICIL:
								countQd++;
								break;
							default:
								break;
							}

						}

					}

				}

				somaProvas = somaProvas.add(new BigDecimal((countQf * 15) + (countQm * 12) + (countQd * 8) + 600));

			}

			notaAluno.setNota(somaProvas.divide(new BigDecimal(2)));
			notaAluno.setAluno(aluno);
			notaAluno.setSimuladoId(simuladoSalvo.getId());

			notasAlunos.add(notaAluno);

		}

		return notasAlunos;

	}

}
