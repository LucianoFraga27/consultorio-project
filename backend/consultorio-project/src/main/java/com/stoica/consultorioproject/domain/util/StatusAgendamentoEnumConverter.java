package com.stoica.consultorioproject.domain.util;

import com.stoica.consultorioproject.domain.model.StatusAgendamento;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusAgendamentoEnumConverter implements AttributeConverter<StatusAgendamento, String>{

	@Override
	public String convertToDatabaseColumn(StatusAgendamento attribute) {
		// TODO Auto-generated method stub
		return attribute.toString();
	}

	@Override
	public StatusAgendamento convertToEntityAttribute(String dbData) {
		// TODO Auto-generated method stub
		return StatusAgendamento.fromString(dbData);
	}


	
}
