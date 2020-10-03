package com.maurilioalm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maurilioalm.entidades.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

}
