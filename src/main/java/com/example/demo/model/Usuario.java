package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonManagedReference;

//si la clase (Usuarios) se llama igual que la tabla de la BBDD no hace falta la anotacion @Table
//si las variables de clase se llaman igual que las columnas de la tabla de la BBDD no hace falta anotacion @Column
//@Id es para decirle cual es la clave primaria (primary key) en la tabla de la bbdd

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	private String user;
	private String password;
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user", insertable = false, updatable = false)
	private List<Anuncio> anuncio;
	
	
	
	
	
	public List<Anuncio> getAnuncio() {
		return anuncio;
	}
	public void setAnuncio(List<Anuncio> anuncio) {
		this.anuncio = anuncio;
	}
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Usuario(String user, String password, String email) {
		super();
		this.user = user;
		this.password = password;
		this.email = email;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Usuario [user=" + user + ", password=" + password + ", email=" + email + "]";
	}

	

}
