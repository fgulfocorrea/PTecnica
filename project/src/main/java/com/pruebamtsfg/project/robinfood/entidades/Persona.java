package com.pruebamtsfg.project.robinfood.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "personas")
public class Persona {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
	private String identificacion;
	
	@Column(nullable = false)
	private String nombres;
	
	@Column(nullable = false)
	private String email;

	public Persona() {
	
	}

	public Long getId() {
		return id;
	}

	public Persona(Long id, String identificacion, String nombres, String email) {
		super();
		this.id = id;
		this.identificacion = identificacion;
		this.nombres = nombres;
		this.email = email;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
