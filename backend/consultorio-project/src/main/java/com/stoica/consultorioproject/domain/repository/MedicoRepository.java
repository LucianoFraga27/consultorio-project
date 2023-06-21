package com.stoica.consultorioproject.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stoica.consultorioproject.domain.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

	Optional<Medico> findByCRM(String CRM);
	
}
