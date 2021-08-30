package com.pruebamtsfg.project.robinfood.servicioimplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebamtsfg.project.robinfood.entidades.Encuesta;
import com.pruebamtsfg.project.robinfood.iservicios.IEncuestaServicio;
import com.pruebamtsfg.project.robinfood.repositorios.IEncuestaRepositorio;

@Service
public class EncuestaServicio implements IEncuestaServicio{

	@Autowired
	private IEncuestaRepositorio encuestaRepositorio;
	
	@Override
	public Encuesta crear(Encuesta encuesta) {
		
		return encuestaRepositorio.save(encuesta);
	}
	
	@Override
	public List<Encuesta> crearAll(List<Encuesta> lista) {
		
		return encuestaRepositorio.saveAll(lista);
	}

	@Override
	public void eliminar(Long id) {
		
		encuestaRepositorio.deleteById(id);
	}

	@Override
	public Encuesta actualizar(Encuesta encuesta) {
		
		return encuestaRepositorio.save(encuesta);
	}

	@Override
	public Encuesta obtenerPorId(Long id) {
		
		return null;
	}

	@Override
	public List<Encuesta> obtenerTodo() {
		
		return encuestaRepositorio.findAll();
	}

	@Override
	public Optional<Encuesta> findById(Long id) {
		
		return encuestaRepositorio.findById(id);
	}
}
