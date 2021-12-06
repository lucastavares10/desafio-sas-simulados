package com.sas.desafio.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sas.desafio.model.Gabarito;
import com.sas.desafio.model.Prova;
import com.sas.desafio.repository.ProvaRepository;
import com.sas.desafio.service.GabaritoService;

@RestController
@RequestMapping("/gabaritos")
public class GabaritoResource {

	@Autowired
	private ProvaRepository provaRepository;

	@Autowired
	private GabaritoService gabaritoService;

	@GetMapping
	public List<Gabarito> listar() {
		return gabaritoService.listaTodosGabaritos();
	}

	@GetMapping("/{id}")
	public Gabarito buscaPorIdProva(@PathVariable Long id) {
		Prova prova = provaRepository.getById(id);

		return gabaritoService.retornaGabarito(prova);
	}

}
