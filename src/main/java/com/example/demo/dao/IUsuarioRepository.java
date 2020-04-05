package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Usuario;

//DAO
//CrudRepository<Beans,tipo de dato del campo clave(user)>
@Repository
public interface IUsuarioRepository extends CrudRepository<Usuario, String> { 
																				 
}

