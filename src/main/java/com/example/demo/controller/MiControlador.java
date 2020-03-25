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
public class MiControlador {

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
		//System.out.println(listaAnuncios.toString());

		model.addAttribute("anuncios", listaAnuncios);
		
		return "index";
	}

	// METODO PARA PINTAR EL JSP nuevo_anuncio
	@RequestMapping("/publicar_anuncio")
	public String add_anuncio() {
		//iria a alta_user.jsp
		return "nuevo_anuncio"; // 
	}

	// METODO QUE RECOJE LOS PARAMETROS PARA AGREGAR UN NUEVO ANUNCIO A LA PAGINA WEB
	
	/*@RequestMapping("/añadir_anuncio")
	public String añadir_anuncio(HttpServletRequest request, Model model) {

		String user = request.getParameter("user");
		int id_categoria = Integer.parseInt(request.getParameter("id_categoria"));
		String titulo = request.getParameter("titulo");
		String descripcion = request.getParameter("descripcion");
		double precio = Double.parseDouble(request.getParameter("precio"));
		int prioridad = Integer.parseInt(request.getParameter("prioridad"));
		String fecha = request.getParameter("fecha").toLowerCase();

		Anuncio anuncio = new Anuncio(user, id_categoria, titulo, descripcion, precio, prioridad, fecha);
		anuncioservice.add_anuncio(anuncio);
		model.addAttribute("anuncios", anuncioservice.list_anuncios());

		System.out.println(user + id_categoria + titulo + descripcion + precio + fecha);

		//IRIA A LA PAGINA DE INICIO DONDE SE LISTAN TODOS LOS ANUNCIOS
		return "index";
	}*/
	@RequestMapping("/añadir_anuncio")
	public String añadir_anuncio(Anuncio anuncio, Model model) {
		//Ejemplo de DataBinding
		//en el formulario los name mapean directamente con los atributos de la clase Anuncio, por eso el metodo
		//recibe un Anuncio anuncio en vez de recoger los name con @RequestParam y crear un Anuncio
		anuncioservice.add_anuncio(anuncio);
		model.addAttribute("anuncios", anuncioservice.list_anuncios());

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
	// OTRA MANERA DE RECOJER LOS PARAMETROS Y MANDARSELOS AL JSP CON MODEL
	@GetMapping("/alta_user")
	public String alta_user(@ModelAttribute Usuario usuario) {
		return "alta_user";
	}
	

	@RequestMapping("/add_usuario")
	public String añadir_usuario(HttpServletRequest request, Model model,@ModelAttribute Usuario usuario) {

		// RECOJO LOS PARAMETROS PARA ENVIARLOS AL JSP CON REQUEST
		String user = request.getParameter("user").toLowerCase();
		String password = request.getParameter("password");
		String email = request.getParameter("email").toLowerCase();
System.out.println(usuario);
		 
		Usuario user1=usuarioservice.buscar_by_user(user);
		
		String letraMayusculaNombre= user.substring(0, 1).toUpperCase();//primera letra mayuscula
		String letrasMinusculasNombre=user.substring(1);
		String nombre=letraMayusculaNombre+letrasMinusculasNombre;
		
		// SI EL USUARIO NO EXISTE LLAMO AL SERVICE Y LE DOY DE ALTA

		if (user1 == null) {
			usuarioservice.alta_usuario(usuario);
			System.out.println(usuario);
			model.addAttribute("mensaje", "Alta realizada correctamente");
			model.addAttribute("bienvenido", "Sube tu anuncio y vendelo " + nombre + " !");
			model.addAttribute("user", nombre);
			
			return "nuevo_anuncio";
			// Y SI EXISTE
		} else {
			model.addAttribute("usuario", new Usuario(user, password, email));
			model.addAttribute("password", password);
			model.addAttribute("email", email);
			model.addAttribute("mensaje", "Este usuario ya esta registrado");
		
			return "alta_user";
		}
		
		


	}
	

	@RequestMapping("/usuario_registrado")
	public String usuario_registrado() {
		return "usuario_registrado";
	}

	@GetMapping("/usario_existe")
	public String usuario_existe(@RequestParam("user") String user, Model model) {
		
		Usuario usuario=usuarioservice.buscar_by_user(user);
		String letraMayusculaNombre= user.substring(0, 1).toUpperCase();//primera letra mayuscula
		String letrasMinusculasNombre=user.substring(1);
		String nombre=letraMayusculaNombre+letrasMinusculasNombre;
		if(usuario==null) {
			model.addAttribute("mensajeError", "No existe el usuario introducido");
			return "usuario_registrado";
		}else {
		model.addAttribute("user", nombre);
		model.addAttribute("bienvenido", "Publica otro anuncio " + nombre);
		}

		return "nuevo_anuncio";

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

	@GetMapping("/logueate")
	public String logueate() {
		return "login";
		
	}
	@PostMapping("/usuarioLogueado")
	public String usuario_logueado(@RequestParam("user") String user, Model model) {
		
		Usuario usuario=usuarioservice.buscar_by_user(user);
		String letraMayusculaNombre= user.substring(0, 1).toUpperCase();//primera letra mayuscula
		String letrasMinusculasNombre=user.substring(1);
		String nombre=letraMayusculaNombre+letrasMinusculasNombre;
		
		if(usuario==null) {
			model.addAttribute("mensajeAltaUser", "No existe el usuario introducido, registrate!!");
			return "alta_user";
		}else {
			model.addAttribute("mensajeBienvenido", "Bienvenido de nuevo " + nombre);
		}
		
		
		return "logueate";
	}
	
	
	
	
	
	

	

}
