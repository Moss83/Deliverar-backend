package com.example.adtpoapi.view;

import java.io.Serializable;

public class MensajeRepartidorView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4229593673050477652L;
	private Integer identificador;
	private String latitud;
	private String longitud;
	private String status;
	private String username;
	
	
	public MensajeRepartidorView(Integer identificador, String latitud, String longitud, String status,
			String username) {
		this.identificador = identificador;
		this.latitud = latitud;
		this.longitud = longitud;
		this.status = status;
		this.username = username;
	}

	public MensajeRepartidorView(Integer identificador, String status) {
		this.identificador = identificador;
		this.status = status;
	}
	
	public MensajeRepartidorView() {}

	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
