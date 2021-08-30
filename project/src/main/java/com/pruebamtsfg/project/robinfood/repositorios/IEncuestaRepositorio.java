package com.pruebamtsfg.project.robinfood.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebamtsfg.project.robinfood.entidades.Encuesta;

@Repository
public interface IEncuestaRepositorio extends JpaRepository<Encuesta, Long>{

	public Optional<Encuesta> findById(Long id);
}
