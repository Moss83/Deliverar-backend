package com.example.adtpoapi.view;

import java.io.Serializable;

public class IngredienteView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2042001709011077131L;
	private Integer idIngrediente;
	private String nombre;
	private Integer cantidad;
	private Double precio;
	private Integer numeroGrupo;
	
	public IngredienteView(Integer idIngrediente, String nombre, Integer cantidad, Double precio,
			Integer numeroGrupo) {
		this.idIngrediente = idIngrediente;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.numeroGrupo = numeroGrupo;
	}
	
	public IngredienteView() {}

	public Integer getIdIngrediente() {
		return idIngrediente;
	}

	public void setIdIngrediente(Integer idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getNumeroGrupo() {
		return numeroGrupo;
	}

	public void setNumeroGrupo(Integer numeroGrupo) {
		this.numeroGrupo = numeroGrupo;
	}

	@Override
	public String toString() {
		return "IngredienteView [idIngrediente=" + idIngrediente + ", nombre=" + nombre + ", precio=" + precio + "]";
	}
	
	
}
