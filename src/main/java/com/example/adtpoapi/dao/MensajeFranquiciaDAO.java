package com.example.adtpoapi.dao;

import org.springframework.beans.factory.annotation.Autowired;
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
		return mensajeFranquiciaRepository.findById(identificador).orElseThrow(() -> new NoContentException());
	}
}
