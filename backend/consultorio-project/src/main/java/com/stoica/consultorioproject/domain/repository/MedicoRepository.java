package com.stoica.consultorioproject.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stoica.consultorioproject.domain.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

}
