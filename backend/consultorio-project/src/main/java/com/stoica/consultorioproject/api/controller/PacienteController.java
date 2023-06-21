package com.stoica.consultorioproject.api.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stoica.consultorioproject.domain.model.Paciente;
import com.stoica.consultorioproject.domain.repository.PacienteRepository;
import com.stoica.consultorioproject.domain.service.CadastroPacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	PacienteRepository pacienteRepository;

	@Autowired
	CadastroPacienteService pacienteService;

	@GetMapping("/todos")
	public java.util.List<Paciente> listarTodos() {
		return pacienteRepository.findAll();
	}

	@GetMapping("/id/{id}")
	public Optional<Paciente> encontrarPorId(@PathVariable(value = "id") Long id) {
		return pacienteRepository.findById(id);
	}
	
	@GetMapping("/nome/{nome}")
	public List<Paciente> encontrarPorNome(@PathVariable(value = "nome") String nome) {
		return pacienteRepository.findByNomeContaining(nome);
		
	}

	@PostMapping("/adicionar")
	public Paciente adicionar(@RequestBody Paciente paciente) {
		return pacienteService.salvar(paciente);

	}

	@DeleteMapping("/deletar/{id}")
	public String deletar(@PathVariable(value = "id") Long id) {
		Optional<Paciente> paciente = pacienteRepository.findById(id);
		paciente.orElseThrow(() -> new NoSuchElementException("Paciente não encontrado"));
		pacienteRepository.deleteById(id);
		return "deletado";
	}

	@PutMapping("/editar/{id}")
	public String editar(@PathVariable(value = "id") Long id, @RequestBody Paciente paciente) {
		pacienteService.editar(id, paciente);
		return "Paciente editado com sucesso";
	}
}
