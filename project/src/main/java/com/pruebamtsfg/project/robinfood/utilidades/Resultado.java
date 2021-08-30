package com.pruebamtsfg.project.robinfood.utilidades;

public class Resultado {

	private String codigoEncuesta;
	private String nombreEncuesta;
	private String numeroPregunta;
	private String textoPregunta;
	private String respuesta;
	private String nombreCliente;
	
	public Resultado() {
	
	}

	public Resultado(String codigoEncuesta, String nombreEncuesta, String numeroPregunta, String textoPregunta,
			String respuesta, String nombreCliente) {
		super();
		this.codigoEncuesta = codigoEncuesta;
		this.nombreEncuesta = nombreEncuesta;
		this.numeroPregunta = numeroPregunta;
		this.textoPregunta = textoPregunta;
		this.respuesta = respuesta;
		this.nombreCliente = nombreCliente;
	}

	public String getCodigoEncuesta() {
		return codigoEncuesta;
	}

	public void setCodigoEncuesta(String codigoEncuesta) {
		this.codigoEncuesta = codigoEncuesta;
	}

	public String getNombreEncuesta() {
		return nombreEncuesta;
	}

	public void setNombreEncuesta(String nombreEncuesta) {
		this.nombreEncuesta = nombreEncuesta;
	}

	public String getNumeroPregunta() {
		return numeroPregunta;
	}

	public void setNumeroPregunta(String numeroPregunta) {
		this.numeroPregunta = numeroPregunta;
	}

	public String getTextoPregunta() {
		return textoPregunta;
	}

	public void setTextoPregunta(String textoPregunta) {
		this.textoPregunta = textoPregunta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
}
