package com.example.adtpoapi.view;

import java.io.Serializable;
import java.util.List;

public class ProductoView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -575794107040287837L;
	private Integer idProducto;
	private String categoria;
	private String nombre;
	private String descripcion;
	private String foto;
	private Double precio;
	private List<TagView> tags;
	private List<IngredienteView> ingredientes;
	
	public ProductoView(Integer idProducto, String categoria, String nombre, String descripcion, String foto,
			Double precio, List<TagView> tags, List<IngredienteView> ingredientes) {
		this.idProducto = idProducto;
		this.categoria = categoria;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.foto = foto;
		this.precio = precio;
		this.tags = tags;
		this.ingredientes = ingredientes;
	}
	
	public ProductoView(Integer idProducto, String categoria, String nombre, String foto, Double precio,
			List<TagView> tags) {
		this.idProducto = idProducto;
		this.categoria = categoria;
		this.nombre = nombre;
		this.foto = foto;
		this.precio = precio;
		this.tags = tags;
	}

	public ProductoView() {}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public List<TagView> getTags() {
		return tags;
	}

	public void setTags(List<TagView> tags) {
		this.tags = tags;
	}

	public List<IngredienteView> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<IngredienteView> ingredientes) {
		this.ingredientes = ingredientes;
	}

	@Override
	public String toString() {
		return "ProductoView [idProducto=" + idProducto + ", categoria=" + categoria + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}
	
	
}
