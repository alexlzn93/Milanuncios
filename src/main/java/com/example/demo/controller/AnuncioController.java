package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.interfaces.IAnuncioSERVICE;
import com.example.demo.interfaces.ICategoriaSERVICE;
import com.example.demo.model.Anuncio;

@Controller
@RequestMapping("/anuncios")
public class AnuncioController {
		
		@Autowired
		IAnuncioSERVICE anuncioservice;
		@Autowired
		ICategoriaSERVICE categoriaservice;
	
		// METODO PARA PINTAR EL JSP nuevo_anuncio
		@RequestMapping("/publicar_anuncio")
		public String add_anuncio(@ModelAttribute Anuncio anuncio) { //@ModelAttribute Anuncio anuncio
			//System.out.println("llega?");
			//SOLUCIONAR EL DATA BINDING DEL CHECKBOX CATEGORIAS
			return "nuevo_anuncio";  
		}
		
		@PostMapping("/añadir_anuncio")
		public String añadir_anuncio(@ModelAttribute Anuncio anuncio, Model model) {
			//Ejemplo de DataBinding
			//en el formulario los name mapean directamente con los atributos de la clase Anuncio, por eso el metodo
			//recibe un Anuncio anuncio en vez de recoger los name con @RequestParam y crear un Anuncio
			System.out.println(anuncio.toString());
			anuncioservice.add_anuncio(anuncio);
			System.out.println(anuncio.toString());
			//model.addAttribute("categorias",categoriaservice.list_categorias());->cuando id_categoria sea String
			model.addAttribute("anuncios", anuncioservice.list_anuncios());

			return "redirect:/app/index";
		}
}
