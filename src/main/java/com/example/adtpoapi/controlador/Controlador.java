package com.example.adtpoapi.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.adtpoapi.FiltroVO;
import com.example.adtpoapi.IngredienteProductoVO;
import com.example.adtpoapi.OrdenVO;
import com.example.adtpoapi.ProductosOrdenVO;
import com.example.adtpoapi.dao.DireccionDAO;
import com.example.adtpoapi.dao.IngredienteDAO;
import com.example.adtpoapi.dao.MensajeFranquiciaDAO;
import com.example.adtpoapi.dao.MensajePagosDAO;
import com.example.adtpoapi.dao.MensajeRepartidorDAO;
import com.example.adtpoapi.dao.OrdenDAO;
import com.example.adtpoapi.dao.ProductoDAO;
import com.example.adtpoapi.dao.RestauranteDAO;
import com.example.adtpoapi.dao.UsuarioDAO;
import com.example.adtpoapi.exception.NoContentException;
import com.example.adtpoapi.model.Direccion;
import com.example.adtpoapi.model.Ingrediente;
import com.example.adtpoapi.model.MensajeFranquicia;
import com.example.adtpoapi.model.MensajePagos;
import com.example.adtpoapi.model.MensajeRepartidor;
import com.example.adtpoapi.model.Orden;
import com.example.adtpoapi.model.Producto;
import com.example.adtpoapi.model.ProductosOrden;
import com.example.adtpoapi.model.Restaurante;
import com.example.adtpoapi.model.Usuario;
import com.example.adtpoapi.view.ConfirmacionFranquiciaView;
import com.example.adtpoapi.view.DireccionView;
import com.example.adtpoapi.view.MensajePagosView;
import com.example.adtpoapi.view.MensajeRepartidorView;
import com.example.adtpoapi.view.OrdenView;
import com.example.adtpoapi.view.ProductoView;
import com.example.adtpoapi.view.ProductosOrdenView;
import com.example.adtpoapi.view.RestauranteView;
import com.example.adtpoapi.view.UsuarioView;

@Service
public class Controlador {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private RestauranteDAO restauranteDAO;
	
	@Autowired
	private ProductoDAO productoDAO;
	
	@Autowired
	private DireccionDAO direccionDAO;
	
	@Autowired
	private OrdenDAO ordenDAO;
	
	@Autowired
	private IngredienteDAO ingredienteDAO;
	
	@Autowired
	private MensajeFranquiciaDAO mensajeFranquiciaDAO;
	
	@Autowired
	private MensajeRepartidorDAO mensajeRepartidorDAO;
	
	@Autowired
	private MensajePagosDAO mensajePagosDAO;
	
	public UsuarioView login (UsuarioView usuario) throws NoContentException {
		if (usuario.getIdUsuario() != null) {
			return usuarioDAO.getUsuarioById(usuario.getIdUsuario()).toView();
		}
		Usuario miUsuario;
		miUsuario = usuarioDAO.getUsuarioByMail(usuario.getMail());
		if (usuario.getContraseña().equals(miUsuario.getContraseña())) {
			return miUsuario.toView();
		}
		else {
			throw new NoContentException();
		}
	}
	
	public boolean verificarMail (String mail) throws NoContentException {
		return usuarioDAO.existeMail(mail);
	}
	
	public int addUsuario(UsuarioView usuario) {
		Direccion miDireccion = new Direccion(usuario.getDireccion().getCalle(), usuario.getDireccion().getAltura(), usuario.getDireccion().getTipoHogar(), usuario.getDireccion().getPiso(), usuario.getDireccion().getDepartamento(), usuario.getDireccion().getCiudad(), usuario.getDireccion().getProvincia());
		Usuario miUsuario = new Usuario(usuario.getMail(), usuario.getNombre(), usuario.getContraseña(), 1, usuario.getAvatar(), usuario.getDni(), miDireccion);
		return usuarioDAO.saveUsuario(miUsuario);
	}
	
	public List<String> getCategoriasRestaurantes() {
		List<String> categorias = new ArrayList<String>();
		List<Restaurante> misRestaurantes = restauranteDAO.getRestaurantes();
		
		for (Restaurante r: misRestaurantes) {
			if (!categorias.contains(r.getTipo())) {
				categorias.add(r.getTipo());
			}
		}
		return categorias;
	}

	public List<RestauranteView> getRestaurantes(FiltroVO filtros) {
		List<Restaurante> misRestaurantes = restauranteDAO.getRestaurantes();
		List<RestauranteView> resultado = new ArrayList<RestauranteView>();
		
		for (Restaurante r: misRestaurantes) {
			if (filtros.getCategoria() == null || filtros.getCategoria().equalsIgnoreCase("") || r.getTipo().equalsIgnoreCase(filtros.getCategoria())) {
				resultado.add(r.toViewSimple());
			}
		}
		return resultado;
	}
	
	public RestauranteView getRestaurante(Integer idRestaurante) throws NoContentException {
		return restauranteDAO.getRestauranteById(idRestaurante).toView();
	}

	public ProductoView getProducto(Integer idProducto) {
		return productoDAO.getProductoById(idProducto).toView();
	}
	
	public void actualizarUsuario(UsuarioView usuario) throws NoContentException {
		Usuario miUsuario = usuarioDAO.getUsuarioById(usuario.getIdUsuario());
		if (usuario.getNombre() != null) {
			miUsuario.setNombre(usuario.getNombre());
		}
		if (usuario.getAvatar() != null) {
			miUsuario.setAvatar(usuario.getAvatar());
		}
		if (usuario.getContraseña() != null) {
			miUsuario.setContraseña(usuario.getContraseña());
		}
		if (usuario.getDireccion() != null) {
			Direccion miDireccion = direccionDAO.getDireccionById(usuario.getDireccion().getIdDireccion());
			DireccionView dirNueva = usuario.getDireccion();
			if (dirNueva.getCalle() != null) {
				miDireccion.setCalle(dirNueva.getCalle());
			}
			if (dirNueva.getAltura() != null) {
				miDireccion.setAltura(dirNueva.getAltura());
			}
			if (dirNueva.getTipoHogar() != null) {
				miDireccion.setTipoHogar(dirNueva.getTipoHogar());
			}
			if (dirNueva.getPiso() != null) {
				miDireccion.setPiso(dirNueva.getPiso());
			}
			if (dirNueva.getDepartamento() != null) {
				miDireccion.setDepartamento(dirNueva.getDepartamento());
			}
			if (dirNueva.getCiudad() != null) {
				miDireccion.setCiudad(dirNueva.getCiudad());
			}
			if (dirNueva.getProvincia() != null) {
				miDireccion.setProvincia(dirNueva.getProvincia());
			}
			miUsuario.setDireccion(miDireccion);
		}
		usuarioDAO.saveUsuario(miUsuario);
		throw new NoContentException();
	}

	public OrdenVO addOrden(OrdenView orden) {
		Direccion miDireccion = direccionDAO.getDireccionById(orden.getIdDireccion());
		List<ProductosOrden> misProdsPedidos = new ArrayList<ProductosOrden>();
		
		for (ProductosOrdenView p: orden.getProductos()) {
			Producto miProducto = productoDAO.getProductoById(p.getIdProducto());
			misProdsPedidos.add(new ProductosOrden(miProducto, p.getCantidad()));
		}
		Orden miOrden = new Orden(miDireccion, misProdsPedidos);
		Orden ordenConId = ordenDAO.saveOrden(miOrden);
		
		List<ProductosOrdenVO> misProdsEnviar = new ArrayList<ProductosOrdenVO>();
		ProductosOrdenVO prod;
		for (ProductosOrden po: misProdsPedidos) {
			prod = new ProductosOrdenVO(1, po.getProducto().getMeal_id(), po.getCantidad(), po.getProducto().getNombre(), po.getProducto().getDescripcion(), po.getProducto().getPrecio(), po.getProducto().getFoto());
			for (Ingrediente i: po.getProducto().getIngredientes()) {
				prod.addIngrediente(new IngredienteProductoVO(i.getIngredient_id(), i.getCodigo_producto(), i.getDescripcion(), i.getCantidad(), i.getPrecio()));
			}
			misProdsEnviar.add(prod);
		}
		return new OrdenVO(ordenConId.getIdorden(), ordenConId.getDireccion().getIdDireccion(), orden.getPropina(), orden.getCosto_envio(), misProdsEnviar);
	}
	
	public void addMensajeFranquicia(MensajeFranquicia mensaje) {
		mensajeFranquiciaDAO.saveMensaje(mensaje);
	}

	public ConfirmacionFranquiciaView getConfirmacionFranquicia(Integer idorden) {
		MensajeFranquicia mensaje = mensajeFranquiciaDAO.getMensaje(idorden);
		return new ConfirmacionFranquiciaView(idorden, mensaje.getMensaje());
	}
	
	public MensajeFranquicia getMensajeFranquicia(Integer idorden) {
		return mensajeFranquiciaDAO.getMensajeInterno(idorden);
	}
	
	public void upsertRestaurant(Restaurante restaurante) {
		restauranteDAO.saveRestaurante(restaurante);
	}
	
	public Integer verificarRestaurante(Restaurante restaurante) {
		return restauranteDAO.verificarRestaurante(restaurante);
	}

	public Integer verificarProducto(Producto prod) {
		// TODO Auto-generated method stub
		return productoDAO.verificarProducto(prod);
	}

	public Integer verificarIngrediente(Ingrediente ing) {
		// TODO Auto-generated method stub
		return ingredienteDAO.verificarIngrediente(ing);
	}
	
	public List<Ingrediente> guardarIngredientes(List<Ingrediente> ingredientes) {
		return ingredienteDAO.saveIngredientes(ingredientes);
	}

	public MensajeRepartidor getMensajeRepartidor(Integer identificador) {
		return mensajeRepartidorDAO.getMensajeInterno(identificador);
	}

	public void addMensajeRepartidor(MensajeRepartidor mensaje) {
		mensajeRepartidorDAO.saveMensaje(mensaje);
	}

	public MensajeRepartidorView getDatosRepartidor(Integer idorden) {
		MensajeRepartidor mensaje = mensajeRepartidorDAO.getMensaje(idorden);
		if (mensaje.getStatus().equalsIgnoreCase("ENTREGADO")) {
			return mensaje.toViewEntregado();
		}
		else {
			return mensaje.toViewUbicacion();
		}
	}
	
	public void saveMensajePagos(MensajePagos mensaje) {
		mensajePagosDAO.saveMensaje(mensaje);
	}
	
	public MensajePagosView getMensajePagos() {
		return mensajePagosDAO.getMensaje().toView();
	}
	
}
