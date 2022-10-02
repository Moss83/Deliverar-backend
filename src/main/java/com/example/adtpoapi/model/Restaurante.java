package com.example.adtpoapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "restaurantes")
public class Restaurante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRestaurante;
	private String nombre;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idDestaurante")
	private Direccion direccion;
	private String foto;
	private float minimoCompra;
	
	
	
	public Restaurante(Integer idRestaurante, String nombre, Direccion direccion, String foto, float minimoCompra) {
		super();
		this.idRestaurante = idRestaurante;
		this.nombre = nombre;
		this.direccion = direccion;
		this.foto = foto;
		this.minimoCompra = minimoCompra;
	}
	
	public Integer getIdRestaurante() {
		return idRestaurante;
	}
	public void setIdRestaurante(Integer idRestaurante) {
		this.idRestaurante = idRestaurante;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setIdDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public float getMinimoCompra() {
		return minimoCompra;
	}
	public void setMinimoCompra(float minimoCompra) {
		this.minimoCompra = minimoCompra;
	}
	
	
}
