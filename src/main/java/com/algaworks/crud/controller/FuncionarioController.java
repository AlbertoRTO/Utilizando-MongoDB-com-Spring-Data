package com.algaworks.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.crud.model.Funcionario;
import com.algaworks.crud.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;

	@GetMapping
	public List<Funcionario> obterTodos() {
		return this.funcionarioService.obterTodos();
		
	}
	
	@GetMapping("/{codigo}")
	public Funcionario obterPorCodigo(@PathVariable String codigo) {
		return this.funcionarioService.obterPorCodigo(codigo); 
	}
	
	@PostMapping
	public Funcionario criar(@RequestBody Funcionario funcionario) {
		return this.funcionarioService.criar(funcionario);
	}
	
	@GetMapping("/range")
	public List<Funcionario> obterFuncionarioPorRangeDeIdade(@RequestParam("de") Integer de, @RequestParam("ate") Integer ate){
		return this.funcionarioService.obterFuncionarioPorRangeDeIdade(de, ate);
	}
	
	@GetMapping("/por-nome")
	public List<Funcionario> obterFuncionarioPorNome(@RequestParam("nome") String nome){
		return this.funcionarioService.obterFuncionarioPorNome(nome);
	}
	
	
}
