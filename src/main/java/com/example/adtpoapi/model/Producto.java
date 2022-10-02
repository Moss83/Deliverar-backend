package com.example.adtpoapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	@ManyToMany()
	@JoinTable(name = "idReceta")
	private Restaurante restaurante;
	private String categoria;
	private String nombre;
	private String descripcion;
	private String foto;
	private Float precio;
	private Integer idProductoPadre;
	
	public Producto(Integer producto, Restaurante restaurante, String categoria, String nombre, String descripcion,
			String foto, Float precio, Integer idProductoPadre) {
		super();
		this.idProducto = idProducto;
		this.restaurante = restaurante;
		this.categoria = categoria;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.foto = foto;
		this.precio = precio;
		this.idProductoPadre = idProductoPadre;
	}
	
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public Restaurante getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
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
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public Integer getIdProductoPadre() {
		return idProductoPadre;
	}
	public void setIdProductoPadre(Integer idProductoPadre) {
		this.idProductoPadre = idProductoPadre;
	}
	
	

}
