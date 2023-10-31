package com.hard.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.hard.entities.Funcionario;
import com.hard.services.FuncionarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	private final FuncionarioService FuncionarioService;

	@Autowired
	public FuncionarioController(FuncionarioService FuncionarioService) {
		this.FuncionarioService = FuncionarioService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> buscaFuncionarioControlId(@PathVariable Long id) {
		Funcionario Funcionario = FuncionarioService.getFuncionarioById(id);
		if (Funcionario != null) {
			return ResponseEntity.ok(Funcionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Funcionario>> buscaTodasLigacoesControl() {
		List<Funcionario> Funcionario = FuncionarioService.getAllFuncionarios();
		return ResponseEntity.ok(Funcionario);
	}

	@PostMapping("/")
	public ResponseEntity<Funcionario> saveFuncionarioControl(@RequestBody @Valid Funcionario Funcionario) {
		Funcionario saveFuncionario = FuncionarioService.saveFuncionario(Funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveFuncionario);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> alteraFuncionarioControl(@PathVariable Long id, @RequestBody @Valid Funcionario Funcionario) {
		Funcionario alteraFuncionario = FuncionarioService.changeFuncionario(id, Funcionario);

		if (alteraFuncionario != null) {
			return ResponseEntity.ok(Funcionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteFuncionarioControl(@PathVariable Long id) {
		boolean delete = FuncionarioService.deleteFuncionario(id);
		if (delete) {
			return ResponseEntity.ok().body("O Funcionario foi excluido com o sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}