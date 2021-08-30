package com.pruebamtsfg.project.robinfood.controlador;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebamtsfg.project.robinfood.servicioimplement.EncuestaServicio;


@RestController
@RequestMapping(EncuestaControlador.SERVICE_URI)
@CrossOrigin(origins = "*")
public class EncuestaControlador {

	public static final String SERVICE_URI = "/api/encuesta";
	
	@Autowired
	public EncuestaServicio encuestaServicio;
	
	@GetMapping
	public Map<String, Object> encuestas(){
		Map<String, Object> datos = new HashMap<>();
		datos.put("listaEncuestas", encuestaServicio.obtenerTodo());
		return datos;
	}
}
