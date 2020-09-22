package com.algaworks.crud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.crud.model.Funcionario;
import com.algaworks.crud.repository.FuncionarioRepository;
import com.algaworks.crud.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Override
	public List<Funcionario> obterTodos() {
		return this.funcionarioRepository.findAll();
	}
	
	@Override
	public Funcionario obterPorCodigo(String codigo) {
		return this.funcionarioRepository.findById(codigo).orElseThrow(() -> new IllegalArgumentException("Funconario não exite" ));
	}

	@Override
	public Funcionario criar(Funcionario funcionario) {
		
		Funcionario chefe = this.funcionarioRepository.findById(funcionario.getChefe().getCodigo()).orElseThrow(() -> new IllegalArgumentException("Chefe Inexistente"));
		
		funcionario.setChefe(chefe);
		
		return this.funcionarioRepository.save(funcionario);
	}
	

}
