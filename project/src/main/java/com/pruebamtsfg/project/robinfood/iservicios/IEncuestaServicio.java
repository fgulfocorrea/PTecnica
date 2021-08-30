package com.pruebamtsfg.project.robinfood.iservicios;

import java.util.List;
import java.util.Optional;

import com.pruebamtsfg.project.robinfood.entidades.Encuesta;


public interface IEncuestaServicio {

	public Encuesta crear(Encuesta encuesta);
	public List<Encuesta> crearAll(List<Encuesta> lista);
	public void eliminar(Long id);
	public Encuesta actualizar(Encuesta encuesta);
	public Optional<Encuesta> findById(Long id);
	public Encuesta obtenerPorId(Long id);
	public List<Encuesta> obtenerTodo();
}
