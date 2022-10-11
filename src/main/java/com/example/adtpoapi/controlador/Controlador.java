package com.example.adtpoapi.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.adtpoapi.dao.UsuarioDAO;
import com.example.adtpoapi.exception.NoContentException;

@Service
public class Controlador {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	public boolean verificarMail (String mail) throws NoContentException {
		return usuarioDAO.existeMail(mail);
	}
	
}
