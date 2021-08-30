package com.pruebamtsfg.project.robinfood.iservicios;

import java.util.List;

import com.pruebamtsfg.project.robinfood.entidades.Persona;

public interface IPersonaSerivicio {

	public Persona crear(Persona persona);
	public void eliminar(Long id);
	public Persona actualizar(Persona persona);
	public Persona obtenerPorId(Long id);
	public List<Persona> obtenerTodo();
}
