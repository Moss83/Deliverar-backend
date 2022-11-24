package com.example.adtpoapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mensajesfranquicia")
public class MensajeFranquicia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idmensaje;
	private String tipo;
	private Integer identificador;
	private String mensaje;
	
	public MensajeFranquicia(Integer idmensaje, String tipo, Integer identificador, String mensaje) {
		this.idmensaje = idmensaje;
		this.tipo = tipo;
		this.identificador = identificador;
		this.mensaje = mensaje;
	}
	
	public MensajeFranquicia(String tipo, Integer identificador, String mensaje) {
		this.tipo = tipo;
		this.identificador = identificador;
		this.mensaje = mensaje;
	}

	public MensajeFranquicia() {}

	
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
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
}
