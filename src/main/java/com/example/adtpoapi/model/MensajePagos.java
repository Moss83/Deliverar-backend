package com.example.adtpoapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.adtpoapi.view.MensajePagosView;

@Entity
@Table(name = "mensajepagos")
public class MensajePagos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idmensaje;
	private String mensaje;
	
	
	public MensajePagos(Integer idmensaje, String mensaje) {
		this.idmensaje = idmensaje;
		this.mensaje = mensaje;
	}
	
	public MensajePagos() {}


	public MensajePagos(String mensaje) {
		this.mensaje = mensaje;
	}


	public Integer getIdmensaje() {
		return idmensaje;
	}


	public void setIdmensaje(Integer idmensaje) {
		this.idmensaje = idmensaje;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public MensajePagosView toView() {
		return new MensajePagosView(idmensaje, mensaje);
	}
	
	
}
