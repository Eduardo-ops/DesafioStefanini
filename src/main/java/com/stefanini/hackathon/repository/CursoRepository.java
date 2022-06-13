package com.stefanini.hackathon.repository;

import com.stefanini.hackathon.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository <Curso, Long> {
}
