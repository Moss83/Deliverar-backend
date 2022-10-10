package com.example.adtpoapi.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.adtpoapi.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
