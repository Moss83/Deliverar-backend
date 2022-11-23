package com.example.adtpoapi;

import java.io.Serializable;

public class IngredienteProductoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5857659897083679509L;
	private String ingrediente_id;
	private String codigo_producto;
	private String descripcion;
	private Integer cantidad;
	private Double precio;
	
	
	public IngredienteProductoVO(String ingrediente_id, String codigo_producto, String descripcion, Integer cantidad,
			Double precio) {
		this.ingrediente_id = ingrediente_id;
		this.codigo_producto = codigo_producto;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precio = precio;
	}


	public String getIngrediente_id() {
		return ingrediente_id;
	}


	public void setIngrediente_id(String ingrediente_id) {
		this.ingrediente_id = ingrediente_id;
	}


	public String getCodigo_producto() {
		return codigo_producto;
	}


	public void setCodigo_producto(String codigo_producto) {
		this.codigo_producto = codigo_producto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
