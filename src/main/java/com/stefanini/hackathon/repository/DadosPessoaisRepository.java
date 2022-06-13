package com.stefanini.hackathon.repository;

import com.stefanini.hackathon.model.DadosPessoais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DadosPessoaisRepository extends JpaRepository <DadosPessoais, Long> {
}
