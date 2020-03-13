package com.example.demo.util;

public class Response {

	private String mensaje;
	private int codigo_retorno;
	
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Response(String mensaje, int codigo_retorno) {
		super();
		this.mensaje = mensaje;
		this.codigo_retorno = codigo_retorno;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public int getCodigo_retorno() {
		return codigo_retorno;
	}

	public void setCodigo_retorno(int codigo_retorno) {
		this.codigo_retorno = codigo_retorno;
	}

	@Override
	public String toString() {
		return "Response [mensaje=" + mensaje + ", codigo_retorno=" + codigo_retorno + "]";
	}
	
	
}
