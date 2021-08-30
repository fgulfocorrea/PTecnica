package com.pruebamtsfg.project.robinfood.servicioimplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebamtsfg.project.robinfood.entidades.Opcion;
import com.pruebamtsfg.project.robinfood.iservicios.IOpcionServicio;
import com.pruebamtsfg.project.robinfood.repositorios.IOpcionRepositorio;

@Service
public class OpcionServicio implements IOpcionServicio{

	@Autowired
	private IOpcionRepositorio opcionRepositorio;
	
	@Override
	public Opcion crear(Opcion opcion) {
		
		return opcionRepositorio.save(opcion);
	}
	
	@Override
	public List<Opcion> crearAll(List<Opcion> lista) {
		
		return opcionRepositorio.saveAll(lista);
	}

	@Override
	public void eliminar(Long id) {
		
		opcionRepositorio.deleteById(id);
	}

	@Override
	public Opcion actualizar(Opcion opcion) {
		
		return opcionRepositorio.save(opcion);
	}

	@Override
	public Opcion obtenerPorId(Long id) {
		
		return opcionRepositorio.getOne(id);
	}

	@Override
	public List<Opcion> obtenerTodo() {
		
		return opcionRepositorio.findAll();
	}

	@Override
	public Optional<Opcion> findById(Long id) {
		
		return opcionRepositorio.findById(id);
	}
}
