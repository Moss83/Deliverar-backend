package com.example.adtpoapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.adtpoapi.view.IngredienteView;


@Entity
@Table(name = "ingredientes")
public class Ingrediente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idingrediente;
	@ManyToOne()
	@JoinColumn(name = "idproducto")
	private Producto producto;
	private String ingredient_id;
	private String nombre;
	private Integer cantidad;
	private Double precio;
	@Column(name = "numero_grupo")
	private Integer numeroGrupo; //para siguiente release

	public Ingrediente(Integer idIngrediente, Producto producto, String nombre, Integer cantidad, Double precio,
			Integer numeroGrupo) {
		this.idingrediente = idIngrediente;
		this.producto = producto;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.numeroGrupo = numeroGrupo;
	}
		
	public Ingrediente(String ingredient_id, Producto producto, String nombre, Integer cantidad) {
		this.ingredient_id = ingredient_id;
		this.producto = producto;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	public Ingrediente(String ingredient_id) {
		this.ingredient_id = ingredient_id;
	}

	public Ingrediente() {}

	public Integer getIdIngrediente() {
		return idingrediente;
	}
	public void setIdIngrediente(Integer idIngrediente) {
		this.idingrediente = idIngrediente;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public String getIngredient_id() {
		return ingredient_id;
	}

	public void setIngredient_id(String ingredient_id) {
		this.ingredient_id = ingredient_id;
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
		return new IngredienteView(idingrediente, nombre, cantidad, precio, numeroGrupo);
	}
}
