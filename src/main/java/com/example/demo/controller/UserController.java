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
	@PostMapping("/add_usuario")
	public String añadir_usuario(HttpServletRequest request, Model model,@ModelAttribute Usuario usuario) {

		userservice.alta_usuario(usuario);
		
		return "redirect:/app";
	}
	

	@GetMapping("/logueate")
	public String logueate() {
		return "login";
		
	}
	@PostMapping("/usuarioLogueado")
	public String usuario_logueado(@RequestParam("user") String user,@RequestParam("password")
	String password, Model model) {
		
		//Usuario usuario=userservice.buscar_by_user(user);
		System.out.println(user + " " + password);
		Usuario usuario= userservice.findByUserAndPassword(user, password);
		String letraMayusculaNombre= user.substring(0, 1).toUpperCase();//primera letra mayuscula
		String letrasMinusculasNombre=user.substring(1);
		String nombre=letraMayusculaNombre+letrasMinusculasNombre;
		
		if(usuario==null) {
			model.addAttribute("mensajeError", "Introduzca sus datos correctamente");
			return "login";
		}else {
			model.addAttribute("mensajeBienvenido", "Bienvenido de nuevo " + nombre);
		}
		return "logueate";
	}
}
