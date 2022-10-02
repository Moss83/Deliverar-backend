package com.example.adtpoapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mediospago")
public class MedioDePago {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMedio;
	private String nombre;
	private String tipo;
	
	public MedioDePago(Integer idMedio, String nombre, String tipo) {
		super();
		this.idMedio = idMedio;
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	public Integer getIdMedio() {
		return idMedio;
	}
	public void setIdMedio(Integer idMedio) {
		this.idMedio = idMedio;
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
}
