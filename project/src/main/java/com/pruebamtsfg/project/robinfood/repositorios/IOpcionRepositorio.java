package com.pruebamtsfg.project.robinfood.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebamtsfg.project.robinfood.entidades.Opcion;

@Repository
public interface IOpcionRepositorio extends JpaRepository<Opcion, Long>{

	public Optional<Opcion> findById(Long id);
}
