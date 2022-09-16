package com.example.adtpoapi;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@GetMapping("/")
	public String getSaludo() {
		return "Hola Mundo!";
	}
}
