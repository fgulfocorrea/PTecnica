package com.pruebamtsfg.project.robinfood.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebamtsfg.project.robinfood.entidades.Encuesta;
import com.pruebamtsfg.project.robinfood.entidades.Opcion;
import com.pruebamtsfg.project.robinfood.entidades.Pregunta;
import com.pruebamtsfg.project.robinfood.entidades.Respuesta;
import com.pruebamtsfg.project.robinfood.iservicios.IEncuestaServicio;
import com.pruebamtsfg.project.robinfood.iservicios.IOpcionServicio;
import com.pruebamtsfg.project.robinfood.iservicios.IPreguntaServicio;
import com.pruebamtsfg.project.robinfood.iservicios.IRespuestaServicio;
import com.pruebamtsfg.project.robinfood.utilidades.Resultado;

@RestController
@RequestMapping(RespuestaControlador.SERVICE_URI)
@CrossOrigin(origins = "*")
public class RespuestaControlador {

	public static final String SERVICE_URI = "/api/respuesta";
	
	@Autowired
	private IRespuestaServicio respuestaServicio;
	
	@Autowired
	private IEncuestaServicio encuestaServicio;
	
	@Autowired
	private IPreguntaServicio preguntaServicio;
	
	@Autowired
	private IOpcionServicio opcionServicio;
	
	@PostMapping(value = "/guardar")
	public Map<String, Object> guardarRespuesta(@RequestBody List<Respuesta> listaRespuestas){
		Map<String, Object> datos = new HashMap<>();
		for (Respuesta respuesta : listaRespuestas) {
			System.out.println("res:"+respuesta.toString());
		}
		respuestaServicio.crearAll(listaRespuestas);
		
		return datos;
	}
	
	@GetMapping(value = "/resultados/{idEncuesta}")
	public Map<String, Object> resultados(@PathVariable String idEncuesta){
		Map<String, Object> datos = new HashMap<>();
		Encuesta encuesta = null;
		Pregunta pregunta;
		Opcion opcion;
		Resultado resultado;
		List<Respuesta> lista = respuestaServicio.findByIdEncuesta(Long.valueOf(idEncuesta));
		System.out.println("lista:"+lista.size());
		List<Resultado> listaResultados = new ArrayList<Resultado>();
		for (Respuesta respuesta : lista) {
			encuesta =  new Encuesta();
			pregunta = new Pregunta();
			opcion = new Opcion();
			encuesta = encuestaServicio.findById(respuesta.getIdEncuesta()).get();
			pregunta = preguntaServicio.findById(respuesta.getIdPregunta()).get();
			opcion = opcionServicio.findById(respuesta.getIdOpcion()).get();
			resultado = new Resultado(encuesta.getCodigo(), encuesta.getNombre(), pregunta.getNumero().toString(), pregunta.getTexto(), opcion.getNombre(), respuesta.getCliente().getNombres());
			listaResultados.add(resultado);
		}
		datos.put("encuesta", encuesta);
		datos.put("resultados", listaResultados);
		return datos;
	}
}
