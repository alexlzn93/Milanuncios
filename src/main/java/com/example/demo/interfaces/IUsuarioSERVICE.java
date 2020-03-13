package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.model.Anuncio;
import com.example.demo.model.Usuario;


public interface IUsuarioSERVICE {

	public List<Usuario> list_usuarios();

	public void eliminar(String user);

	public void alta_usuario(Usuario user);

	public Usuario buscar_by_user(String user);
	
	
	
	public List<Anuncio> list_anuncios_by_user(String user);

}
