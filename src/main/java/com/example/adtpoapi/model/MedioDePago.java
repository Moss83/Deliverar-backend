package com.example.adtpoapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.adtpoapi.view.MedioDePagoView;

@Entity
@Table(name = "mediospago")
public class MedioDePago {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idmedio;
	private String nombre;
	private String tipo;
	
	public MedioDePago(Integer idMedio, String nombre, String tipo) {
		this.idmedio = idMedio;
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	public MedioDePago() {}
	
	public Integer getIdMedio() {
		return idmedio;
	}
	public void setIdMedio(Integer idMedio) {
		this.idmedio = idMedio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public MedioDePagoView toView() {
		return new MedioDePagoView(idmedio, nombre, tipo);
	}
}
