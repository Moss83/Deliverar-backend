package com.example.adtpoapi.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.adtpoapi.entities.MensajeFranquiciaRepository;
import com.example.adtpoapi.exception.NoContentException;
import com.example.adtpoapi.model.MensajeFranquicia;

@Service
public class MensajeFranquiciaDAO {

	@Autowired
	private MensajeFranquiciaRepository mensajeFranquiciaRepository;
	
	public void saveMensaje(MensajeFranquicia mensaje) {
		mensajeFranquiciaRepository.save(mensaje);
	}
	
	public MensajeFranquicia getMensaje(Integer identificador) throws NoContentException {
		Example<MensajeFranquicia> example = Example.of(new MensajeFranquicia(identificador));
		Optional<MensajeFranquicia> actual = mensajeFranquiciaRepository.findOne(example);
		
		if (actual.isEmpty()) {
			throw new NoContentException();
		}
		else {
			return actual.get();
		}
	}
	
	public MensajeFranquicia getMensajeInterno(Integer identificador) {
		Example<MensajeFranquicia> example = Example.of(new MensajeFranquicia(identificador));
		Optional<MensajeFranquicia> actual = mensajeFranquiciaRepository.findOne(example);
		
		if (actual.isEmpty()) {
			return new MensajeFranquicia(0);
		}
		else {
			return actual.get();
		}
	}
	
}
