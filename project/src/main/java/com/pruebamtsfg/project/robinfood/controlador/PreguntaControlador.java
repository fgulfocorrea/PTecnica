package com.pruebamtsfg.project.robinfood.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebamtsfg.project.robinfood.entidades.Encuesta;
import com.pruebamtsfg.project.robinfood.entidades.Pregunta;
import com.pruebamtsfg.project.robinfood.iservicios.IClienteServicio;
import com.pruebamtsfg.project.robinfood.iservicios.IEncuestaServicio;
import com.pruebamtsfg.project.robinfood.iservicios.IPreguntaServicio;

@RestController
@RequestMapping(PreguntaControlador.SERVICE_URI)
@CrossOrigin(origins = "*")
public class PreguntaControlador {

	public static final String SERVICE_URI = "/api/pregunta";
	
	@Autowired
	private IPreguntaServicio preguntaServicio;
	
	@Autowired
	private IEncuestaServicio encuestaServicio;
	
	@Autowired
	private IClienteServicio clienteServicio;
	
	@GetMapping
	public Map<String, Object> preguntas(){
		Map<String, Object> datos = new HashMap<>();
		datos.put("listaPreguntas", preguntaServicio.obtenerTodo());
		return datos;
	}
	
	@GetMapping(value = "/porEncuesta/{idEncuesta}")
	public Map<String, Object> preguntasPorEncuesta(@PathVariable String idEncuesta){
		Map<String, Object> datos = new HashMap<>();
		System.out.println("encuesta:"+idEncuesta);
		Encuesta encuesta = encuestaServicio.findById(Long.valueOf(idEncuesta)).get();
		System.out.println("encuesta:"+encuesta.getNombre());
		List<Pregunta> listaPreguntas = preguntaServicio.findByEncuesta(encuesta);
		datos.put("cliente",clienteServicio.obtenerTodo().get(0));
		datos.put("encuesta", encuesta);
		datos.put("listaPreguntas",listaPreguntas);
		return datos;
	}
}
