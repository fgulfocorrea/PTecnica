package com.pruebamtsfg.project.robinfood.servicioimplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebamtsfg.project.robinfood.entidades.Persona;
import com.pruebamtsfg.project.robinfood.iservicios.IPersonaSerivicio;
import com.pruebamtsfg.project.robinfood.repositorios.IPersonaRepositorio;

@Service
public class PersonaServicio implements IPersonaSerivicio{

	@Autowired
	private IPersonaRepositorio personaRepositorio;
	
	@Override
	public Persona crear(Persona persona) {
		
		return personaRepositorio.save(persona);
	}

	@Override
	public void eliminar(Long id) {
		
		personaRepositorio.deleteById(id);
	}

	@Override
	public Persona actualizar(Persona persona) {
		
		return personaRepositorio.save(persona);
	}

	@Override
	public Persona obtenerPorId(Long id) {
		
		return personaRepositorio.getOne(id);
	}

	@Override
	public List<Persona> obtenerTodo() {
		
		return personaRepositorio.findAll();
	}

}
