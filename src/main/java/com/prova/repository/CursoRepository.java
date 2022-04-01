package com.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prova.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}
