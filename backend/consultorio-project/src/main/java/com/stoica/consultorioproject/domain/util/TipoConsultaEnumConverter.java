package com.stoica.consultorioproject.domain.util;

import com.stoica.consultorioproject.domain.model.StatusAgendamento;
import com.stoica.consultorioproject.domain.model.TipoConsulta;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TipoConsultaEnumConverter implements AttributeConverter<TipoConsulta, String>{

	
	
	@Override
	public String convertToDatabaseColumn(TipoConsulta attribute) {
		// TODO Auto-generated method stub
		return attribute.toString();
	}

	@Override
	public TipoConsulta convertToEntityAttribute(String dbData) {
		// TODO Auto-generated method stub
		return TipoConsulta.fromString(dbData);
	}

}
