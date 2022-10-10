package com.example.adtpoapi.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.adtpoapi.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
