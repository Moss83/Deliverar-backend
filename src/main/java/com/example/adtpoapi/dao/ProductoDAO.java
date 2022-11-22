package com.example.adtpoapi.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.adtpoapi.entities.ProductoRepository;
import com.example.adtpoapi.exception.NoContentException;
import com.example.adtpoapi.model.Producto;

@Service
public class ProductoDAO {

	@Autowired
	private ProductoRepository productoRepository;
	
	public Producto getProductoById(Integer idProducto) throws NoContentException {
		return productoRepository.findById(idProducto).orElseThrow(() -> new NoContentException());
	}

	public Integer verificarProducto(Producto prod) {
		// TODO Auto-generated method stub
		Example<Producto> example = Example.of(new Producto(prod.getMeal_id()));
		Optional<Producto> actual = productoRepository.findOne(example);
		
		if (actual.isEmpty()) {
			return 0;
		}
		else {
			return actual.get().getIdProducto();
		}
	}
	
}
