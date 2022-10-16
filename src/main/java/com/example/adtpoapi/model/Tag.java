package com.example.adtpoapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.adtpoapi.view.TagView;

@Entity
@Table(name = "tags")
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idtag;
	private String nombre;
	@ManyToOne
	@JoinColumn(name = "idproducto")
	private Producto producto;
	private Double descuento;
	
	public Tag(Integer idTag, String nombre, Producto producto, Double descuento) {
		this.idtag = idTag;
		this.nombre = nombre;
		this.producto = producto;
		this.descuento = descuento;
	}
	
	public Tag() {}
	
	public Integer getIdTag() {
		return idtag;
	}
	public void setIdTag(Integer idTag) {
		this.idtag = idTag;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Double getDescuento() {
		return descuento;
	}
	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}
	
	public TagView toView() {
		return new TagView(idtag, nombre, descuento);
	}
	
}
