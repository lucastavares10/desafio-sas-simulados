package com.sas.desafio.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sas.desafio.model.Prova;
import com.sas.desafio.model.Simulado;
import com.sas.desafio.repository.ProvaRepository;
import com.sas.desafio.repository.SimuladoRepository;
import com.sas.desafio.util.request.SimuladoRequest;

@RestController
@RequestMapping("/simulados")
public class SimuladoResource {

	@Autowired
	private SimuladoRepository simuladoRepository;

	@Autowired
	private ProvaRepository provaRepository;

	@GetMapping
	public List<Simulado> listar() {
		return simuladoRepository.findAll();
	}

	@GetMapping("/{id}")
	public Simulado buscaPorId(@PathVariable Long id) {
		return simuladoRepository.getById(id);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void criar(@RequestBody SimuladoRequest simuladoRequest) {

		List<Prova> provas = provaRepository.findAllById(simuladoRequest.getProvasId());

		for (Prova prova : provas) {
			System.out.println(prova);
			
		}

	}

}
