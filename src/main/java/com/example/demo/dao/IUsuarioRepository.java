package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Usuario;

//DAO
//CrudRepository<Beans,tipo de dato del campo clave(user)>
public interface IUsuarioRepository extends CrudRepository<Usuario, String> { 
																				 
}

