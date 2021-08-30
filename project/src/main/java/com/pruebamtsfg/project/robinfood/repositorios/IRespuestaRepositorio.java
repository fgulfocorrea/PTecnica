package com.pruebamtsfg.project.robinfood.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebamtsfg.project.robinfood.entidades.Respuesta;

@Repository
public interface IRespuestaRepositorio extends JpaRepository<Respuesta, Long>{

	public List<Respuesta> findByIdEncuesta(Long idEncuesta);
	
}
