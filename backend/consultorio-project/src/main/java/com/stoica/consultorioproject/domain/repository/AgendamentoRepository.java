package com.stoica.consultorioproject.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stoica.consultorioproject.domain.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{

}
