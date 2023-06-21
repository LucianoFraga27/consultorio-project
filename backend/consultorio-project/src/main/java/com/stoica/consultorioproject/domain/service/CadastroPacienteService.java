package com.stoica.consultorioproject.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stoica.consultorioproject.domain.model.Paciente;
import com.stoica.consultorioproject.domain.repository.PacienteRepository;

import jakarta.transaction.Transactional;

@Service
public class CadastroPacienteService {

	@Autowired
	PacienteRepository pacienteRepository;

	public Paciente encontrarPacientePeloID(Long id) {
		return pacienteRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado"));
	}
	
	public List<Paciente> encontrarPacientePeloNome(String nome){
		return pacienteRepository.findByNomeContaining(nome);
	}
	
	@Transactional
	public Paciente salvar(Paciente paciente) {
		verificarExistenciaCPF(paciente.getCPF());
		verificarExistenciaEmail(paciente.getEmail());
		return pacienteRepository.save(paciente);

	}

	@Transactional
	public void editar(Long id, Paciente paciente) {
		Paciente pacienteAtual = encontrarPacientePeloID(id);
		if (!pacienteAtual.getCPF().equals(paciente.getCPF())) {
			verificarExistenciaCPF(paciente.getCPF());
		}

		if (!pacienteAtual.getEmail().equals(paciente.getEmail())) {
			verificarExistenciaEmail(paciente.getEmail());
		}
		BeanUtils.copyProperties(paciente, pacienteAtual, "id");
		pacienteRepository.save(pacienteAtual);
	}


	private void verificarExistenciaCPF(String cpf) {
		pacienteRepository.findByCPF(cpf).ifPresent(p -> {
			throw new IllegalArgumentException( "O CPF já está cadastrado: " + p.getCPF());
		});
	}

	private void verificarExistenciaEmail(String email) {
		pacienteRepository.findByEmail(email).ifPresent(p -> {
			throw new IllegalArgumentException( "O email já está cadastrado: " + p.getEmail());
		});
	}
}
