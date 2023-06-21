package com.stoica.consultorioproject.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stoica.consultorioproject.domain.model.Agendamento;
import com.stoica.consultorioproject.domain.service.AgendamentoService;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {
	
	@Autowired
	AgendamentoService agendamentoService;

	@GetMapping("/todos")
	public List<Agendamento> listarTodos(){
		return agendamentoService.listarTodos();
	}
	
	@PostMapping("/adicionar")
	public Agendamento adicionar(Agendamento agendamento) {
		return agendamentoService.salvar(agendamento);
	}
}
