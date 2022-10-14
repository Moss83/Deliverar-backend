package com.example.adtpoapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.adtpoapi.view.IngredienteView;


@Entity
@Table(name = "ingredientes")
public class Ingrediente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idIngrediente;
	@ManyToOne()
	@JoinTable(name = "idProducto")
	private Producto producto;
	private String nombre;
	private Integer cantidad;
	private Double precio;
	private Integer numeroGrupo; //para siguiente release

	public Ingrediente(Integer idIngrediente, Producto producto, String nombre, Integer cantidad, Double precio,
			Integer numeroGrupo) {
		this.idIngrediente = idIngrediente;
		this.producto = producto;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.numeroGrupo = numeroGrupo;
	}
	
	public Ingrediente() {}

	public Integer getIdIngrediente() {
		return idIngrediente;
	}
	public void setIdIngrediente(Integer idIngrediente) {
		this.idIngrediente = idIngrediente;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
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
	
	public IngredienteView toView() {
		return new IngredienteView(idIngrediente, nombre, cantidad, precio, numeroGrupo);
	}
}
