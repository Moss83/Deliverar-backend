package com.example.adtpoapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.adtpoapi.entities.IngredienteRepository;
import com.example.adtpoapi.model.Ingrediente;

@Service
public class IngredienteDAO {

	@Autowired
	private IngredienteRepository ingredienteRepository;

	public Integer verificarIngrediente(Ingrediente ing) {
		// TODO Auto-generated method stub
		Example<Ingrediente> example = Example.of(new Ingrediente(ing.getIngredient_id()));
		Optional<Ingrediente> actual = ingredienteRepository.findOne(example);
		
		if (actual.isEmpty()) {
			return 0;
		}
		else {
			return actual.get().getIdIngrediente();
		}
	}

	public List<Ingrediente> saveIngredientes(List<Ingrediente> ingredientes) {
		// TODO Auto-generated method stub
		return ingredienteRepository.saveAll(ingredientes);
	}
	
}
