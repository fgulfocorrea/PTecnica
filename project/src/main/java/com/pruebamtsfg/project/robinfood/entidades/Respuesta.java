package com.pruebamtsfg.project.robinfood.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "respuestas")
public class Respuesta {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
	private Long idEncuesta;
	
	@Column(nullable = false)
	private Long idPregunta;
	
	@Column(nullable = false)
	private Long idOpcion;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
    private Cliente cliente;

	public Respuesta() {
	
	}

	public Respuesta(Long id, Long idEncuesta, Long idPregunta, Long idOpcion, Cliente cliente) {
		super();
		this.id = id;
		this.idEncuesta = idEncuesta;
		this.idPregunta = idPregunta;
		this.idOpcion = idOpcion;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdEncuesta() {
		return idEncuesta;
	}

	public void setIdEncuesta(Long idEncuesta) {
		this.idEncuesta = idEncuesta;
	}

	public Long getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(Long idPregunta) {
		this.idPregunta = idPregunta;
	}

	public Long getIdOpcion() {
		return idOpcion;
	}

	public void setIdOpcion(Long idOpcion) {
		this.idOpcion = idOpcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Respuesta [id=" + id + ", idEncuesta=" + idEncuesta + ", idPregunta=" + idPregunta + ", idOpcion="
				+ idOpcion + ", cliente=" + cliente + "]";
	}
}
