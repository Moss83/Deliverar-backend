package com.example.adtpoapi;

import java.io.Serializable;
import java.util.List;

public class OrdenVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5699350478189002700L;
	private Integer idorden;
	private Integer idDireccion;
	private List<ProductosOrdenVO> productos;
	
	
	public OrdenVO(Integer idorden, Integer idDireccion, List<ProductosOrdenVO> productos) {
		this.idorden = idorden;
		this.idDireccion = idDireccion;
		this.productos = productos;
	}
	
	
	public Integer getIdorden() {
		return idorden;
	}
	public void setIdorden(Integer idorden) {
		this.idorden = idorden;
	}
	public Integer getIdDireccion() {
		return idDireccion;
	}
	public void setIdDireccion(Integer idDireccion) {
		this.idDireccion = idDireccion;
	}
	public List<ProductosOrdenVO> getProductos() {
		return productos;
	}
	public void setProductos(List<ProductosOrdenVO> productos) {
		this.productos = productos;
	}


	@Override
	public String toString() {
		return "OrderVO [idorden=" + idorden + ", idDireccion=" + idDireccion + "]";
	}

	

}
