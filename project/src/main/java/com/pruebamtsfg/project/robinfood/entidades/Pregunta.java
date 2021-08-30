package com.pruebamtsfg.project.robinfood.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "preguntas")
public class Pregunta {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "encuesta_id")
	private Encuesta encuesta;
	
	@Column(nullable = false)
	private Integer numero;
	
	@Column(nullable = false)
	private String texto;
	
	@Column(nullable = false)
	private Integer puntuacion;
	 
	@OneToMany
    private List<Opcion> opciones;

	public Pregunta() {
	
	}

	public Pregunta(Long id, Encuesta encuesta, Integer numero, String texto, Integer puntuacion,
			List<Opcion> opciones) {
		super();
		this.id = id;
		this.encuesta = encuesta;
		this.numero = numero;
		this.texto = texto;
		this.puntuacion = puntuacion;
		this.opciones = opciones;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Encuesta getEncuesta() {
		return encuesta;
	}

	public void setEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Integer getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(Integer puntuacion) {
		this.puntuacion = puntuacion;
	}

	public List<Opcion> getOpciones() {
		return opciones;
	}

	public void setOpciones(List<Opcion> opciones) {
		this.opciones = opciones;
	}
}
