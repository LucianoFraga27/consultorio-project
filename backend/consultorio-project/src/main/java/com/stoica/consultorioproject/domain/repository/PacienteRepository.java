package com.stoica.consultorioproject.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stoica.consultorioproject.domain.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}
