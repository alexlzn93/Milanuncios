package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICategoriaRepository;
import com.example.demo.interfaces.ICategoriaSERVICE;
import com.example.demo.model.Anuncio;
import com.example.demo.model.Categoria;


@Service
public class CategoriaSERVICE implements ICategoriaSERVICE {

	//inyeccion del repositorio CrudRepositry
	@Autowired
	ICategoriaRepository categoriarepository;
	
	@Override
	public List<Categoria> list_categorias() {
		// TODO Auto-generated method stub
		return (List<Categoria>) categoriarepository.findAll();
	}



	@Override
	public void añadir_categoria(Categoria categoria) {
		// TODO Auto-generated method stub
		categoriarepository.save(categoria);
	}



	@Override
	public List<Anuncio> lista_anuncios_por_categoria(int id_categoria) {
		List<Anuncio> lista_anuncio_by_categoria= categoriarepository.findById(id_categoria).get().getAnuncio();
		return lista_anuncio_by_categoria;
	}

}
