package com.stoica.consultorioproject.domain.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stoica.consultorioproject.domain.model.Medico;
import com.stoica.consultorioproject.domain.repository.MedicoRepository;

import jakarta.transaction.Transactional;

@Service
public class CadastroMedicoService {

	@Autowired
	MedicoRepository medicoRepository;

	public Medico encontrarMedicoPeloID(Long id) {
		return medicoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Médico não encontrado"));
	}

	@Transactional
	public Medico salvar(Medico medico) {
		verificarExistenciaCRM(medico.getCRM());
		return medicoRepository.save(medico);
		}
	
	@Transactional
	public Medico editar(Long id, Medico medico) {
		Medico medicoAtual = encontrarMedicoPeloID(id);
		if(!medicoAtual.getCRM().equals(medico.getCRM())) {
			verificarExistenciaCRM(medico.getCRM());
		}
		BeanUtils.copyProperties(medico, medicoAtual, "id");
		return medicoRepository.save(medicoAtual);
		
	}

	public void verificarExistenciaCRM(String crm) {
		medicoRepository.findByCRM(crm).ifPresent(m -> {
			throw new IllegalArgumentException("O CRM já está cadastrado: " + m.getCRM());
		});
	}
}
