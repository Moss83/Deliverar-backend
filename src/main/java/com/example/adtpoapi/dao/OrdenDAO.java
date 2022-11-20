package com.example.adtpoapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.adtpoapi.entities.OrdenRepository;
import com.example.adtpoapi.model.Orden;

@Service
public class OrdenDAO {

	@Autowired
	private OrdenRepository ordenRepository;
	
	public List<Orden> getOrdenes() {
		return ordenRepository.findAll();
	}
	
	public Orden saveOrden(Orden orden) {
		return ordenRepository.save(orden);
	}
}
