package com.example.adtpoapi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.adtpoapi.entities.DireccionRepository;
import com.example.adtpoapi.model.Direccion;

@Service
public class DireccionDAO {

	@Autowired
	private DireccionRepository direccionRepository;
	
	public int saveDireccion(Direccion direccion) {
		return direccionRepository.save(direccion).getIdDireccion();
	}
}
