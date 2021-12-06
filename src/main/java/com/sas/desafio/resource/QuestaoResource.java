package com.sas.desafio.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sas.desafio.model.Questao;
import com.sas.desafio.repository.QuestaoRepository;

@RestController
@RequestMapping("/questoes")
public class QuestaoResource {

	@Autowired
	private QuestaoRepository questaoRepository;

	@GetMapping
	public List<Questao> listar(@RequestParam(required = false) String nivel,
			@RequestParam(required = false) String area) {

		System.out.println(nivel + area);

		return questaoRepository.findAll();
	}

}
