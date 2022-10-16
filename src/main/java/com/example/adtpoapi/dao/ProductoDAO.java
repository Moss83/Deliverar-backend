package com.example.adtpoapi.dao;

import org.springframework.beans.factory.annotation.Autowired;
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
	
}
