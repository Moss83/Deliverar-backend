package com.example.adtpoapi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	private Integer idproducto;
	@ManyToOne()
	@JoinColumn(name = "idrestaurante")
	private Restaurante restaurante;
	private String meal_id;
	private String categoria;
	private String nombre;
	private String descripcion;
	private String foto;
	private Double precio;
	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Tag> tags;
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinTable(name = "productoingrediente", joinColumns = {@JoinColumn(name = "idproducto")}, inverseJoinColumns = {@JoinColumn(name = "idingrediente")})
	private List<Ingrediente> ingredientes;
	
	public Producto(Integer idProducto, Restaurante restaurante, String categoria, String nombre, String descripcion,
			String foto, Double precio, List<Tag> tags, List<Ingrediente> ingredientes) {
		this.idproducto = idProducto;
		this.restaurante = restaurante;
		this.categoria = categoria;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.foto = foto;
		this.precio = precio;
		this.tags = tags;
		this.ingredientes = ingredientes;
	}
	
	public Producto(String meal_id, String nombre, String descripcion, String foto, Double precio, List<Ingrediente> ingredientes) {
		this.meal_id = meal_id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.foto = foto;
		this.precio = precio;
		this.ingredientes = ingredientes;
	}
	

	public Producto(String meal_id, Restaurante restaurante, String nombre, String descripcion, String foto, Double precio) {
		this.meal_id = meal_id;
		this.restaurante = restaurante;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.foto = foto;
		this.precio = precio;
		this.ingredientes = new ArrayList<Ingrediente>();
	}
	
	

	public Producto(String meal_id) {
		this.meal_id = meal_id;
	}

	public Producto() {}
	
	public Integer getIdProducto() {
		return idproducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idproducto = idProducto;
	}
	public Restaurante getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	public String getMeal_id() {
		return meal_id;
	}

	public void setMeal_id(String meal_id) {
		this.meal_id = meal_id;
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
	
	public void addIngrediente(Ingrediente ingrediente) {
		this.ingredientes.add(ingrediente);
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
		return new ProductoView(idproducto, meal_id, categoria, nombre, descripcion, foto, precio, tagsv, ingredientesv);
	}
	
	public ProductoView toViewSimple() {
		List<TagView> tagsv = new ArrayList<TagView>();
		
		for (Tag t: tags) {
			tagsv.add(t.toView());
		}
		return new ProductoView(idproducto, categoria, nombre, foto, precio, tagsv);
	}

}
