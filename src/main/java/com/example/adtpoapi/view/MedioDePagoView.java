package com.example.adtpoapi.view;

import java.io.Serializable;

public class MedioDePagoView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4681574271839865480L;
	private Integer idMedio;
	private String nombre;
	private String tipo;
	
	public MedioDePagoView(Integer idMedio, String nombre, String tipo) {
		this.idMedio = idMedio;
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	public MedioDePagoView() {}

	public Integer getIdMedio() {
		return idMedio;
	}

	public void setIdMedio(Integer idMedio) {
		this.idMedio = idMedio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "MedioDePagoView [idMedio=" + idMedio + ", nombre=" + nombre + ", tipo=" + tipo + "]";
	}
	
	
}
