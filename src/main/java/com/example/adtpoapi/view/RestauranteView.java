package com.example.adtpoapi.view;

import java.io.Serializable;
import java.util.List;

public class RestauranteView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3955745152051166951L;
	private Integer idrestaurante;
	private String franchise_id;
	private String nombre;
	private DireccionView direccion;
	private String foto;
	private Double promedioCalificaciones;
	private Double minimoCompra;
	private String tipo;
	private Double costoEnvio;
	private List<ProductoView> productos;
	private List<HorarioView> horarios;
	
	public RestauranteView(Integer idRestaurante, String franchise_id, String nombre, DireccionView direccion, String foto, Double promedioCalificaciones,
			Double minimoCompra, String tipo, Double costoEnvio, List<ProductoView> productos,
			List<HorarioView> horarios) {
		this.idrestaurante = idRestaurante;
		this.franchise_id = franchise_id;
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
	
	public RestauranteView(Integer idRestaurante, String franchise_id, String nombre, DireccionView direccion, String foto,
			Double promedioCalificaciones, String tipo) {
		this.idrestaurante = idRestaurante;
		this.franchise_id = franchise_id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.foto = foto;
		this.promedioCalificaciones = promedioCalificaciones;
		this.tipo = tipo;
	}

	public RestauranteView() {}

	public Integer getIdRestaurante() {
		return idrestaurante;
	}

	public void setIdRestaurante(Integer idRestaurante) {
		this.idrestaurante = idRestaurante;
	}

	public String getFranchise_id() {
		return franchise_id;
	}

	public void setFranchise_id(String franchise_id) {
		this.franchise_id = franchise_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public DireccionView getDireccion() {
		return direccion;
	}

	public void setDireccion(DireccionView direccion) {
		this.direccion = direccion;
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

	public List<ProductoView> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoView> productos) {
		this.productos = productos;
	}

	public List<HorarioView> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<HorarioView> horarios) {
		this.horarios = horarios;
	}


	@Override
	public String toString() {
		return "RestauranteView [idRestaurante=" + idrestaurante + ", nombre=" + nombre + ", direccion=" + direccion
				+ ", tipo=" + tipo + "]";
	}
	
	
}
