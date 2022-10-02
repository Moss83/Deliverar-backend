package com.example.adtpoapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "pagorestaurante")
public class PagoRestaurante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPagoRestaurante;
	private MedioDePago medio;
	private Restaurante restaurante;
	
	public PagoRestaurante(Integer idPagoRestaurante, MedioDePago medio, Restaurante restaurante) {
		super();
		this.idPagoRestaurante = idPagoRestaurante;
		this.medio = medio;
		this.restaurante = restaurante;
	}
	
	public Integer getIdPagoRestaurante() {
		return idPagoRestaurante;
	}
	public void setIdPagoRestaurante(Integer idPagoRestaurante) {
		this.idPagoRestaurante = idPagoRestaurante;
	}
	public MedioDePago getMedio() {
		return medio;
	}
	public void setMedio(MedioDePago medio) {
		this.medio = medio;
	}
	public Restaurante getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	
	
	
	
	
}
