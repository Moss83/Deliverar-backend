package com.example.adtpoapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.adtpoapi.view.IngredienteView;


@Entity
@Table(name = "ingredientes")
public class Ingrediente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idingrediente;
	private String ingredient_id;
	private String descripcion;
	private String codigo_producto;
	private Integer cantidad;
	private Double precio;
	@Column(name = "numero_grupo")
	private Integer numeroGrupo; //para siguiente release

	public Ingrediente(Integer idIngrediente, String nombre, String codigo_producto, Integer cantidad, Double precio,
			Integer numeroGrupo) {
		this.idingrediente = idIngrediente;
		this.descripcion = nombre;
		this.codigo_producto = codigo_producto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.numeroGrupo = numeroGrupo;
	}
		
	public Ingrediente(String ingredient_id, String nombre, Integer cantidad, String codigo_producto) {
		this.ingredient_id = ingredient_id;
		this.descripcion = nombre;
		this.cantidad = cantidad;
		this.codigo_producto = codigo_producto;
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

	public String getIngredient_id() {
		return ingredient_id;
	}

	public void setIngredient_id(String ingredient_id) {
		this.ingredient_id = ingredient_id;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String nombre) {
		this.descripcion = nombre;
	}
	public String getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(String codigo_producto) {
		this.codigo_producto = codigo_producto;
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
		return new IngredienteView(idingrediente, descripcion, cantidad, precio, numeroGrupo);
	}
}
