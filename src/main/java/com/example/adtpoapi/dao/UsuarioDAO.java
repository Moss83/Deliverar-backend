package com.example.adtpoapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.adtpoapi.entities.UsuarioRepository;
import com.example.adtpoapi.exception.NoContentException;
import com.example.adtpoapi.model.Usuario;

@Service
public class UsuarioDAO {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario getUsuarioById(int idUsuario) throws NoContentException {
		return usuarioRepository.findById(idUsuario).orElseThrow(() -> new NoContentException());
	}
	
	public Usuario getUsuarioByMail(String mail) throws NoContentException {
		Example<Usuario> example = Example.of(new Usuario(mail));
		Optional<Usuario> actual = usuarioRepository.findOne(example);
		
		if (actual.isEmpty()) {
			throw new NoContentException();
		}
		else {
			return actual.get();
		}
	}
	
	public boolean existeMail(String mail) {
		Example<Usuario> example = Example.of(new Usuario(mail));
		return usuarioRepository.exists(example);
	}
	
	public int saveUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario).getIdUsuario();
	}
	
	public List<Usuario> getUsuarios() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}
}
