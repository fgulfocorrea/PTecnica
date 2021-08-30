package com.pruebamtsfg.project.robinfood.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebamtsfg.project.robinfood.entidades.Persona;

@Repository
public interface IPersonaRepositorio extends JpaRepository<Persona, Long>{

}
