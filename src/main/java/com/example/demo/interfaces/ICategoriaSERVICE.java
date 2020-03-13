package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.model.Anuncio;
import com.example.demo.model.Categoria;



public interface ICategoriaSERVICE {

	public List<Categoria> list_categorias();
	
	public void añadir_categoria(Categoria categoria);
	public List<Anuncio> lista_anuncios_por_categoria(int id_categoria);
	
}
