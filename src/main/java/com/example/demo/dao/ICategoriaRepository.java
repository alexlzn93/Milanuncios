package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Categoria;

public interface ICategoriaRepository extends CrudRepository<Categoria, Integer> {

	
}
