package com.example.adtpoapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.adtpoapi.controlador.Controlador;
import com.example.adtpoapi.view.ConfirmacionFranquiciaView;
import com.example.adtpoapi.view.MensajePagosView;
import com.example.adtpoapi.view.MensajeRepartidorView;
import com.example.adtpoapi.view.OrdenView;
import com.example.adtpoapi.view.ProductoView;
import com.example.adtpoapi.view.RestauranteView;
import com.example.adtpoapi.view.UsuarioView;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private Controlador controlador;
	
	@CrossOrigin(origins = "http://localhost:19006")
	@PostMapping("/getLogin") 
	public UsuarioView login (@RequestBody UsuarioView usuario) {
		return controlador.login(usuario);
	}
	
	@CrossOrigin(origins = "http://localhost:19006")
	@GetMapping("/verificarMail")
	public boolean verificarMail (@RequestParam(name = "mail") String mail) {
		return controlador.verificarMail(mail);
	}
	
	@CrossOrigin(origins = "http://localhost:19006")
	@PostMapping("/addUsuario") 
	public int addUsuario(@RequestBody UsuarioView usuario) { 
		return controlador.addUsuario(usuario);
	}
	
	@CrossOrigin(origins = "http://localhost:19006")
	@GetMapping("/getCategoriasRestaurantes")
	public List<String> getCategoriasRestaurantes() {
		return controlador.getCategoriasRestaurantes();
	}
	
	@CrossOrigin(origins = "http://localhost:19006")
	@PostMapping("/getRestaurantes")
	public List<RestauranteView> getRestaurantes(@RequestBody FiltroVO filtros) {
		return controlador.getRestaurantes(filtros);
	}
	
	@CrossOrigin(origins = "http://localhost:19006")
	@GetMapping("/getRestaurante")
	public RestauranteView getRestaurante(@RequestParam(name = "idRestaurante") Integer idRestaurante) {
		return controlador.getRestaurante(idRestaurante);
	}
	
	@CrossOrigin(origins = "http://localhost:19006")
	@GetMapping("/getProducto")
	public ProductoView getProducto(@RequestParam(name = "idProducto") Integer idProducto) { 
		return controlador.getProducto(idProducto);
	}
	
	@CrossOrigin(origins = "http://localhost:19006")
	@PostMapping("/updateUsuario")
	public void updateUsuario(@RequestBody UsuarioView usuario) {
		controlador.actualizarUsuario(usuario);
	}
	
	@CrossOrigin(origins = "http://localhost:19006")
	@PostMapping("/addOrden")
	public OrdenVO addOrden(@RequestBody OrdenView orden) {
		System.out.println(orden);
		return controlador.addOrden(orden);
	}
	
	@CrossOrigin(origins = "http://localhost:19006")
	@GetMapping("/getConfirmacionFranquicia")
	public ConfirmacionFranquiciaView getConfirmacionFranquicia(@RequestParam(name = "idorden") Integer idorden) {
		return controlador.getConfirmacionFranquicia(idorden);
	}
	
	@CrossOrigin(origins = "http://localhost:19006")
	@GetMapping("/getDatosRepartidor")
	public MensajeRepartidorView getDatosRepartidor(@RequestParam(name = "idorden") Integer idorden) {
		return controlador.getDatosRepartidor(idorden);
	}
	
	@CrossOrigin(origins = "http://localhost:19006")
	@GetMapping("/getConfirmacionPagos")
	public MensajePagosView getConfirmacionPagos() {
		return controlador.getMensajePagos();
	}
	
	
	@GetMapping("/")
	public String getSaludo() {
		return "Hola Mundo!";
	}
}
