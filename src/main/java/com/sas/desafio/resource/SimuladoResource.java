package com.sas.desafio.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sas.desafio.model.Simulado;
import com.sas.desafio.repository.SimuladoRepository;

@RestController
@RequestMapping("/simulados")
public class SimuladoResource {

	@Autowired
	private SimuladoRepository simuladoRepository;

	@GetMapping
	public List<Simulado> listar() {

		return simuladoRepository.findAll();

	}

}
