package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.interfaces.IAnuncioSERVICE;
import com.example.demo.interfaces.ICategoriaSERVICE;
import com.example.demo.interfaces.IUsuarioSERVICE;
import com.example.demo.model.Anuncio;
import com.example.demo.model.Categoria;
import com.example.demo.model.Usuario;

@Controller
@RequestMapping("/app")
public class HomeController { //mapeo de la pagina principal

	@Autowired
	IAnuncioSERVICE anuncioservice;
	@Autowired
	ICategoriaSERVICE categoriaservice;
	@Autowired
	IUsuarioSERVICE usuarioservice;
	

	// PAGINA PRINCIPAL
	@RequestMapping("/index")
	public String paginaPrincipal( Model model) {
		List<Anuncio> listaAnuncios = anuncioservice.list_anuncios();
		model.addAttribute("anuncios", listaAnuncios);
		return "index";
	}

	

	@GetMapping("/lista_categoria")
	public String list_categoria(Model model) {

		List<Categoria> categoria = categoriaservice.list_categorias();
		

		model.addAttribute("categorias", categoria);
		// JSP
		return "lista_categoria";
	}

	@RequestMapping("/lista_anuncios_por_categoria")//
	public String list_anuncios_by_categoria(@RequestParam int id_categoria, Model model) {

		List<Anuncio> lista_anuncio_por_categoria = categoriaservice.lista_anuncios_por_categoria(id_categoria);

		model.addAttribute("anuncios", lista_anuncio_por_categoria);
		// JSP

		return "lista_anuncio_categoria";
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
	public ModelAndView ver_titulo(HttpServletRequest request) {
		String titulo = request.getParameter("titulo");
		Anuncio anuncio = anuncioservice.buscar_por_titulo(titulo);
		ModelAndView mav = new ModelAndView();
		if (anuncio == null) {
			mav.addObject("anuncio", "No se ha encontrado ningun articulo");
		} else {
			mav.addObject("anuncio", anuncio.toString());
		}

		mav.setViewName("ver_anuncio");

		return mav;

	}
			
		


	//EJEMPLOS DE CONSULTAS QUERY
	@RequestMapping("/ver_anuncios_porConsulta")
	public String consulta_anuncios() {
		List<Anuncio> consulta= anuncioservice.anuncios_by_categoria_precio(1, 100);
		for (Anuncio anuncio : consulta) {
			System.out.println(anuncio);
		}
		return "anuncio_usuario";
	}
	@RequestMapping("/consulta_descripcion")
	public String consulta_descripcion() {
		List<String> consulta= anuncioservice.dame_descripcion(1, 2000);
			for (String anuncio : consulta) {
			System.out.println(anuncio);
		}
		return "anuncio_usuario";
	}
	@RequestMapping("/consulta_query_bean")
	public String consulta_query_bean() {
		List<String> consulta= anuncioservice.consulta_queryBeans(1, 200);
			for (String anuncio : consulta) {
			System.out.println(anuncio);
		}
		return "anuncio_usuario";
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
		
		System.out.println(id_categoria);
		if(totalAnuncios==0) {
			model.addAttribute("mensaje", " Hay 0 anuncios publicados de esta categoria");
			return "error";
		}else {
			model.addAttribute("numero", " Anuncios encontrados: "+ totalAnuncios);
		
			
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
