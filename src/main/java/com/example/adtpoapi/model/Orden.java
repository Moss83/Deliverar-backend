package com.example.adtpoapi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.example.adtpoapi.view.OrdenView;
import com.example.adtpoapi.view.ProductosOrdenView;

@Entity
@Table(name = "ordenes")
public class Orden {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idorden;
	@ManyToOne()
	@JoinColumn(name = "iddireccion")
	private Direccion direccion;
	@OneToMany(mappedBy = "orden", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<ProductosOrden> productosPedidos;
	
	
	public Orden(Integer idorden, Direccion direccion, List<ProductosOrden> productosPedidos) {
		this.idorden = idorden;
		this.direccion = direccion;
		this.productosPedidos = productosPedidos;
	}
	
	public Orden(Direccion direccion, List<ProductosOrden> productosPedidos) {
		this.direccion = direccion;
		this.productosPedidos = productosPedidos;
	}
	
	public Orden() {}
	
	public Integer getIdorden() {
		return idorden;
	}
	public void setIdorden(Integer idorden) {
		this.idorden = idorden;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	public List<ProductosOrden> getProductosPedidos() {
		return productosPedidos;
	}

	public void setProductosPedidos(List<ProductosOrden> productosPedidos) {
		this.productosPedidos = productosPedidos;
	}

	public OrdenView toView() {
		List<ProductosOrdenView> productosv = new ArrayList<ProductosOrdenView>();
		
		for (ProductosOrden p: productosPedidos) {
			productosv.add(p.toView());
		}
		return new OrdenView(idorden, direccion.getIdDireccion(), productosv);
	}
	
}
