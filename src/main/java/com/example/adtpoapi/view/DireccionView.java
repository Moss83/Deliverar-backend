package com.example.adtpoapi.view;

import java.io.Serializable;

public class DireccionView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -546636632882488199L;
	private Integer idDireccion;
	private String calle;
	private Integer altura;
	private String tipoHogar;
	private Integer piso;
	private String departamento;
	private String ciudad;
	private String provincia;
	
	public DireccionView(Integer idDireccion, String calle, Integer altura, String tipoHogar, Integer piso,
			String departamento, String ciudad, String provincia) {
		this.idDireccion = idDireccion;
		this.calle = calle;
		this.altura = altura;
		this.tipoHogar = tipoHogar;
		this.piso = piso;
		this.departamento = departamento;
		this.ciudad = ciudad;
		this.provincia = provincia;
	}
	
	public DireccionView() {}
	
	public Integer getIdDireccion() {
		return idDireccion;
	}
	public void setIdDireccion(Integer idDireccion) {
		this.idDireccion = idDireccion;
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

	@Override
	public String toString() {
		return "DireccionView [idDireccion=" + idDireccion + ", calle=" + calle + ", altura=" + altura + ", tipoHogar="
				+ tipoHogar + ", piso=" + piso + ", departamento=" + departamento + ", ciudad=" + ciudad
				+ ", provincia=" + provincia + "]";
	}
	
	
}
