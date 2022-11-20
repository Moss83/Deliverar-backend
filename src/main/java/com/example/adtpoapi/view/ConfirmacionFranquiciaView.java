package com.example.adtpoapi.view;

import java.io.Serializable;

public class ConfirmacionFranquiciaView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9006788217256120476L;
	private Integer idorden;
	private String estado;
		
	public ConfirmacionFranquiciaView(Integer idorden, String estado) {
		this.idorden = idorden;
		this.estado = estado;
	}
	
	public ConfirmacionFranquiciaView() {}
	
	public Integer getIdorden() {
		return idorden;
	}
	public void setIdorden(Integer idorden) {
		this.idorden = idorden;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "ConfirmacionFranquiciaView [idorden=" + idorden + ", estado=" + estado + "]";
	}
	
}
