package com.sas.desafio.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sas.desafio.model.Prova;
import com.sas.desafio.repository.ProvaRepository;

@RestController
@RequestMapping("/provas")
public class ProvaResource {

	@Autowired
	private ProvaRepository provaRepository;

	@GetMapping
	public List<Prova> listar(@RequestParam(required = false) String area) {
		return provaRepository.findAll();
	}

	@GetMapping("/{id}")
	public Prova buscaPorId(@PathVariable Long id) {
		return provaRepository.getById(id);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {

		provaRepository.deleteById(id);
	}

}
