package com.hard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hard.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {

}
