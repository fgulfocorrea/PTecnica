package com.pruebamtsfg.project.robinfood.iservicios;

import java.util.List;

import com.pruebamtsfg.project.robinfood.entidades.Respuesta;

public interface IRespuestaServicio {

	public Respuesta crear(Respuesta respuesta);
	public List<Respuesta> crearAll(List<Respuesta> lista);
	public void eliminar(Long id);
	public Respuesta actualizar(Respuesta respuesta);
	public Respuesta obtenerPorId(Long id);
	public Respuesta obtenerPorEncuesta(Long id);
	public List<Respuesta> findByIdEncuesta(Long idEncuesta);
	public List<Respuesta> obtenerTodo();
}
