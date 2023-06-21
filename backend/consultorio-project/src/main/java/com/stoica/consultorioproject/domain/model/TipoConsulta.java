package com.stoica.consultorioproject.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum TipoConsulta {

	PARTICULAR("PARTICULAR"), CONVENIO("CONVENIO");

	private final String tipoConsulta;

	private TipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}

	public static TipoConsulta fromString(String tipoConsultaValueString) {
		switch (tipoConsultaValueString) {
			case "PARTICULAR" -> {
				return PARTICULAR;
			}
			case "CONVENIO" -> {
				return CONVENIO;
			}
			default -> {
				throw new RuntimeException("Valor invalido para tipo de consulta [" + tipoConsultaValueString + "]");
			}
		}
	}
	
	@Override
	public String toString() {
		
		return tipoConsulta;
	}
	

	
}
