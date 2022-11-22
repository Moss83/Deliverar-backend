package com.example.adtpoapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
	
	public void saveRestaurante(Restaurante restaurante) {
		restauranteRepository.save(restaurante);
	}

	public int verificarRestaurante(Restaurante restaurante) {
		Example<Restaurante> example = Example.of(new Restaurante(restaurante.getFranchise_id()));
		Optional<Restaurante> actual = restauranteRepository.findOne(example);
		
		if (actual.isEmpty()) {
			return 0;
		}
		else {
			return actual.get().getIdRestaurante();
		}
	}
	
}
