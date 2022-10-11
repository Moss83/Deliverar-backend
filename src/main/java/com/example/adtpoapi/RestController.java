package com.example.adtpoapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.adtpoapi.controlador.Controlador;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private Controlador controlador;
	
	@CrossOrigin(origins = "http://localhost:19006")
	@GetMapping("/verificarMail")
	public boolean verificarMail (@RequestParam(name = "mail") String mail) {
		return controlador.verificarMail(mail);
	}
	
	@GetMapping("/")
	public String getSaludo() {
		return "Hola Mundo!";
	}
}
