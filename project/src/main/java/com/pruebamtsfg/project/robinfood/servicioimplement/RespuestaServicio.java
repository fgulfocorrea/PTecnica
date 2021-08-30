package com.pruebamtsfg.project.robinfood.servicioimplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pruebamtsfg.project.robinfood.entidades.Respuesta;
import com.pruebamtsfg.project.robinfood.iservicios.IRespuestaServicio;
import com.pruebamtsfg.project.robinfood.repositorios.IRespuestaRepositorio;

@Service
public class RespuestaServicio implements IRespuestaServicio{

	@Autowired
	private IRespuestaRepositorio respuestaRepositorio;
	
	@Override
	public Respuesta crear(Respuesta respuesta) {
		
		return respuestaRepositorio.save(respuesta);
	}
	
	@Override
	public List<Respuesta> crearAll(List<Respuesta> lista) {
		
		return respuestaRepositorio.saveAll(lista);
	}

	@Override
	public void eliminar(Long id) {
		
		respuestaRepositorio.deleteById(id);
	}

	@Override
	public Respuesta actualizar(Respuesta respuesta) {
		
		return respuestaRepositorio.save(respuesta);
	}

	@Override
	public Respuesta obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Respuesta obtenerPorEncuesta(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Respuesta> obtenerTodo() {
		
		return respuestaRepositorio.findAll();
	}

	@Override
	public List<Respuesta> findByIdEncuesta(Long idEncuesta) {
		
		return respuestaRepositorio.findByIdEncuesta(idEncuesta);
	}

}
