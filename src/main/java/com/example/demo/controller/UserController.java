package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.interfaces.IUsuarioSERVICE;
import com.example.demo.model.Usuario;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	IUsuarioSERVICE userservice;

	
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
		 
		Usuario user1=userservice.buscar_by_user(user);
		
		String letraMayusculaNombre= user.substring(0, 1).toUpperCase();//primera letra mayuscula
		String letrasMinusculasNombre=user.substring(1);
		String nombre=letraMayusculaNombre+letrasMinusculasNombre;
		
		// SI EL USUARIO NO EXISTE LLAMO AL SERVICE Y LE DOY DE ALTA

		if (user1 == null) {
			userservice.alta_usuario(usuario);
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
	

	@GetMapping("/logueate")
	public String logueate() {
		return "login";
		
	}
	@PostMapping("/usuarioLogueado")
	public String usuario_logueado(@RequestParam("user") String user, Model model) {
		
		Usuario usuario=userservice.buscar_by_user(user);
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
