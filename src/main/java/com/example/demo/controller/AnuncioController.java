package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.interfaces.IAnuncioSERVICE;
import com.example.demo.interfaces.ICategoriaSERVICE;
import com.example.demo.interfaces.IUsuarioSERVICE;
import com.example.demo.model.Anuncio;

@Controller
@RequestMapping("/anuncios")
public class AnuncioController {
		
		@Autowired
		IAnuncioSERVICE anuncioservice;
		@Autowired
		IUsuarioSERVICE usuarioservice;
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

		@RequestMapping("/mis_anuncios")
		public String mis_anuncios() {
			return "mis_anuncios";
		}
		@RequestMapping("/ver_mis_anuncios")
		public String ver_mi_anuncios(@RequestParam("user") String user, Model model) {
			
			String letraMay= user.substring(0, 1).toUpperCase();
			String letrasMinu= user.substring(1);
			String nombre=letraMay+letrasMinu;
			
			List<Anuncio> lista_anuncio_by_user = usuarioservice.list_anuncios_by_user(nombre);
			
			if(lista_anuncio_by_user==null) {
				
				String mensaje="No se ha encontrado ningun anuncio para: " + nombre;
				model.addAttribute("mensaje", mensaje);
				return "mis_anuncios";
			
			}else {
				model.addAttribute("listado_anuncios", lista_anuncio_by_user);
			
			}
				return "lista_anuncio_usuario";
		}

		@RequestMapping("/ver_anuncio")
		public String ver_anuncio() {
			return "ver_anuncio";
		}
		
		@RequestMapping("/ver_anuncio_completo")
		public String ver_titulo(@RequestParam("titulo") String titulo, Model model) {
			
			Anuncio anuncio = anuncioservice.findByTitulo(titulo);
		
			if (anuncio == null) {
				model.addAttribute("anuncio", "No se ha encontrado ningun articulo");
			} else {
				model.addAttribute("anuncio", anuncio.getTitulo() + " " + anuncio.getUser()
				+ " " + anuncio.getDescripcion());
			}
			return "ver_anuncio";

		}
		
		@RequestMapping("/busqueda_anuncio")
		public String busca_palabra_clave(@RequestParam String palabra,Model model) {
			
			List<Anuncio> anuncios_palabraClave= anuncioservice.busca_Anuncios_por_PalabraClave(palabra);
			System.out.println(palabra);
			System.out.println("------------");
			if(anuncios_palabraClave.size()==0) {
				model.addAttribute("mensaje", "No se a encontrado ningun anuncio que contenga la palabra " + palabra);
				return "error";
			}else{
				model.addAttribute("lista_anuncios", anuncios_palabraClave);
			}
			
			return "buscarAnuncioPalabraClave";
		}
		
		@RequestMapping("/totalAnunciosByCategoria")
		public String anunciosByCategoriaTotal() {
			return "numeroAnunciosDeCategoria";
		}
		
		
		@RequestMapping ("/anunciosTotales_deCategoria")
		public String numeroAnunciosDeCategoria(@RequestParam int id_categoria, Model model) {
			
			int totalAnuncios=anuncioservice.numeroDeAnunciosByCategoria(id_categoria);
			List<Anuncio> anunciosbyCategoria= categoriaservice.lista_anuncios_por_categoria(id_categoria);
			
			System.out.println(id_categoria);
			if(totalAnuncios==0) {
				model.addAttribute("mensaje", " Hay 0 anuncios publicados de esta categoria");
				return "error";
			}else {
				model.addAttribute("numero", " Anuncios encontrados: "+ totalAnuncios);
				model.addAttribute("id", id_categoria);
				model.addAttribute("anuncios", anunciosbyCategoria);
			}
			
			return "numeroAnunciosDeCategoria";
		}
		
		@RequestMapping("/eliminarAnuncio")
		public String eliminarAnuncio(Model model,@RequestParam int id_anuncio,@RequestParam(name="user",required=false) String user) {
			
			anuncioservice.eliminarAnuncio(id_anuncio);
			List<Anuncio> lista_anuncio_by_user = usuarioservice.list_anuncios_by_user(user);
			if(lista_anuncio_by_user.size()==0) {
				model.addAttribute("mensaje", "Todos tu anuncios han sido eliminados");
				return "lista_anuncio_usuario";
			}
				
				model.addAttribute("listado_anuncios", lista_anuncio_by_user);
				return "lista_anuncio_usuario";
			
		}
		
		@RequestMapping("/anunciosPrioridad")
		public String anuncios_byPrioridad() {
			return "anunciosPrioridad";
		}
		
		@RequestMapping("/anunciosByprioridad")
		public String anunciosByprioridad(Model model, @RequestParam("prioridad") int prioridad){
			List<Anuncio> lista_prioridad= anuncioservice.anuncios_byPrioridad(prioridad);
			model.addAttribute("lista_anuncio_prioridad", lista_prioridad);
			
			return  "anunciosPrioridad";
		}

}
