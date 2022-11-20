package com.example.adtpoapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.adtpoapi.view.ProductosOrdenView;

@Entity
@Table(name = "productosorden")
public class ProductosOrden {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idproductosorden;
	@ManyToOne()
	@JoinColumn(name = "idproducto")
	private Producto producto;
	private Integer cantidad;
	@ManyToOne()
	@JoinColumn(name = "idorden")
	private Orden orden;
	
	public ProductosOrden(Integer idproductosorden, Producto producto, Integer cantidad, Orden orden) {
		this.idproductosorden = idproductosorden;
		this.producto = producto;
		this.cantidad = cantidad;
		this.orden = orden;
	}
	
	public ProductosOrden(Producto producto, Integer cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}
	
	public ProductosOrden() {}

	public Integer getIdproductosorden() {
		return idproductosorden;
	}

	public void setIdproductosorden(Integer idproductosorden) {
		this.idproductosorden = idproductosorden;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public ProductosOrdenView toView() {
		return new ProductosOrdenView(idproductosorden, producto.getIdProducto(), cantidad);
	}
	
}
