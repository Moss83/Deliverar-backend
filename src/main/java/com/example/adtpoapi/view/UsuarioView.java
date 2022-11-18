package com.example.adtpoapi.view;

import java.io.Serializable;

public class UsuarioView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4274151628927224476L;
	
	private Integer idUsuario;
	private String mail;
	private String nombre;
	private String contraseña;
	private String redSocial; 
	private Integer habilitado;
	private Integer codigoVerificacion;
	private String avatar;
	private Integer dni;
	private DireccionView direccion;
	
	
	public UsuarioView(Integer idUsuario, String mail, String nombre, String contraseña, String redSocial,
			Integer habilitado, Integer codigoVerificacion, String avatar, Integer dni, DireccionView direccion) {
		this.idUsuario = idUsuario;
		this.mail = mail;
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.redSocial = redSocial;
		this.habilitado = habilitado;
		this.codigoVerificacion = codigoVerificacion;
		this.avatar = avatar;
		this.dni = dni;
		this.direccion = direccion;
	}
	
	public UsuarioView() {}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getRedSocial() {
		return redSocial;
	}

	public void setRedSocial(String redSocial) {
		this.redSocial = redSocial;
	}

	public Integer getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(Integer habilitado) {
		this.habilitado = habilitado;
	}

	public Integer getCodigoVerificacion() {
		return codigoVerificacion;
	}

	public void setCodigoVerificacion(Integer codigoVerificacion) {
		this.codigoVerificacion = codigoVerificacion;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public DireccionView getDireccion() {
		return direccion;
	}

	public void setDireccion(DireccionView direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "UsuarioView [idUsuario=" + idUsuario + ", mail=" + mail + ", nombre=" + nombre + ", habilitado="
				+ habilitado + "]";
	}

}
