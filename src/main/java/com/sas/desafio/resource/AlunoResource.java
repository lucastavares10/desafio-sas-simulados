package com.sas.desafio.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sas.desafio.model.Aluno;
import com.sas.desafio.repository.AlunoRepository;

@RestController
@RequestMapping("/alunos")
public class AlunoResource {

	@Autowired
	private AlunoRepository alunoRepository;

	@GetMapping
	public List<Aluno> listar() {
		return alunoRepository.findAll();
	}

}
