package com.example.adtpoapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.adtpoapi.view.MensajeRepartidorView;

@Entity
@Table(name = "mensajesrepartidor")
public class MensajeRepartidor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idmensaje;
	private String tipo;
	private Integer identificador;
	private String latitud;
	private String longitud;
	private String status;
	private String username;
	
	
	public MensajeRepartidor(Integer idmensaje, Integer identificador, String latitud, String longitud,
			String status, String username) {
		this.idmensaje = idmensaje;
		this.identificador = identificador;
		this.latitud = latitud;
		this.longitud = longitud;
		this.status = status;
		this.username = username;
	}
	
	public MensajeRepartidor(Integer identificador, String latitud, String longitud, String status, String username) {
		this.identificador = identificador;
		this.latitud = latitud;
		this.longitud = longitud;
		this.status = status;
		this.username = username;
	}

	public MensajeRepartidor(Integer identificador, String status, String username) {
		this.identificador = identificador;
		this.status = status;
		this.username = username;
	}

	public MensajeRepartidor(Integer identificador) {
		this.identificador = identificador;
	}



	public MensajeRepartidor() {}

	public Integer getIdmensaje() {
		return idmensaje;
	}

	public void setIdmensaje(Integer idmensaje) {
		this.idmensaje = idmensaje;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

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
	
	public MensajeRepartidorView toViewUbicacion() {
		return new MensajeRepartidorView(identificador, latitud, longitud, status, username);
	}
	
	public MensajeRepartidorView toViewEntregado() {
		return new MensajeRepartidorView(identificador, status);
	}
		
}
