package com.example.adtpoapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.adtpoapi.view.HorarioView;

@Entity
@Table(name = "horarios")
public class Horario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idhorario;
	@ManyToOne()
	@JoinColumn(name = "idrestaurante")
	private Restaurante restaurante;
	@Column(name = "dia_semana")
	private String diaSemana;
	@Column(name = "hora_desde")
	private Date horaDesde;                
	@Column(name = "hora_hasta")
	private Date horaHasta;
	
	public Horario(Integer idHorario, Restaurante restaurante, String diaSemana, Date horaDesde,
			Date horaHasta) {
		this.idhorario = idHorario;
		this.restaurante = restaurante;
		this.diaSemana = diaSemana;
		this.horaDesde = horaDesde;
		this.horaHasta = horaHasta;
	}
	
	public Horario() {}
	
	public Integer getIdHorario() {
		return idhorario;
	}
	public void setIdHorario(Integer idHorario) {
		this.idhorario = idHorario;
	}
	public Restaurante getResturante() {
		return restaurante;
	}
	public void setIdResturante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	public String getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}
	public Date getHoraDesde() {
		return horaDesde;
	}
	public void setHoraDesde(Date horaDesde) {
		this.horaDesde = horaDesde;
	}
	public Date getHoraHasta() {
		return horaHasta;
	}
	public void setHoraHasta(Date horaHasta) {
		this.horaHasta = horaHasta;
	}
	
	public HorarioView toView() {
		return new HorarioView(idhorario, diaSemana, horaDesde, horaHasta);
	}
}
