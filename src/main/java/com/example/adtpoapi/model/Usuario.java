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
	private Integer idusuario;
	private String mail;
	private String nombre;
	private String contraseña;
	@Column(name = "red_social")
	private String redSocial; 
	private Integer habilitado;
	@Column(name = "codigo_verificacion")
	private Integer codigoVerificacion;
	private String avatar;
	private Integer dni;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "iddireccion")
	private Direccion direccion;
	
	
	public Usuario(Integer idUsuario, String mail, String nombre, String contraseña, String redSocial,
			Integer habilitado, Integer codigoVerificacion, String avatar, Integer dni, Direccion direccion) {
		this.idusuario = idUsuario;
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
	
	public Usuario(String mail, String nombre, String contraseña, Integer habilitado, String avatar, Integer dni, Direccion direccion) {
		this.mail = mail;
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.habilitado = habilitado;
		this.avatar = avatar;
		this.dni = dni;
		this.direccion = direccion;
	}

	public Usuario(String mail) {
		this.mail = mail;
	}

	public Usuario() {}
	
	public Integer getIdUsuario() {
		return idusuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idusuario = idUsuario;
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

	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	public UsuarioView toView() {
		return new UsuarioView(idusuario, mail, nombre, contraseña, redSocial, habilitado, codigoVerificacion, avatar, dni, direccion.toView());
	}
}
