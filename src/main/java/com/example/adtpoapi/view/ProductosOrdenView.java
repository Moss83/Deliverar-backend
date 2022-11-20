package com.example.adtpoapi.view;

import java.io.Serializable;

public class ProductosOrdenView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9214544355600823402L;
	private Integer idproductosorden;
	private ProductoView producto;
	private Integer cantidad;
	
	
	public ProductosOrdenView(Integer idproductosorden, ProductoView producto, Integer cantidad) {
		this.idproductosorden = idproductosorden;
		this.producto = producto;
		this.cantidad = cantidad;
	}
	
	public ProductosOrdenView() {}

	public Integer getIdproductosorden() {
		return idproductosorden;
	}

	public void setIdproductosorden(Integer idproductosorden) {
		this.idproductosorden = idproductosorden;
	}

	public ProductoView getProducto() {
		return producto;
	}

	public void setProducto(ProductoView producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "ProductosOrdenView [idproductosorden=" + idproductosorden + ", cantidad=" + cantidad + "]";
	}
	
}
