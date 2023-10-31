package com.hard.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hard.entities.Funcionario;
import com.hard.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	private final FuncionarioRepository FuncionarioRepository;
	

	@Autowired
	public FuncionarioService(FuncionarioRepository FuncionarioRepository) {
		this.FuncionarioRepository = FuncionarioRepository;
	}

	public List<Funcionario> getAllFuncionarios() {
		return FuncionarioRepository.findAll();
	}

	public Funcionario getFuncionarioById(Long id) {
		Optional<Funcionario> Funcionario = FuncionarioRepository.findById(id);
		return Funcionario.orElse(null);
	}

	public Funcionario saveFuncionario(Funcionario Funcionario) {
		return FuncionarioRepository.save(Funcionario);
	}

	public Funcionario changeFuncionario(Long id, Funcionario changeU) {
		Optional<Funcionario> existeFuncionario = FuncionarioRepository.findById(id);
		if (existeFuncionario.isPresent()) {
			changeU.setId(id);
			return FuncionarioRepository.save(changeU);
		}
		return null;
	}

	public boolean deleteFuncionario(Long id) {
		Optional<Funcionario> existeFuncionario= FuncionarioRepository.findById(id);
		if (existeFuncionario.isPresent()) {
			FuncionarioRepository.deleteById(id);
			return true;
		}
		return false;
	}

}