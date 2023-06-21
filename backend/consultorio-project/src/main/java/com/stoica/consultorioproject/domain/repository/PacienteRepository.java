package com.stoica.consultorioproject.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stoica.consultorioproject.domain.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

	Optional<Paciente> findByCPF(String CPF);
	Optional<Paciente> findByEmail(String email);
	List<Paciente> findByNomeContaining(String nome);

}
