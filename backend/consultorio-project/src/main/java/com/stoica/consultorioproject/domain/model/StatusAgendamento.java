package com.stoica.consultorioproject.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum StatusAgendamento {

	CONFIRMADO("CONFIRMADO"),
	PENDENTE("PENDENTE"),
	CANCELADO("CANCELADO");
	
	private final String statusAgendamento;
	
	private StatusAgendamento(String statusAgendamento) {
        this.statusAgendamento = statusAgendamento;
    }
	
	public static StatusAgendamento fromString (String statusAgendamentoValueString) {
		switch(statusAgendamentoValueString) {
			case "CONFIRMADO" -> {
				return CONFIRMADO;
			}
			case "PENDENTE" -> {
				return PENDENTE;
			}
			case "CANCELADO" -> {
				return CANCELADO;
			}
			default -> {
                throw new RuntimeException("Valor invalido para status agendamento [" + statusAgendamentoValueString + "]");
            }
		}
	}
	
	@Override
	public String toString() {
	
		return statusAgendamento;
	}
	
}

