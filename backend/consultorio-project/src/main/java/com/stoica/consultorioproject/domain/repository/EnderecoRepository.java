package com.stoica.consultorioproject.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stoica.consultorioproject.domain.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
