package com.stoica.consultorioproject.api.controller;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.stoica.consultorioproject.domain.model.Paciente;
import com.stoica.consultorioproject.domain.repository.PacienteRepository;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	PacienteRepository pacienteRepository;

	@GetMapping("/todos")
	public java.util.List<Paciente> listarTodos() {
		return pacienteRepository.findAll();
	}

	@GetMapping("/id/{id}")
	public Optional<Paciente> encontrarPorId(@PathVariable(value = "id") Long id) {
		return pacienteRepository.findById(id);
	}

	@PostMapping("/adicionar")
	public Paciente adicionar(@RequestBody Paciente paciente) {
		return pacienteRepository.save(paciente);
	}

	@DeleteMapping("/deletar/{id}")
	public String deletar(@PathVariable(value = "id") Long id) {
		Optional<Paciente> paciente = pacienteRepository.findById(id);
		paciente.orElseThrow(() -> new NoSuchElementException("Paciente não encontrado"));
		pacienteRepository.deleteById(id);
		return "deletado";
	}
}
