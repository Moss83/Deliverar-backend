package com.example.adtpoapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.adtpoapi.entities.MensajePagosRepository;
import com.example.adtpoapi.model.MensajePagos;

@Service
public class MensajePagosDAO {
	
	@Autowired
	private MensajePagosRepository mensajePagosRepository;
	
	public void saveMensaje(MensajePagos mensaje) {
		mensajePagosRepository.save(mensaje);
	}
	
	public MensajePagos getMensaje() {
		List<MensajePagos> miMensaje = mensajePagosRepository.findAll();
		mensajePagosRepository.deleteAll();
		return miMensaje.get(0);
	}
}
