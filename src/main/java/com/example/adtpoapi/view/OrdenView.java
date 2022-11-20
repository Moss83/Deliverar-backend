package com.example.adtpoapi.view;

import java.io.Serializable;
import java.util.List;

public class OrdenView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1783187733587684783L;
	private Integer idorden;
	private Integer idDireccion;
	private List<ProductosOrdenView> productos;
	
	
	public OrdenView(Integer idorden, Integer direccion, List<ProductosOrdenView> productos) {
		this.idorden = idorden;
		this.idDireccion = direccion;
		this.productos = productos;
	}
	
	public OrdenView() {}
	
	public Integer getIdorden() {
		return idorden;
	}
	public void setIdorden(Integer idorden) {
		this.idorden = idorden;
	}
	public Integer getIdDireccion() {
		return idDireccion;
	}
	public void setIdDireccion(Integer direccion) {
		this.idDireccion = direccion;
	}

	public List<ProductosOrdenView> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductosOrdenView> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "OrdenView [idorden=" + idorden + ", direccion=" + idDireccion + "]";
	}
	
	
	
}
