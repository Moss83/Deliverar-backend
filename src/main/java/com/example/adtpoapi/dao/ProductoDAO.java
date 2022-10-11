package com.example.adtpoapi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.adtpoapi.entities.ProductoRepository;

@Service
public class ProductoDAO {

	@Autowired
	private ProductoRepository productoRepository;
	
}
