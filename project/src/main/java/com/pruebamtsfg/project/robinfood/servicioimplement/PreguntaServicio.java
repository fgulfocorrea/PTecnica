package com.pruebamtsfg.project.robinfood.servicioimplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebamtsfg.project.robinfood.entidades.Encuesta;
import com.pruebamtsfg.project.robinfood.entidades.Pregunta;
import com.pruebamtsfg.project.robinfood.iservicios.IPreguntaServicio;
import com.pruebamtsfg.project.robinfood.repositorios.IPreguntaRepositorio;

@Service
public class PreguntaServicio implements IPreguntaServicio{

	@Autowired
	private IPreguntaRepositorio preguntaRepositorio;
	
	@Override
	public Pregunta crear(Pregunta pregunta) {
		
		return preguntaRepositorio.save(pregunta);
	}
	
	@Override
	public List<Pregunta> crearAll(List<Pregunta> lista) {
		
		return preguntaRepositorio.saveAll(lista);
	}

	@Override
	public void eliminar(Long id) {
		
		preguntaRepositorio.deleteById(id);
	}

	@Override
	public Pregunta actualizar(Pregunta pregunta) {
		
		return preguntaRepositorio.save(pregunta);
	}

	@Override
	public Pregunta obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pregunta obtenerPorEncuesta(Long id) {
		
		return null;
	}
	
	@Override
	public List<Pregunta> findByEncuesta(Encuesta encuesta) {
		
		return preguntaRepositorio.findByEncuesta(encuesta);
	}

	@Override
	public List<Pregunta> obtenerTodo() {
		
		return preguntaRepositorio.findAll();
	}

	@Override
	public Optional<Pregunta> findById(Long id) {
		
		return preguntaRepositorio.findById(id);
	}
}
