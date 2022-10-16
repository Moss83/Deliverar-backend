package com.example.adtpoapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.adtpoapi.view.DireccionView;

@Entity
@Table(name = "direcciones")
public class Direccion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iddireccion;
	private String calle;
	private Integer altura;
	private String tipoHogar;
	private Integer piso;
	private String departamento;
	private String ciudad;
	private String provincia;
	
	
	public Direccion(Integer idDireccion, String calle, Integer altura, String tipoHogar, Integer piso,
			String departamento, String ciudad, String provincia) {
		this.iddireccion = idDireccion;
		this.calle = calle;
		this.altura = altura;
		this.tipoHogar = tipoHogar;
		this.piso = piso;
		this.departamento = departamento;
		this.ciudad = ciudad;
		this.provincia = provincia;
	}
	
	public Direccion(String calle, Integer altura, String tipoHogar, Integer piso, String departamento, String ciudad,
			String provincia) {
		this.calle = calle;
		this.altura = altura;
		this.tipoHogar = tipoHogar;
		this.piso = piso;
		this.departamento = departamento;
		this.ciudad = ciudad;
		this.provincia = provincia;
	}



	public Direccion() {}
	
	public Integer getIdDireccion() {
		return iddireccion;
	}
	public void setIdDireccion(Integer idDireccion) {
		this.iddireccion = idDireccion;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public Integer getAltura() {
		return altura;
	}
	public void setAltura(Integer altura) {
		this.altura = altura;
	}
	public String getTipoHogar() {
		return tipoHogar;
	}
	public void setTipoHogar(String tipoHogar) {
		this.tipoHogar = tipoHogar;
	}
	public Integer getPiso() {
		return piso;
	}
	public void setPiso(Integer piso) {
		this.piso = piso;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public DireccionView toView() {
		return new DireccionView(iddireccion, calle, altura, tipoHogar, piso, departamento, ciudad, provincia);
	}
}
