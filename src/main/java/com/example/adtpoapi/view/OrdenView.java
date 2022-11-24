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
	private Double propina;
	private Double costo_envio;
	private List<ProductosOrdenView> productos;
	
	
	public OrdenView(Integer idorden, Integer direccion, Double propina, Double costo_envio, List<ProductosOrdenView> productos) {
		this.idorden = idorden;
		this.idDireccion = direccion;
		this.propina = propina;
		this.costo_envio = costo_envio;
		this.productos = productos;
	}
	
	public OrdenView(Integer idorden, Integer idDireccion, List<ProductosOrdenView> productos) {
		this.idorden = idorden;
		this.idDireccion = idDireccion;
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

	public Double getPropina() {
		return propina;
	}

	public void setPropina(Double propina) {
		this.propina = propina;
	}

	public Double getCosto_envio() {
		return costo_envio;
	}

	public void setCosto_envio(Double costo_envio) {
		this.costo_envio = costo_envio;
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
