package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Anuncio;
@Repository
public interface IAnuncioRepository extends CrudRepository<Anuncio, Integer> {

	//EJEMPLOS DE QUERY METHODS
	Anuncio findByTituloIgnoreCase(String titulo);
	List<Anuncio> findByUserIgnoreCase(String user);
	List<Anuncio> findByPrecio(int precio);
	List<Anuncio> findByPrecioBetween(int precio1, int precio2); //lista de anuncios entre dos precios
	
	
	//CONSULTAS QUERY con QueryNativo que trabaja contra la tabla
	@Query(value="SELECT * FROM anuncios WHERE id_categoria= :id_categoria AND precio > :precio", nativeQuery=true) //SQL nativo nativeQuery=true
		public Optional<List<Anuncio>> anuncios_by_categoria_precio(@Param("id_categoria")int id_categoria,@Param("precio") double precio);

	@Query(value="SELECT titulo,descripcion FROM anuncios WHERE id_categoria= :id_categoria AND precio > :precio", nativeQuery=true) //SQL nativo nativeQuery=true
	public List<String> dame_descripcion(@Param("id_categoria")int id_categoria,@Param("precio") double precio);

	//CONSULTAS QUERY contra el Bean Anuncio HQL
	@Query("SELECT titulo,descripcion FROM Anuncio WHERE id_categoria= :id_categoria AND precio > :precio") 
	public List<String> consulta_con_bean(@Param("id_categoria")int id_categoria,@Param("precio") double precio);

	
}
