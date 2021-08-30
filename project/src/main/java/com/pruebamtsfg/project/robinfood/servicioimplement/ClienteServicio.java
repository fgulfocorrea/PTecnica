package com.pruebamtsfg.project.robinfood.servicioimplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebamtsfg.project.robinfood.entidades.Cliente;
import com.pruebamtsfg.project.robinfood.iservicios.IClienteServicio;
import com.pruebamtsfg.project.robinfood.repositorios.IClienteRepositorio;

@Service
public class ClienteServicio implements IClienteServicio{

	@Autowired
	private IClienteRepositorio clienteRepositorio;
	
	@Override
	public Cliente crear(Cliente cliente) {
		
		return clienteRepositorio.save(cliente);
	}

	@Override
	public void eliminar(Long id) {
		
		clienteRepositorio.deleteById(id);
	}

	@Override
	public Cliente actualizar(Cliente cliente) {
		
		return clienteRepositorio.save(cliente);
	}

	@Override
	public Cliente obtenerPorId(Long id) {
		
		return clienteRepositorio.getOne(id);
	}

	@Override
	public List<Cliente> obtenerTodo() {
		
		return clienteRepositorio.findAll();
	}

}
