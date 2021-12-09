package com.sas.desafio.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sas.desafio.model.Aluno;
import com.sas.desafio.model.Prova;
import com.sas.desafio.model.RespostaAluno;
import com.sas.desafio.model.Simulado;
import com.sas.desafio.model.tipos.TipoSimuladoStatus;
import com.sas.desafio.repository.AlunoRepository;
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

	public void encerraSimulado(Long id) {
		Simulado simuladoSalvo = simuladoRepository.getById(id);

		// checkSimuladoStatus(simuladoSalvo);

		for (Aluno aluno : simuladoSalvo.getAlunos()) {
			List<RespostaAluno> listaRespostas = respostaAlunoRepository.findAllByAlunoAndSimulado(aluno.getId(), simuladoSalvo.getId());
			
			for (RespostaAluno respostaAluno : listaRespostas) {
				System.out.println(respostaAluno);
			}

			

		}

		simuladoSalvo.setStatus(TipoSimuladoStatus.CONCLUIDO);
		simuladoRepository.save(simuladoSalvo);

	}

	public void checkSimuladoStatus(Simulado simulado) {

		if (simulado.getStatus() != TipoSimuladoStatus.EM_ANDAMENTO) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Simulado não disponível! Status: " + simulado.getStatus());
		}

	}

	public void checkSimulados(List<Long> requestIds, List<Prova> provasSalvas) {
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

}
