package com.maurilioalm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maurilioalm.entidades.Telefone;
import com.maurilioalm.repository.TelefoneRepository;
import com.maurilioalm.service.exceptions.ResourceNotFoundException;

@Service
public class TelefoneService {
	
	@Autowired
	private TelefoneRepository telefoneRepo;
	
	public Telefone findById(Long id) {
		Optional<Telefone> telefone = telefoneRepo.findById(id);
		return telefone.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public List<Telefone> findAll(){
		return telefoneRepo.findAll();
	}
	
	public void insert(Telefone telefone) {
		telefoneRepo.save(telefone);
	}
	
	public void update(Long id, Telefone telefone) {
		Telefone telefoneDesatualizado = findById(id);
		updateData(telefoneDesatualizado, telefone);
		telefoneRepo.save(telefoneDesatualizado);
	}
	
	private void updateData(Telefone telefoneDesatualizado, Telefone telefone) {
		telefoneDesatualizado.setDdd(telefone.getDdd());
		telefoneDesatualizado.setNumero(telefone.getNumero());
		telefoneDesatualizado.setTipo(telefone.getTipo());
	}

	public void delete(Long id) {
		Telefone telefone = findById(id);
		telefoneRepo.delete(telefone);
	}
	
}
