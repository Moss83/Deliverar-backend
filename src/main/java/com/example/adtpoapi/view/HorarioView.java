package com.example.adtpoapi.view;

import java.io.Serializable;
import java.time.LocalDate;

public class HorarioView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8203494714718656250L;
	private Integer idHorario;
	private String diaSemana;
	private LocalDate horaDesde;
	private LocalDate horaHasta;
	
	public HorarioView(Integer idHorario, String diaSemana, LocalDate horaDesde, LocalDate horaHasta) {
		this.idHorario = idHorario;
		this.diaSemana = diaSemana;
		this.horaDesde = horaDesde;
		this.horaHasta = horaHasta;
	}
	
	public HorarioView() {}

	public Integer getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(Integer idHorario) {
		this.idHorario = idHorario;
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

	@Override
	public String toString() {
		return "HorarioView [idHorario=" + idHorario + ", diaSemana=" + diaSemana + ", horaDesde=" + horaDesde
				+ ", horaHasta=" + horaHasta + "]";
	}
	
	
}
