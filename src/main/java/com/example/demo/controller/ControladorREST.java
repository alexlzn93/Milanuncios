package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.interfaces.IAnuncioSERVICE;
import com.example.demo.interfaces.ICategoriaSERVICE;
import com.example.demo.interfaces.IUsuarioSERVICE;
import com.example.demo.model.Anuncio;
import com.example.demo.model.Categoria;
import com.example.demo.model.Usuario;
import com.example.demo.util.Response;

@RestController
@RequestMapping(value="/rest")
public class ControladorREST {

	@Autowired
	IAnuncioSERVICE anuncioservice;
	@Autowired
	ICategoriaSERVICE categoriaservice;
	@Autowired
	IUsuarioSERVICE usuarioservice;
	
	@GetMapping("/añadir_anuncio/{user}/{id_categoria}/{titulo}/{descripcion}")
	public Response lista_ventas_porFecha(@PathVariable("user") String user,@PathVariable("id_categoria") int id_categoria,@PathVariable("titulo") String titulo,
			@PathVariable("descripcion") String descripcion) {
		Response response = new Response("anuncio publicado",0);
		Anuncio anuncio= new Anuncio(user, id_categoria, titulo, descripcion, 1000, 1);
		
		anuncioservice.add_anuncio(anuncio);
	
		return response;
	
	}
	@GetMapping("/veranuncios")
	public List<Anuncio> listaTotalAnuncios(){
		return anuncioservice.list_anuncios();
	}
	@RequestMapping("/listaCategorias")
	public List<Categoria> listacategorias(){
		List<Categoria> listaCategorias= categoriaservice.list_categorias();
		
		return listaCategorias;
	}
	@RequestMapping("/listaUsuarios")
	public List<Usuario> lista_usuarios(){
		List<Usuario> lista_user= usuarioservice.list_usuarios();
		
		return lista_user;
	}
}
