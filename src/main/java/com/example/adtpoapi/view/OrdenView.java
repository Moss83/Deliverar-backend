package com.example.adtpoapi.view;

import java.io.Serializable;
import java.util.List;

public class OrdenView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1783187733587684783L;
	private Integer idorden;
	private DireccionView direccion;
	private List<ProductosOrdenView> productosPedidos;
	
	
	public OrdenView(Integer idorden, DireccionView direccion, List<ProductosOrdenView> productos) {
		this.idorden = idorden;
		this.direccion = direccion;
		this.productosPedidos = productos;
	}
	
	public OrdenView() {}
	
	public Integer getIdorden() {
		return idorden;
	}
	public void setIdorden(Integer idorden) {
		this.idorden = idorden;
	}
	public DireccionView getDireccion() {
		return direccion;
	}
	public void setDireccion(DireccionView direccion) {
		this.direccion = direccion;
	}

	public List<ProductosOrdenView> getProductos() {
		return productosPedidos;
	}

	public void setProductos(List<ProductosOrdenView> productos) {
		this.productosPedidos = productos;
	}

	@Override
	public String toString() {
		return "OrdenView [idorden=" + idorden + ", direccion=" + direccion + "]";
	}
	
	
	
}
