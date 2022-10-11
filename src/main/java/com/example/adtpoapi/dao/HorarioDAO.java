package com.example.adtpoapi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.adtpoapi.entities.HorarioRepository;

@Service
public class HorarioDAO {

	@Autowired
	private HorarioRepository horarioRepository;
}
