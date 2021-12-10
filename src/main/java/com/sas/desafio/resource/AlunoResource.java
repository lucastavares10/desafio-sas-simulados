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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sas.desafio.model.Aluno;
import com.sas.desafio.repository.AlunoRepository;

@RestController
@RequestMapping("/alunos")
public class AlunoResource {

	@Autowired
	private AlunoRepository alunoRepository;

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Aluno> listar() {
		return alunoRepository.findAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Aluno buscaPorId(@PathVariable Long id) {
		return alunoRepository.getById(id);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Aluno criar(@RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		alunoRepository.deleteById(id);
	}

}
