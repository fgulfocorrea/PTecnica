package com.pruebamtsfg.project.robinfood.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebamtsfg.project.robinfood.entidades.Encuesta;
import com.pruebamtsfg.project.robinfood.entidades.Pregunta;

@Repository
public interface IPreguntaRepositorio extends JpaRepository<Pregunta, Long>{

	public List<Pregunta> findByEncuesta(Encuesta encuesta);
	public Optional<Pregunta> findById(Long id);
}
