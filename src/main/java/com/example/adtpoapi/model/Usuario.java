package com.example.adtpoapi.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.example.adtpoapi.view.UsuarioView;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	private String mail;
	private String nombre;
	private String contraseña;
	@Column(name = "red_social")
	private String redSocial; 
	private Integer habilitado;
	@Column(name = "codigo_verificacion")
	private Integer codigoVerificacion;
	private String avatar;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idDireccion")
	private Direccion direccion;
	
	
	public Usuario(Integer idUsuario, String mail, String nombre, String contrasenia, String redSocial,
			Integer habilitado, Integer codigoVerificacion, String avatar, Direccion direccion) {
		this.idUsuario = idUsuario;
		this.mail = mail;
		this.nombre = nombre;
		this.contraseña = contrasenia;
		this.redSocial = redSocial;
		this.habilitado = habilitado;
		this.codigoVerificacion = codigoVerificacion;
		this.avatar = avatar;
		this.direccion = direccion;
	}
	
	public Usuario(String mail) {
		this.mail = mail;
	}

	public Usuario() {}
	
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
	public String getContrasenia() {
		return contraseña;
	}
	public void setContrasenia(String contrasenia) {
		this.contraseña = contrasenia;
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
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	public UsuarioView toView() {
		return new UsuarioView(idUsuario, mail, nombre, contraseña, redSocial, habilitado, codigoVerificacion, avatar, direccion.toView());
	}
}
