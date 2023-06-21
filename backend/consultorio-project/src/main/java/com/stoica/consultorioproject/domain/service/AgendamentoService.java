package com.stoica.consultorioproject.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stoica.consultorioproject.domain.model.Agendamento;
import com.stoica.consultorioproject.domain.repository.AgendamentoRepository;

import jakarta.transaction.Transactional;

@Service
public class AgendamentoService {

	@Autowired
	AgendamentoRepository agendamentoRepository;
	
	public List<Agendamento> listarTodos(){
		return agendamentoRepository.findAll(); 
	}
	
	@Transactional
	public Agendamento salvar(Agendamento agendamento) {
		return agendamentoRepository.save(agendamento);
	}
	
}
