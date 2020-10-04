package com.maurilioalm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maurilioalm.entidades.Pessoa;
import com.maurilioalm.repository.PessoaRepository;
import com.maurilioalm.service.exceptions.ResourceNotFoundException;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;
	
	public Pessoa findById(Long id) {
		Optional<Pessoa> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public List<Pessoa> findAll(){
		return repository.findAll();
	}
	
	public void insert(Pessoa pessoa) {
		repository.save(pessoa);
	}
	
	public void update(Long id, Pessoa pessoa) {
		Pessoa pessoaDesatualizada = findById(id);
		updateData(pessoaDesatualizada, pessoa);
		repository.save(pessoaDesatualizada);	
	}
	
	private void updateData(Pessoa pessoaDesatualizada, Pessoa pessoa) {
		pessoaDesatualizada.setNome(pessoa.getNome());
		pessoaDesatualizada.setSenha(pessoa.getSenha());
		pessoaDesatualizada.setEmail(pessoa.getEmail());
	}

	public void delete(Long id) {
		Pessoa pessoa = findById(id);
		repository.delete(pessoa);
	}
	
}
