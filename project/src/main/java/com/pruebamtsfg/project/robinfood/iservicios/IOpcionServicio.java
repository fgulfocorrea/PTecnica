package com.pruebamtsfg.project.robinfood.iservicios;

import java.util.List;
import java.util.Optional;

import com.pruebamtsfg.project.robinfood.entidades.Opcion;

public interface IOpcionServicio {

	public Opcion crear(Opcion opcion);
	public List<Opcion> crearAll(List<Opcion> lista);
	public void eliminar(Long id);
	public Opcion actualizar(Opcion opcion);
	public Optional<Opcion> findById(Long id);
	public Opcion obtenerPorId(Long id);
	public List<Opcion> obtenerTodo();
}
