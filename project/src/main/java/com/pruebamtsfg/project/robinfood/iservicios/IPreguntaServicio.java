package com.pruebamtsfg.project.robinfood.iservicios;

import java.util.List;
import java.util.Optional;

import com.pruebamtsfg.project.robinfood.entidades.Encuesta;
import com.pruebamtsfg.project.robinfood.entidades.Pregunta;

public interface IPreguntaServicio {

	public Pregunta crear(Pregunta pregunta);
	public List<Pregunta> crearAll(List<Pregunta> lista);
	public void eliminar(Long id);
	public Pregunta actualizar(Pregunta pregunta);
	public Optional<Pregunta> findById(Long id);
	public Pregunta obtenerPorId(Long id);
	public Pregunta obtenerPorEncuesta(Long id);
	public List<Pregunta> findByEncuesta(Encuesta encuesta);
	public List<Pregunta> obtenerTodo();
}
