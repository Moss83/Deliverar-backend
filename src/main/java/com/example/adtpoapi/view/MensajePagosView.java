package com.example.adtpoapi.view;

import java.io.Serializable;

public class MensajePagosView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5962481596868699145L;
	private Integer idmensaje;
	private String mensaje;
	
	
	public MensajePagosView(Integer idmensaje, String mensaje) {
		this.idmensaje = idmensaje;
		this.mensaje = mensaje;
	}
	
	public MensajePagosView() {}

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
	
	

}
