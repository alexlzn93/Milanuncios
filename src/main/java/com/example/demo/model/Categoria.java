package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "categorias")
public class Categoria {

	@Id
	@Column(name = "id_categoria")
	private int id_categoria;
	@Column(name = "descripcion")
	private String descripcion;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_categoria",insertable=false,updatable=false)
	
	private List<Anuncio> anuncio;
	

	public List<Anuncio> getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(List<Anuncio> anuncio) {
		this.anuncio = anuncio;
	}

	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categoria(int id_categoria, String descripcion) {
		super();
		this.id_categoria = id_categoria;
		this.descripcion = descripcion;
	}

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Categoria [id_categoria=" + id_categoria + ", descripcion=" + descripcion + "]";
	}

}
