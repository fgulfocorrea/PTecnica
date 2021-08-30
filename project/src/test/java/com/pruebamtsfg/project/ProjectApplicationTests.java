package com.pruebamtsfg.project;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.pruebamtsfg.project.robinfood.entidades.Encuesta;
import com.pruebamtsfg.project.robinfood.iservicios.IClienteServicio;
import com.pruebamtsfg.project.robinfood.iservicios.IEncuestaServicio;
import com.pruebamtsfg.project.robinfood.iservicios.IPreguntaServicio;

@SpringBootTest
class ProjectApplicationTests {

	@Autowired
	private IClienteServicio clienteServicio;
	
	@Autowired
	private IEncuestaServicio encuestaServicio;
	
	@Autowired
	private IPreguntaServicio preguntaServicio;
	
	@Test
	public void crearCliente() {
		Assertions.assertFalse(clienteServicio.obtenerTodo().isEmpty(),"No se creo el cliente");
		Assertions.assertEquals(1, clienteServicio.obtenerTodo().size());
	}
	
	@Test
	@DisplayName("No se crea la encuesta cuando no tiene codigo")
	public void encuestaNoTieneCodigo() {
		Encuesta encuesta = new Encuesta(null, null, "Encuesta Prueba", new Date(), new Date(), null, 1);
		Assertions.assertNotNull(encuesta.getCodigo(), "Codigo de encuesta no puede ser null");
		encuestaServicio.crear(encuesta);
	}
	
	@Test
	@DisplayName("Se verifica la cantidad de preguntas creadas al iniciar la app")
	public void preguntasCreadas() {
		Assertions.assertEquals(8, preguntaServicio.obtenerTodo().size());
	}

}
