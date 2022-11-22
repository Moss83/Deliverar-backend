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
	
	public void eliminarDuplicados(List<String> duplicados) {
		for (String i: duplicados) {
			Example<Ingrediente> example = Example.of(new Ingrediente(i));
			List<Ingrediente> ings = ingredienteRepository.findAll(example);
			for (int j = 0; j < ings.size(); j++) {
				if (j != 0) {
					ingredienteRepository.deleteById(ings.get(j).getIdIngrediente());
				}
			}
		}
	}
	
}
