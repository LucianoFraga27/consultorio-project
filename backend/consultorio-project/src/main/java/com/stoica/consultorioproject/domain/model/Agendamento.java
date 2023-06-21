package com.stoica.consultorioproject.domain.model;

import java.time.OffsetDateTime;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Agendamento {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Paciente paciente;
	
	@ManyToOne
	private Medico medico;

	@ManyToOne
	private Motivo motivo;
	
	private OffsetDateTime datahora;
	
	private String sintomas;
	
	private StatusAgendamento status;
	
	private TipoConsulta tipo_consulta;
}

