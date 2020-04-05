package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Categoria;
@Repository
public interface ICategoriaRepository extends CrudRepository<Categoria, Integer> {

	
}
