package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IAnuncioRepository;
import com.example.demo.interfaces.IAnuncioSERVICE;
import com.example.demo.model.Anuncio;

@Service
public class AnuncioSERVICE implements IAnuncioSERVICE {

	@Autowired
	IAnuncioRepository anunciorepository;
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Anuncio> list_anuncios() {
		// TODO Auto-generated method stub
		return (List<Anuncio>) anunciorepository.findAll();
	}

	@Override
	public void add_anuncio(Anuncio anuncio) {
		// TODO Auto-generated method stub
		anunciorepository.save(anuncio);
	}

	
	
	@Override
	public Anuncio buscar_por_user(String user) {
		
		 return anunciorepository.findByUserIgnoreCase(user);
	}



	@Override
	public Anuncio buscar_por_titulo(String titulo) {
		
		 return anunciorepository.findByTituloIgnoreCase(titulo);
	}

	@Override
	public List<Anuncio> anuncios_by_categoria_precio(int id_categoria, double precio) {
		
		return anunciorepository.anuncios_by_categoria_precio(id_categoria, precio).get() ;
	}

	@Override
	public List<String> dame_descripcion(int id_categoria, double precio) {
		
		return anunciorepository.dame_descripcion(id_categoria, precio);
	}

	@Override
	public List<String> consulta_queryBeans(int id_categoria, double precio) {
		// TODO Auto-generated method stub
		return anunciorepository.consulta_con_bean(id_categoria, precio);
	}

	@Override
	public int numeroDeAnunciosByCategoria(int id_categoria) {
		
		String consulta= "FROM Anuncio WHERE id_categoria= :id_categoria";
		//Me devuelve el numero de anuncios totales que tiene esa categoria
		int totalAnunciosDeCategoria=entityManager.createQuery(consulta).setParameter("id_categoria", id_categoria).getResultList().size();
		return totalAnunciosDeCategoria;
	}

	@Override
	public List<Anuncio> busca_Anuncios_por_PalabraClave(String palabra) {
		String consulta= "FROM Anuncio  WHERE titulo LIKE CONCAT ('%' , :cadena, '%') OR descripcion LIKE CONCAT ('%' , :cadena, '%')";
		System.out.println(palabra);
		List<Anuncio> anuncios_palabraClave = entityManager.createQuery(consulta).setParameter("cadena", palabra).getResultList();
		if(anuncios_palabraClave.size()==0) {
			System.out.println("No se ha encontrado ningun anuncio");
		}else {
			return anuncios_palabraClave;
		}
		return anuncios_palabraClave;
	}

	@Override
	public void eliminarAnuncio(int id_anuncio) {
		anunciorepository.deleteById(id_anuncio);
		
	}

	@Override
	public List<Anuncio> anuncios_byPrioridad(int prioridad) {
		String consulta= "FROM Anuncio WHERE prioridad= :prioridad";
		List<Anuncio> anuncios_byprioridad= entityManager.createQuery(consulta).setParameter("prioridad", prioridad).getResultList();
		
		return anuncios_byprioridad;
	}

	

	

	

	
	

	

	


	
	



	

	

	
	

}
