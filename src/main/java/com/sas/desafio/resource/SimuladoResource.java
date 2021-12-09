package com.sas.desafio.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sas.desafio.model.Simulado;
import com.sas.desafio.repository.SimuladoRepository;
import com.sas.desafio.service.SimuladoService;
import com.sas.desafio.util.SimuladoRequest;

@RestController
@RequestMapping("/simulados")
public class SimuladoResource {

	@Autowired
	private SimuladoRepository simuladoRepository;

	@Autowired
	private SimuladoService simuladoService;

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
	public ResponseEntity<Simulado> criar(@RequestBody SimuladoRequest simuladoRequest) {

		Simulado simuladoSalvo = simuladoService.criarSimulado(simuladoRequest);

		return ResponseEntity.status(HttpStatus.CREATED).body(simuladoSalvo);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {

		simuladoService.encerraSimulado(id);
	}

	@PutMapping("/{simuladoId}/inscricao/{alunoId}")
	@ResponseStatus(code = HttpStatus.OK)
	public void inscricaoAluno(@PathVariable Long simuladoId, @PathVariable Long alunoId) {

		simuladoService.inscreveAluno(simuladoId, alunoId);
	}

}
