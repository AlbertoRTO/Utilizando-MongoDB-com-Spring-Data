package com.algaworks.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.algaworks.crud.model.Funcionario;

public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {

}
