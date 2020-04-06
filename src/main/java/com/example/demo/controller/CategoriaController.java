package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.interfaces.ICategoriaSERVICE;
import com.example.demo.model.Anuncio;
import com.example.demo.model.Categoria;
@Controller
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	ICategoriaSERVICE categoriaservice;
	
	@GetMapping("/lista_categoria")
	public String list_categoria(Model model) {

		List<Categoria> categoria = categoriaservice.list_categorias();
		model.addAttribute("categorias", categoria);
	
		return "lista_categoria";
	}

	@RequestMapping("/lista_anuncios_por_categoria")//
	public String list_anuncios_by_categoria(@RequestParam int id_categoria, Model model) {

		List<Anuncio> lista_anuncio_por_categoria = categoriaservice.lista_anuncios_por_categoria(id_categoria);

		model.addAttribute("anuncios", lista_anuncio_por_categoria);
		return "lista_anuncio_categoria";
	}
	
	@RequestMapping("/nuevaCategoria")
	public String nueva_categoria() {
		return "añadir_categoria";
	}
	
	@PostMapping("/añadirCategoria")
	public String añadir_categoria(Model model, @RequestParam("id") int id_categoria,@RequestParam("descripcion") String descripcion ) {
		
		Categoria categorianueva= new Categoria(id_categoria, descripcion);
		categoriaservice.añadir_categoria(categorianueva);
		model.addAttribute("categoriaNueva", "Categoria añadida correctamente: " + categorianueva.getDescripcion());
		
		return "añadir_categoria";
		
	}

}
