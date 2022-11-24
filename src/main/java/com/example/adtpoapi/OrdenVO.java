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
	private Double propina;
	private Double costo_envio;
	private List<ProductosOrdenVO> productos;


	public OrdenVO(Integer idorden, Integer idDireccion, Double propina, Double costo_envio, List<ProductosOrdenVO> productos) {
		this.idorden = idorden;
		this.idDireccion = idDireccion;
		this.propina = propina;
		this.costo_envio = costo_envio;
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
