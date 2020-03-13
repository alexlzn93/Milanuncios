package com.example.demo.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "anuncios")
public class Anuncio {

	
	// @GeneratedValue para obligar a que el campo sea autoincremental
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_anuncio;
	private String user;
	private int id_categoria;
	private String titulo;
	private String descripcion;
	private double precio;
	private int prioridad;
	private String fecha;
	
	

	public Anuncio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Anuncio(int id_anuncio, String user, int id_categoria, String titulo, String descripcion, double precio,
			int prioridad, String fecha) {
		super();
		this.id_anuncio = id_anuncio;
		this.user = user;
		this.id_categoria = id_categoria;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.prioridad = prioridad;
		this.fecha = fecha;
	}

	public Anuncio(String user, int id_categoria, String titulo, String descripcion, double precio, int prioridad,
			String fecha) {
		super();
		this.user = user;
		this.id_categoria = id_categoria;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.prioridad = prioridad;
		this.fecha = fecha;
	}
	



	public Anuncio(String user, int id_categoria, String titulo, String descripcion, double precio, int prioridad) {
		super();
		this.user = user;
		this.id_categoria = id_categoria;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.prioridad = prioridad;
	}

	public int getId_anuncio() {
		return id_anuncio;
	}

	public void setId_anuncio(int id_anuncio) {
		this.id_anuncio = id_anuncio;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Anuncio [id_anuncio=" + id_anuncio + ", user=" + user + ", id_categoria=" + id_categoria + ", titulo="
				+ titulo + ", descripcion=" + descripcion + ", precio=" + precio + ", prioridad=" + prioridad
				+ ", fecha=" + fecha + "]";
	}

}
