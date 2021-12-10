package com.sas.desafio.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sas.desafio.dto.ProximaQuestaoDTO;
import com.sas.desafio.model.Questao;
import com.sas.desafio.model.RespostaAluno;
import com.sas.desafio.model.tipos.TipoNivel;
import com.sas.desafio.repository.QuestaoRepository;
import com.sas.desafio.service.QuestaoService;

@RestController
@RequestMapping("/questoes")
public class QuestaoResource {

	@Autowired
	private QuestaoRepository questaoRepository;

	@Autowired
	private QuestaoService questaoService;

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Questao> listar(@RequestParam(required = false) String nivel,
			@RequestParam(required = false) String area) {

		if (nivel != null && area != null) {
			return questaoRepository.findAllWithParams(TipoNivel.valueOf(nivel), area.toUpperCase());
		} else {
			return questaoRepository.findAll();
		}
	}

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Questao buscaPorId(@PathVariable Long id) {
		return questaoRepository.getById(id);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Questao criar(@RequestBody Questao questao) {
		return questaoRepository.save(questao);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		questaoRepository.deleteById(id);
	}

	@GetMapping("/proxima/{alunoId}")
	@ResponseStatus(code = HttpStatus.OK)
	public ProximaQuestaoDTO buscaProximaQuestao(@PathVariable Long alunoId) {
		return questaoService.proximaQuestao(alunoId);
	}

	@PostMapping("/responder")
	@ResponseStatus(code = HttpStatus.OK)
	public void responderQuestao(@RequestBody RespostaAluno respostaAluno) {
		questaoService.responderQuestao(respostaAluno);
	}

}
