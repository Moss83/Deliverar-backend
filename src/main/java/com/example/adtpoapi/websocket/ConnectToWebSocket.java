package com.example.adtpoapi.websocket;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import com.example.adtpoapi.controlador.Controlador;
import com.example.adtpoapi.model.Direccion;
import com.example.adtpoapi.model.Ingrediente;
import com.example.adtpoapi.model.MensajeFranquicia;
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
			  if (contenido.get("tipo").getAsString().equalsIgnoreCase("en camino")) {
				  System.out.println("En camino");
			  }
			  else if (contenido.get("tipo").getAsString().equalsIgnoreCase("entregado")){
				  System.out.println("Entregado");
			  }
			  else if (contenido.get("tipo").getAsString().equalsIgnoreCase("coordenadas")) {
				  System.out.println("Coordenadas Update");
			  }
			  else {
				  System.out.println("Repartidor mando otra cosa");  
			  }
		  }
		  else if (msg.getEmisor().equalsIgnoreCase("franquicia")) {
			  if (contenido.get("tipo").getAsString().equalsIgnoreCase("listado")) {
				  List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
				  List<Producto> productos = new ArrayList<Producto>();
				  Restaurante restaurante;
				  JsonObject mensaje = contenido.get("mensaje").getAsJsonObject();
				  for (JsonElement p: mensaje.get("meals").getAsJsonArray()) {
					  JsonObject po = p.getAsJsonObject();
					  for (JsonElement i: po.get("productos").getAsJsonArray()) {
						  JsonObject io = i.getAsJsonObject();
						  ingredientes.add(new Ingrediente(io.get("_id").getAsString(), io.get("descripcion").getAsString(), io.get("cantidad").getAsInt()));
					  }
					  productos.add(new Producto(po.get("_id").getAsString(), po.get("nombre").getAsString(), po.get("descripcion").getAsString(), po.get("url_foto").getAsString(), po.get("precio").getAsDouble(), ingredientes));
					  ingredientes.clear();
				  }
				  JsonObject franquicia = mensaje.get("franquicia").getAsJsonObject();
				  String[] listaDireccion = franquicia.get("direccion").getAsString().split(" ");
				  String calle = "";
				  String altura = "";
				  for (int j = 0; j < listaDireccion.length; j++) {
					  if (j < listaDireccion.length - 2) {
						  calle += listaDireccion[j] + " ";
					  }
					  else if (j == listaDireccion.length - 1) {
						  calle += listaDireccion[j];
					  }
					  else {
						  altura = listaDireccion[j];
					  }
				  }
				  Direccion direccion = new Direccion(calle, Integer.parseInt(altura));
				  restaurante = new Restaurante(franquicia.get("_id").getAsString(), franquicia.get("nombre").getAsString(), direccion, franquicia.get("foto").getAsString(), productos);
				  System.out.println("Contenido: " + msg.getContenido() + " - Emisor: " + msg.getEmisor());
				  controlador.upsertRestaurant(restaurante);
			  }
			  else if (contenido.get("tipo").getAsString().equalsIgnoreCase("actualizacion-pedido")) {
				  MensajeFranquicia mensaje = new MensajeFranquicia("confirmacion", contenido.get("mensaje").getAsJsonObject().get("idorden").getAsInt(), contenido.get("mensaje").getAsString());
				  controlador.addMensajeFranquicia(mensaje);
				  System.out.println("Contenido: " + msg.getContenido() + " - Emisor: " + msg.getEmisor());
			  }
			  else {
				  System.out.println("Franquicia mando otra cosa");
			  }
		  }
		  else if (msg.getEmisor().equalsIgnoreCase("partners")) {
			  if (contenido.get("tipo").getAsString().equalsIgnoreCase("confirmacion")) {
				  
			  }
			  else {
				  System.out.println("Pagos mando otra cosa");
			  }
		  }
		  else {
			  System.out.println("Contenido: " + msg.getContenido() + " - Emisor: " + msg.getEmisor());
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
