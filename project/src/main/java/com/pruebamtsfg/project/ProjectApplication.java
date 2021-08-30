package com.pruebamtsfg.project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pruebamtsfg.project.robinfood.entidades.Cliente;
import com.pruebamtsfg.project.robinfood.entidades.Encuesta;
import com.pruebamtsfg.project.robinfood.entidades.Opcion;
import com.pruebamtsfg.project.robinfood.entidades.Persona;
import com.pruebamtsfg.project.robinfood.entidades.Pregunta;
import com.pruebamtsfg.project.robinfood.servicioimplement.ClienteServicio;
import com.pruebamtsfg.project.robinfood.servicioimplement.EncuestaServicio;
import com.pruebamtsfg.project.robinfood.servicioimplement.OpcionServicio;
import com.pruebamtsfg.project.robinfood.servicioimplement.PersonaServicio;
import com.pruebamtsfg.project.robinfood.servicioimplement.PreguntaServicio;

@SpringBootApplication
public class ProjectApplication {
	
	@Autowired
	private ClienteServicio clienteServicio;
	
	@Autowired
	private PersonaServicio personaServicio;
	
	@Autowired
	private EncuestaServicio encuestaServicio;
	
	@Autowired
	private PreguntaServicio preguntaServicio;
	
	@Autowired
	private OpcionServicio opcionServicio;

	@PostConstruct
	private void datosIniciales(){
		Cliente cliente = new Cliente(null, "123456", "raul", "raul@gmail.com");
		clienteServicio.crear(cliente);
		Persona persona =  new Persona(null, "100100100", "Robin Food", "adm@robinfood.com");
		Persona personaDb = personaServicio.crear(persona);
		List<Encuesta>   listaEncuestas = new ArrayList<Encuesta>();
		List<Encuesta>  listaEncuestaDb = new ArrayList<Encuesta>();
		List<Pregunta>   listaPreguntas = new ArrayList<Pregunta>();
		List<Pregunta> listaPreguntasDb = new ArrayList<Pregunta>();
		List<Opcion>      listaOpciones = new ArrayList<Opcion>();
		Encuesta encuesta;
		Pregunta pregunta;
		Opcion opcion;
		encuesta = new Encuesta(null, "E001", "Encuesta Calidad de Servicio", new Date(), new Date(), personaDb, 1);
		listaEncuestas.add(encuesta);
		encuesta = new Encuesta(null, "E002", "Encuesta Tiempo de Espera", new Date(), new Date(), personaDb, 1);
		listaEncuestas.add(encuesta);
		encuesta = new Encuesta(null, "E003", "Encuesta de Instalaciones", new Date(), new Date(), personaDb, 1);
		listaEncuestas.add(encuesta);
		listaEncuestaDb = encuestaServicio.crearAll(listaEncuestas);
		
		for (Encuesta enc : listaEncuestaDb) {
			if("E001".equalsIgnoreCase(enc.getCodigo())) {
				opcion = new Opcion(null,"A. ","Excelente");
				listaOpciones.add(opcion);
				opcion = new Opcion(null,"B. ","Regular");
				listaOpciones.add(opcion);
				opcion = new Opcion(null,"C. ","Mala");
				listaOpciones.add(opcion);
				pregunta = new Pregunta(null, enc, 1, "¿Califique la atencion?", 1,listaOpciones);
				listaPreguntas.add(pregunta);
				opcionServicio.crearAll(listaOpciones);
				listaOpciones = new ArrayList<>();
				opcion = new Opcion(null,"A. ","Agradable");
				listaOpciones.add(opcion);
				opcion = new Opcion(null,"B. ","Incomoda");
				listaOpciones.add(opcion);
				opcion = new Opcion(null,"C. ","Extresante");
				listaOpciones.add(opcion);
				pregunta = new Pregunta(null, enc, 2, "¿Su experiencia como fue?", 1, listaOpciones);
				listaPreguntas.add(pregunta);
				opcionServicio.crearAll(listaOpciones);
				listaOpciones = new ArrayList<>();
				opcion = new Opcion(null,"A. ","Si");
				listaOpciones.add(opcion);
				opcion = new Opcion(null,"B. ","No");
				listaOpciones.add(opcion);
				pregunta = new Pregunta(null, enc, 3, "¿Le aconsejaron que elegir", 1, listaOpciones);
				listaPreguntas.add(pregunta);
				opcionServicio.crearAll(listaOpciones);
			}
			if("E002".equalsIgnoreCase(enc.getCodigo())) {
				listaOpciones = new ArrayList<>();
				opcion = new Opcion(null,"A. ","Excelente");
				listaOpciones.add(opcion);
				opcion = new Opcion(null,"B. ","Regular");
				listaOpciones.add(opcion);
				opcion = new Opcion(null,"C. ","Malo");
				listaOpciones.add(opcion);
				pregunta = new Pregunta(null, enc, 1, "¿Como fue el tiempo de servicio?", 1, listaOpciones);
				listaPreguntas.add(pregunta);
				opcionServicio.crearAll(listaOpciones);
				listaOpciones = new ArrayList<>();
				opcion = new Opcion(null,"A. ","5 minutos");
				listaOpciones.add(opcion);
				opcion = new Opcion(null,"B. ","10 minutos");
				listaOpciones.add(opcion);
				opcion = new Opcion(null,"C. ","15 minutos");
				listaOpciones.add(opcion);
				pregunta = new Pregunta(null, enc, 2, "¿Cuanto demoró el tiempo de respuesta?", 1, listaOpciones);
				listaPreguntas.add(pregunta);
				opcionServicio.crearAll(listaOpciones);
			}
			if("E003".equalsIgnoreCase(enc.getCodigo())) {
				listaOpciones = new ArrayList<>();
				opcion = new Opcion(null,"A. ","Excelente");
				listaOpciones.add(opcion);
				opcion = new Opcion(null,"B. ","Regular");
				listaOpciones.add(opcion);
				opcion = new Opcion(null,"C. ","Malo");
				listaOpciones.add(opcion);
				pregunta = new Pregunta(null, enc, 1, "¿Califique el local de Robin Food?", 1, listaOpciones);
				listaPreguntas.add(pregunta);
				opcionServicio.crearAll(listaOpciones);
				listaOpciones = new ArrayList<>();
				opcion = new Opcion(null,"A. ","Agradable");
				listaOpciones.add(opcion);
				opcion = new Opcion(null,"B. ","Incomoda");
				listaOpciones.add(opcion);
				opcion = new Opcion(null,"C. ","Extresante");
				listaOpciones.add(opcion);
				pregunta = new Pregunta(null, enc, 2, "¿Como se sintio en el sitio?", 1, listaOpciones);
				listaPreguntas.add(pregunta);
				opcionServicio.crearAll(listaOpciones);
				listaOpciones = new ArrayList<>();
				opcion = new Opcion(null,"A. ","Facil");
				listaOpciones.add(opcion);
				opcion = new Opcion(null,"B. ","Dificil");
				listaOpciones.add(opcion);
				pregunta = new Pregunta(null, enc, 3, "¿La entrega de su domicilio fue?", 1, listaOpciones);
				listaPreguntas.add(pregunta);
				opcionServicio.crearAll(listaOpciones);
			}
			listaPreguntasDb = preguntaServicio.crearAll(listaPreguntas);
		}
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

}
