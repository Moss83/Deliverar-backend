package com.example.adtpoapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.adtpoapi.entities.RestauranteRepository;
import com.example.adtpoapi.exception.NoContentException;
import com.example.adtpoapi.model.Restaurante;

@Service
public class RestauranteDAO {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	public List<Restaurante> getRestaurantes() {
		// TODO Auto-generated method stub
		return restauranteRepository.findAll();
	}
	
	public Restaurante getRestauranteById(Integer idRestaurante) throws NoContentException {
		return restauranteRepository.findById(idRestaurante).orElseThrow(() -> new NoContentException());
	}
	
	
}
