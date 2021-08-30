package com.pruebamtsfg.project.robinfood.iservicios;

import java.util.List;

import com.pruebamtsfg.project.robinfood.entidades.Cliente;

public interface IClienteServicio {

	public Cliente crear(Cliente cliente);
	public void eliminar(Long id);
	public Cliente actualizar(Cliente cliente);
	public Cliente obtenerPorId(Long id);
	public List<Cliente> obtenerTodo();
}
