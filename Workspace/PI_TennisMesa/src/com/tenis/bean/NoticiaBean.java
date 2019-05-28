package com.tenis.bean;

public class NoticiaBean {
	private int idNoticia;
	private String Titulo;
	private String Contenido;
	private byte[] Imagen;
	private String FechaRegistro;
	
	
	public int getIdNoticia() {
		return idNoticia;
	}
	public void setIdNoticia(int idNoticia) {
		this.idNoticia = idNoticia;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getContenido() {
		return Contenido;
	}
	public void setContenido(String contenido) {
		Contenido = contenido;
	}
	
	public byte[] getImagen() {
		return Imagen;
	}
	public void setImagen(byte[] imagen) {
		Imagen = imagen;
	}
	public String getFechaRegistro() {
		return FechaRegistro;
	}
	public void setFechaRegistro(String fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}
	
	
	
}
