package com.example.adtpoapi;

import java.io.Serializable;

public class ProductosOrdenVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4273603697982136539L;
	private Integer idproductosorden;
	private String meal_id;
	private Integer cantidad;
	
	
	public ProductosOrdenVO(Integer idproductosorden, String meal_id, Integer cantidad) {
		this.idproductosorden = idproductosorden;
		this.meal_id = meal_id;
		this.cantidad = cantidad;
	}
	
	
	public ProductosOrdenVO(String meal_id, Integer cantidad) {
		this.meal_id = meal_id;
		this.cantidad = cantidad;
	}


	public Integer getIdproductosorden() {
		return idproductosorden;
	}
	public void setIdproductosorden(Integer idproductosorden) {
		this.idproductosorden = idproductosorden;
	}
	public String getMeal_id() {
		return meal_id;
	}
	public void setMeal_id(String meal_id) {
		this.meal_id = meal_id;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	@Override
	public String toString() {
		return "ProductosOrdenVO [idproductosorden=" + idproductosorden + ", meal_id=" + meal_id + ", cantidad="
				+ cantidad + "]";
	}
	
	

}
