package com.example.adtpoapi.model;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name= "restaurantes")
public class Restaurante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRestaurante;
	private String nombre;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idDireccion")
	private Direccion direccion;
	private String foto;
	private Double minimoCompra;
	private String tipo;
	private Double costoEnvio;
	@OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Producto> productos;
	@OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Horario> horarios;
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinTable(name = "pagorestaurante", joinColumns = {@JoinColumn(name = "idRestaurante")}, inverseJoinColumns = {@JoinColumn(name = "idMedio")})
	private List<MedioDePago> mediosDePago;
	
	public Restaurante(Integer idRestaurante, String nombre, Direccion direccion, String foto, Double minimoCompra, String tipo, Double costoEnvio, List<Producto> productos, List<Horario> horarios, List<MedioDePago> mediosDePago) {
		this.idRestaurante = idRestaurante;
		this.nombre = nombre;
		this.direccion = direccion;
		this.foto = foto;
		this.minimoCompra = minimoCompra;
		this.tipo = tipo;
		this.costoEnvio = costoEnvio;
		this.productos = productos;
		this.horarios = horarios;
		this.mediosDePago = mediosDePago;
	}
	
	public Restaurante() {}
	
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
	public Double getMinimoCompra() {
		return minimoCompra;
	}
	public void setMinimoCompra(Double minimoCompra) {
		this.minimoCompra = minimoCompra;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getCostoEnvio() {
		return costoEnvio;
	}

	public void setCostoEnvio(Double costoEnvio) {
		this.costoEnvio = costoEnvio;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	public List<MedioDePago> getMediosDePago() {
		return mediosDePago;
	}

	public void setMediosDePago(List<MedioDePago> mediosDePago) {
		this.mediosDePago = mediosDePago;
	}
	
	
}
