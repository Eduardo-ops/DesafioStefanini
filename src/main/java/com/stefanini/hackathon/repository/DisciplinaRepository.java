package com.stefanini.hackathon.repository;

import com.stefanini.hackathon.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository <Disciplina, Long> {
}
