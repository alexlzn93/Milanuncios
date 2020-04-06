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
	@RequestMapping
	public String paginaPrincipal( Model model) {
		List<Anuncio> listaAnuncios = anuncioservice.list_anuncios();
		model.addAttribute("anuncios", listaAnuncios);
		return "index";
	}

	

	

	}
