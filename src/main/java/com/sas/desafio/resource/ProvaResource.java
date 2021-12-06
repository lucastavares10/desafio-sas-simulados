package com.sas.desafio.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sas.desafio.model.Prova;
import com.sas.desafio.repository.ProvaRepository;

@RestController
@RequestMapping("/provas")
public class ProvaResource {

	@Autowired
	private ProvaRepository provaRepository;

	@GetMapping
	public List<Prova> listart() {

		return provaRepository.findAll();
	}

}
