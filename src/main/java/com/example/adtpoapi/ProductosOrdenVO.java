package com.example.adtpoapi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductosOrdenVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4273603697982136539L;
	private Integer idproductosorden;
	private String meal_id;
	private Integer cantidad;
	private String nombre;
	private String descripcion;
	private Double precio;
	private String url_foto;
	private List<IngredienteProductoVO> ingredientes;
	
	

	public ProductosOrdenVO(Integer idproductosorden, String meal_id, Integer cantidad, String nombre,
			String descripcion, Double precio, String url_foto) {
		this.idproductosorden = idproductosorden;
		this.meal_id = meal_id;
		this.cantidad = cantidad;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.url_foto = url_foto;
		this.ingredientes = new ArrayList<IngredienteProductoVO>();
	}


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

	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getUrl_foto() {
		return url_foto;
	}


	public void setUrl_foto(String url_foto) {
		this.url_foto = url_foto;
	}


	public List<IngredienteProductoVO> getIngredientes() {
		return ingredientes;
	}


	public void setIngredientes(List<IngredienteProductoVO> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public void addIngrediente(IngredienteProductoVO i) {
		this.ingredientes.add(i);
	}


	@Override
	public String toString() {
		return "ProductosOrdenVO [idproductosorden=" + idproductosorden + ", meal_id=" + meal_id + ", cantidad="
				+ cantidad + "]";
	}
	
	

}
