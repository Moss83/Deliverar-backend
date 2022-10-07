package com.example.adtpoapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "horarios")
public class Horario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHorario;
	@ManyToOne()
	@JoinColumn(name = "idRestaurante")
	private Restaurante restaurante;
	private String diaSemana;
	private LocalDate horaDesde;
	private LocalDate horaHasta;
	
	public Horario(Integer idHorario, Restaurante restaurante, String diaSemana, LocalDate horaDesde,
			LocalDate horaHasta) {
		this.idHorario = idHorario;
		this.restaurante = restaurante;
		this.diaSemana = diaSemana;
		this.horaDesde = horaDesde;
		this.horaHasta = horaHasta;
	}
	
	public Horario() {}
	
	public Integer getIdHorario() {
		return idHorario;
	}
	public void setIdHorario(Integer idHorario) {
		this.idHorario = idHorario;
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
	public LocalDate getHoraDesde() {
		return horaDesde;
	}
	public void setHoraDesde(LocalDate horaDesde) {
		this.horaDesde = horaDesde;
	}
	public LocalDate getHoraHasta() {
		return horaHasta;
	}
	public void setHoraHasta(LocalDate horaHasta) {
		this.horaHasta = horaHasta;
	}
	
	
}
