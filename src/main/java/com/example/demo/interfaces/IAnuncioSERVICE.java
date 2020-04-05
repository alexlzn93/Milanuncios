package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.model.Anuncio;


public interface IAnuncioSERVICE {

	public List<Anuncio> list_anuncios();
	public void add_anuncio(Anuncio anuncio);
	public Anuncio findByTitulo(String titulo);
	public List<Anuncio> findByUser(String user);
	public List<Anuncio> busca_Anuncios_por_PalabraClave(String palabra);
	public void eliminarAnuncio(int id_anuncio);
	public List<Anuncio> anuncios_byPrioridad(int prioridad);
	public List<Anuncio> findByPrecioBetween(int precio1, int precio2);
	
	
	
	public List<Anuncio> anuncios_by_categoria_precio(int id_categoria, double precio);
	public List<String> dame_descripcion(int id_categoria, double precio);
	public List<String> consulta_queryBeans(int id_categoria, double precio);
	
	
	public int numeroDeAnunciosByCategoria(int  id_categoria);
	
	
	
	
	
	
	

	
}
