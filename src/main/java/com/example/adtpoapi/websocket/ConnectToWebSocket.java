package com.example.adtpoapi.websocket;

import java.lang.reflect.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import com.example.adtpoapi.controlador.Controlador;
import com.example.adtpoapi.model.MensajeFranquicia;
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
			  else {
				  System.out.println("Repartidor mando otra cosa");  
			  }
		  }
		  else if (msg.getEmisor().equalsIgnoreCase("franquicia")) {
			  if (contenido.get("tipo").getAsString().equalsIgnoreCase("restaurante")) {
				  //como pija sé cual restaurante es. Actualizar restaurante y productos.
			  }
			  else if (contenido.get("tipo").getAsString().equalsIgnoreCase("confirmacion")) {
				  MensajeFranquicia mensaje = new MensajeFranquicia("confirmacion", contenido.get("mensaje").getAsJsonObject().get("idorden").getAsInt(), contenido.get("mensaje").getAsString());
				  controlador.addMensajeFranquicia(mensaje);
			  }
			  else {
				  System.out.println("Franquicia mando otra cosa");
			  }
		  }
		  else if (msg.getEmisor().equalsIgnoreCase("pagos")) {
			  if (contenido.get("tipo").getAsString().equalsIgnoreCase("confirmacion")) {
				  
			  }
			  else {
				  System.out.println("Pagos mando otra cosa");
			  }
		  }
		  else {
			  System.out.println("No quiero pagos ni prueba");
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
