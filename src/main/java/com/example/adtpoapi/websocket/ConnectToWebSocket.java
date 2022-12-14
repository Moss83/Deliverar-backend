package com.example.adtpoapi.websocket;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import com.example.adtpoapi.controlador.Controlador;
import com.example.adtpoapi.model.Direccion;
import com.example.adtpoapi.model.Ingrediente;
import com.example.adtpoapi.model.MensajeFranquicia;
import com.example.adtpoapi.model.MensajePagos;
import com.example.adtpoapi.model.MensajeRepartidor;
import com.example.adtpoapi.model.Producto;
import com.example.adtpoapi.model.Restaurante;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class ConnectToWebSocket extends StompSessionHandlerAdapter{
	
	 @Autowired
	 private Controlador controlador;
	
	 @Override
	 public void afterConnected(StompSession session, StompHeaders headers) {
		 session.subscribe("/topic/cliente", this);
	     String message = "one-time message from client";
	     session.send("/app/cliente", message); //reemplazar cliente por el nombre del m�dulo que corresponda
	 }
	 
	 @Override
	 public Type getPayloadType(StompHeaders headers) {
		 return Mensaje.class;
	  }
	 
	  @Override
	  public void handleFrame(StompHeaders headers, Object payload) {
		  Mensaje msg = (Mensaje) payload;
		  System.out.println("Contenido: " + msg.getContenido() + " - Emisor: " + msg.getEmisor());
		  JsonParser parser = new JsonParser();
		  JsonObject contenido = parser.parse(msg.getContenido()).getAsJsonObject();
		  
		  if (msg.getEmisor().equalsIgnoreCase("repartidor")) {
			  if (contenido.has("tipo") && contenido.get("tipo").getAsString().equalsIgnoreCase("actualizacion-ubicacion")) {
				  MensajeRepartidor actual = controlador.getMensajeRepartidor(contenido.get("mensaje").getAsJsonObject().get("order_id").getAsInt());
				  if (actual.getIdentificador() == 0) {
					  MensajeRepartidor mensaje = new MensajeRepartidor(contenido.get("mensaje").getAsJsonObject().get("order_id").getAsInt(), contenido.get("mensaje").getAsJsonObject().get("latitud").getAsString(), contenido.get("mensaje").getAsJsonObject().get("longitud").getAsString(), contenido.get("mensaje").getAsJsonObject().get("status").getAsString(), contenido.get("mensaje").getAsJsonObject().get("username").getAsString());  
					  controlador.addMensajeRepartidor(mensaje);
				  }
				  else {
					  actual.setLatitud(contenido.get("mensaje").getAsJsonObject().get("latitud").getAsString());
					  actual.setLongitud(contenido.get("mensaje").getAsJsonObject().get("longitud").getAsString());
					  controlador.addMensajeRepartidor(actual);
				  }
			  }
			  else if (contenido.has("tipo") && contenido.get("tipo").getAsString().equalsIgnoreCase("actualizacion-pedido") && contenido.get("mensaje").getAsJsonObject().get("status").getAsString().equalsIgnoreCase("ENTREGADO")) {
				  MensajeRepartidor actual = controlador.getMensajeRepartidor(contenido.get("mensaje").getAsJsonObject().get("order_id").getAsInt());
				  actual.setStatus("ENTREGADO");
				  controlador.addMensajeRepartidor(actual);
			  }
			  else {
				  System.out.println("Repartidor mando otra cosa");  
			  }
		  }
		  else if (msg.getEmisor().equalsIgnoreCase("franquicia")) {
			  if (contenido.get("tipo").getAsString().equalsIgnoreCase("listado")) {
				  List<Producto> productos = new ArrayList<Producto>();
				  Ingrediente ing;
				  Producto prod;
				  Restaurante restaurante;
				  Set<String> idIngredientes = new HashSet<String>();
				  List<Ingrediente> ingredientesNuevos = new ArrayList<Ingrediente>();
				  List<Ingrediente> utilizar = new ArrayList<Ingrediente>();
				  JsonObject mensaje = contenido.get("mensaje").getAsJsonObject();
				  JsonObject franquicia = mensaje.get("franquicia").getAsJsonObject();
				  String[] listaDireccion = franquicia.get("direccion").getAsString().split(" ");
				  String calle = "";
				  String altura = "";
				  for (int j = 0; j < listaDireccion.length; j++) {
					  if (j < listaDireccion.length - 2) {
						  calle += listaDireccion[j] + " ";
					  }
					  else if (j == listaDireccion.length - 2) {
						  calle += listaDireccion[j];
					  }
					  else {
						  altura = listaDireccion[j];
					  }
				  }
				  Direccion direccion = new Direccion(calle, Integer.parseInt(altura));
				  restaurante = new Restaurante(franquicia.get("nombre").getAsString(), direccion, franquicia.get("_id").getAsString(), franquicia.get("foto_url").getAsString());
				  Integer idRestaurante = controlador.verificarRestaurante(restaurante);
				  System.out.println(idRestaurante);
				  if (idRestaurante != 0) {
					  restaurante.setIdRestaurante(idRestaurante);
				  }
				  for (JsonElement p: mensaje.get("meals").getAsJsonArray()) {
					  JsonObject po = p.getAsJsonObject();
					  for (JsonElement i: po.get("productos").getAsJsonArray()) {
						  JsonObject io = i.getAsJsonObject();
						  if (!idIngredientes.contains(io.get("_id").getAsString())) {
							  idIngredientes.add(io.get("_id").getAsString());
							  ing = new Ingrediente(io.get("_id").getAsString(), io.get("descripcion").getAsString(), io.get("cantidad").getAsInt(), io.get("codigo_producto").getAsString(), io.get("precio").getAsDouble());
							  Integer idIngrediente = controlador.verificarIngrediente(ing);
							  if (idIngrediente != 0) {
								  ing.setIdIngrediente(idIngrediente);
								  utilizar.add(ing);
							  }
							  else {
								  ingredientesNuevos.add(new Ingrediente(io.get("_id").getAsString(), io.get("descripcion").getAsString(), io.get("cantidad").getAsInt(), io.get("codigo_producto").getAsString(), io.get("precio").getAsDouble()));
							  }
						  }
					  }
				  }
				  List<Ingrediente> ingNuevosGuardados = controlador.guardarIngredientes(ingredientesNuevos);
				  for (Ingrediente in: ingNuevosGuardados) {
					  utilizar.add(in);
				  }
				  for (JsonElement p: mensaje.get("meals").getAsJsonArray()) {
					  JsonObject po = p.getAsJsonObject();
					  prod = new Producto(po.get("_id").getAsString(), restaurante, po.get("nombre").getAsString(), po.get("descripcion").getAsString(), po.get("url_foto").getAsString(), po.get("precio").getAsDouble());
					  Integer idProducto = controlador.verificarProducto(prod);
					  System.out.println(idProducto);
					  if (idProducto != 0) {
						  prod.setIdProducto(idProducto);
					  }
					  for (JsonElement i: po.get("productos").getAsJsonArray()) {
						  JsonObject io = i.getAsJsonObject();
						  for (Ingrediente ingr: utilizar) {
							  if (ingr.getIngredient_id().equals(io.get("_id").getAsString())) {
								  prod.addIngrediente(ingr);
							  }
						  }
					  }
					  productos.add(prod);
				  }
				  restaurante.setProductos(productos);
				  controlador.upsertRestaurant(restaurante);
			  }
			  else if (contenido.get("tipo").getAsString().equalsIgnoreCase("actualizacion-pedido")) {
				  MensajeFranquicia actual = controlador.getMensajeFranquicia(contenido.get("mensaje").getAsJsonObject().get("order_id").getAsInt());
				  if (actual.getIdentificador() == 0) {
					  MensajeFranquicia mensaje = new MensajeFranquicia("confirmacion", contenido.get("mensaje").getAsJsonObject().get("order_id").getAsInt(), contenido.get("mensaje").getAsJsonObject().get("order_status").getAsString());
					  controlador.addMensajeFranquicia(mensaje);
				  }
				  else {
					  actual.setMensaje(contenido.get("mensaje").getAsJsonObject().get("order_status").getAsString());
					  controlador.addMensajeFranquicia(actual);
				  }
			  }
			  else {
				  System.out.println("Franquicia mando otra cosa");
			  }
		  }
		  else if (msg.getEmisor().equalsIgnoreCase("partners")) {
			  if (contenido.get("tipo").getAsString().equalsIgnoreCase("compra") && !contenido.has("error")) {
				  MensajePagos mensaje = new MensajePagos("Confirmado");
				  controlador.saveMensajePagos(mensaje);
			  }
			  else if (contenido.get("tipo").getAsString().equalsIgnoreCase("compra") && contenido.has("error")) {
				  MensajePagos mensaje = new MensajePagos(contenido.get("error").getAsString());
				  controlador.saveMensajePagos(mensaje);
			  }
			  else {
				  System.out.println("Pagos mando otra cosa");
			  }
		  }
	   }
	   
	   @Override
	   public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
		   System.out.println("Error: "+exception.getMessage());
	   }
	   @Override
	   public void handleTransportError(StompSession session, Throwable exception) {
		   System.out.println("Error: "+exception.getMessage());
	   }

}
