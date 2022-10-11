package com.example.adtpoapi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.example.adtpoapi.view.IngredienteView;
import com.example.adtpoapi.view.ProductoView;
import com.example.adtpoapi.view.TagView;

@Entity
@Table(name = "productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	@ManyToOne()
	@JoinTable(name = "idRestaurante")
	private Restaurante restaurante;
	private String categoria;
	private String nombre;
	private String descripcion;
	private String foto;
	private Double precio;
	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Tag> tags;
	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Ingrediente> ingredientes;
	
	public Producto(Integer idProducto, Restaurante restaurante, String categoria, String nombre, String descripcion,
			String foto, Double precio, List<Tag> tags, List<Ingrediente> ingredientes) {
		this.idProducto = idProducto;
		this.restaurante = restaurante;
		this.categoria = categoria;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.foto = foto;
		this.precio = precio;
		this.tags = tags;
		this.ingredientes = ingredientes;
	}
	
	public Producto() {}
	
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
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public ProductoView toView() {
		List<TagView> tagsv = new ArrayList<TagView>();
		List<IngredienteView> ingredientesv = new ArrayList<IngredienteView>();
		
		for (Tag t: tags) {
			tagsv.add(t.toView());
		}
		for (Ingrediente i: ingredientes) {
			ingredientesv.add(i.toView());
		}
		return new ProductoView(idProducto, categoria, nombre, descripcion, foto, precio, tagsv, ingredientesv);
	}

}
