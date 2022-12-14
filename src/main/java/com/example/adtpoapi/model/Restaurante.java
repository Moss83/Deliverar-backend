package com.example.adtpoapi.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.example.adtpoapi.view.HorarioView;
import com.example.adtpoapi.view.ProductoView;
import com.example.adtpoapi.view.RestauranteView;

@Entity
@Table(name = "restaurantes")
public class Restaurante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idrestaurante;
	private String nombre;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "iddireccion")
	private Direccion direccion;
	private String franchise_id;
	private String foto;
	@Column(name = "promedio_calificaciones")
	private Double promedioCalificaciones;
	private Double minimoCompra;
	private String tipo;
	private Double costoEnvio;
	@OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Producto> productos;
	@OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Horario> horarios;
	
	public Restaurante(Integer idRestaurante, String nombre, Direccion direccion, String foto, Double promedioCalificaciones, Double minimoCompra, String tipo, Double costoEnvio, List<Producto> productos, List<Horario> horarios) {
		this.idrestaurante = idRestaurante;
		this.nombre = nombre;
		this.direccion = direccion;
		this.foto = foto;
		this.promedioCalificaciones = promedioCalificaciones;
		this.minimoCompra = minimoCompra;
		this.tipo = tipo;
		this.costoEnvio = costoEnvio;
		this.productos = productos;
		this.horarios = horarios;
	}
	
	public Restaurante(String franchise_id, String nombre, Direccion direccion, String foto, List<Producto> productos) {
		this.franchise_id = franchise_id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.foto = foto;
		this.productos = productos;
	}

	public Restaurante(String nombre, Direccion direccion, String franchise_id, String foto) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.franchise_id = franchise_id;
		this.foto = foto;
	}
	
	public Restaurante(String franchise_id) {
		this.franchise_id = franchise_id;
	}

	public Restaurante() {}
	
	public Integer getIdRestaurante() {
		return idrestaurante;
	}
	public void setIdRestaurante(Integer idRestaurante) {
		this.idrestaurante = idRestaurante;
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
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public String getFranchise_id() {
		return franchise_id;
	}

	public void setFranchise_id(String franchise_id) {
		this.franchise_id = franchise_id;
	}

	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Double getPromedioCalificaciones() {
		return promedioCalificaciones;
	}

	public void setPromedioCalificaciones(Double promedioCalificaciones) {
		this.promedioCalificaciones = promedioCalificaciones;
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
	
	public RestauranteView toView() {
		List<ProductoView> productosv = new ArrayList<ProductoView>();
		List<HorarioView> horariosv = new ArrayList<HorarioView>();
		
		for (Producto p: productos) {
			productosv.add(p.toViewSimple());
		}
		for (Horario h: horarios) {
			horariosv.add(h.toView());
		}
		return new RestauranteView(idrestaurante, franchise_id, nombre, direccion.toView(), foto, promedioCalificaciones, minimoCompra, tipo, costoEnvio, productosv, horariosv);
	}
	
	public RestauranteView toViewSimple() {
		return new RestauranteView(idrestaurante, franchise_id, nombre, direccion.toView(), foto, promedioCalificaciones, tipo);
	}
}
