package com.example.adtpoapi.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.adtpoapi.entities.MensajeRepartidorRepository;
import com.example.adtpoapi.exception.NoContentException;
import com.example.adtpoapi.model.MensajeRepartidor;

@Service
public class MensajeRepartidorDAO {
	
	@Autowired
	private MensajeRepartidorRepository mensajeRepartidorRepository;
	
	public MensajeRepartidor getMensajeInterno(Integer identificador) {
		Example<MensajeRepartidor> example = Example.of(new MensajeRepartidor(identificador));
		Optional<MensajeRepartidor> actual = mensajeRepartidorRepository.findOne(example);
		
		if (actual.isEmpty()) {
			return new MensajeRepartidor(0);
		}
		else {
			return actual.get();
		}
	}
	
	public MensajeRepartidor getMensaje(Integer identificador) throws NoContentException {
		Example<MensajeRepartidor> example = Example.of(new MensajeRepartidor(identificador));
		Optional<MensajeRepartidor> actual = mensajeRepartidorRepository.findOne(example);
		
		if (actual.isEmpty()) {
			throw new NoContentException();
		}
		else {
			return actual.get();
		}
	}

	public void saveMensaje(MensajeRepartidor mensaje) {
		mensajeRepartidorRepository.save(mensaje);
	}
}
