package com.example.adtpoapi.view;

import java.io.Serializable;

public class TagView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8466339144277141876L;
	private Integer idTag;
	private String nombre;
	private Double descuento;
	
	public TagView(Integer idTag, String nombre, Double descuento) {
		this.idTag = idTag;
		this.nombre = nombre;
		this.descuento = descuento;
	}
	
	public TagView() {}

	public Integer getIdTag() {
		return idTag;
	}

	public void setIdTag(Integer idTag) {
		this.idTag = idTag;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	@Override
	public String toString() {
		return "TagView [idTag=" + idTag + ", nombre=" + nombre + ", descuento=" + descuento + "]";
	}
	
	
}
