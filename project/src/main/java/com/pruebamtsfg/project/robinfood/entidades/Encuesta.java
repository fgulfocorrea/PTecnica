package com.pruebamtsfg.project.robinfood.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "encuestas")
public class Encuesta {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(nullable = false, length = 4)
    private String codigo;
	
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private Date fechaInicio;
    
    @Column(nullable = false)
    private Date fechaFin;
    
    @ManyToOne
	@JoinColumn(name = "persona_id")
    private Persona responsable;
    
    @Column(nullable = false, length = 1)
    private Integer activa;

	public Encuesta() {
	
	}

	public Encuesta(Long id, String codigo, String nombre, Date fechaInicio, Date fechaFin, Persona responsable,
			Integer activa) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.responsable = responsable;
		this.activa = activa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Integer getActiva() {
		return activa;
	}

	public void setActiva(Integer activa) {
		this.activa = activa;
	}
}
