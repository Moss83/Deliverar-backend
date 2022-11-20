package com.example.adtpoapi.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.adtpoapi.model.Orden;

public interface OrdenRepository extends JpaRepository<Orden, Integer> {

}
