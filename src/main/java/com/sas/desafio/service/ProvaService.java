package com.sas.desafio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sas.desafio.model.Prova;
import com.sas.desafio.model.Questao;
import com.sas.desafio.repository.ProvaRepository;
import com.sas.desafio.repository.QuestaoRepository;
import com.sas.desafio.util.ProvaRequest;

@Service
public class ProvaService {

	@Autowired
	private QuestaoRepository questaoRepository;

	@Autowired
	private ProvaRepository provaRepository;

	public Prova criarProva(ProvaRequest provaRequest) {
		Prova novaProva = new Prova();
		List<Questao> questoesSalvas = questaoRepository.findAllById(provaRequest.getQuestoesId());

		checkQuestoes(provaRequest.getQuestoesId(), questoesSalvas);

		checkNivelQuestoes(questoesSalvas);

		novaProva.setAreaConhecimento(provaRequest.getAreaConhecimento());
		novaProva.setQuestoes(questoesSalvas);

		provaRepository.save(novaProva);

		return novaProva;
	}

	private void checkQuestoes(List<Long> requestIds, List<Questao> questoesSalvas) {
		List<Long> notContainsId = new ArrayList<Long>();

		if (requestIds.size() <= 0) {

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Por favor, insira os ids das questões que compõem a prova!");
		}

		for (int i = 0; i < requestIds.size(); i++) {
			Boolean has = false;

			for (int j = 0; j < questoesSalvas.size(); j++) {
				if (requestIds.get(i) == questoesSalvas.get(j).getId()) {
					has = true;

				}
			}

			if (has == false) {
				notContainsId.add(requestIds.get(i));
			}

		}

		if (notContainsId.size() > 0) {
			throw new EmptyResultDataAccessException("Questões não encontradas: " + notContainsId.toString(),
					requestIds.size());
		}

	}

	private void checkNivelQuestoes(List<Questao> questoes) {
		Integer countFacil = 0;
		Integer countMedia = 0;
		Integer countDificil = 0;

		for (Questao questao : questoes) {
			switch (questao.getNivel()) {
			case FACIL:
				countFacil++;
				break;
			case MEDIA:
				countMedia++;
				break;
			case DIFICIL:
				countDificil++;
				break;
			default:
				break;
			}
		}

		if (countFacil != 3 || countMedia != 4 || countDificil != 3) {

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Uma prova deve conter 3 questões fáceis, 4 medianas e 3 difíceis, verifique novamente!");

		}

	}

}
