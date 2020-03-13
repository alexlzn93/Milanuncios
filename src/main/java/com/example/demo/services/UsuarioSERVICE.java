package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IAnuncioRepository;
import com.example.demo.dao.IUsuarioRepository;

import com.example.demo.interfaces.IUsuarioSERVICE;
import com.example.demo.model.Anuncio;
import com.example.demo.model.Usuario;


@Service
public class UsuarioSERVICE implements IUsuarioSERVICE {

	@Autowired // le inyecto el DAO
	IUsuarioRepository usuariorepository;
	
	@Autowired // le inyecto el DAO
	IAnuncioRepository anunciorepository;
	

	@Override
	public List<Usuario> list_usuarios() {

		List<Usuario> lista = (List<Usuario>) usuariorepository.findAll();

		return lista;
	}

	@Override
	public void eliminar(String user) {
		usuariorepository.deleteById(user);

	}

	@Override
	public void alta_usuario(Usuario user) {
		try {
			usuariorepository.save(user);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public Usuario buscar_by_user(String user) {
		
		Usuario usuario = null;
		try {
			Optional<Usuario> aux = usuariorepository.findById(user);
			if (aux.isPresent()) {
				//.get ME DEVUELVE EL OBJETO
				usuario = aux.get();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return usuario;
	}

	@Override
	public List<Anuncio> list_anuncios_by_user(String user) {
	
		
		
		Optional<Usuario> usuario=null;
		usuario=usuariorepository.findById(user);
		List<Anuncio> list_anuncios_by_user=null;
		 
		if(usuario.isPresent()) {
			 list_anuncios_by_user= usuariorepository.findById(user).get().getAnuncio();
			
		}else {
			System.out.println("no existe");
			
		}
		return list_anuncios_by_user;
				
		
		
		
	}




	

}
