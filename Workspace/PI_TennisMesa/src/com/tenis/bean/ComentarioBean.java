package com.tenis.bean;

public class ComentarioBean {
	private int idComentario;
	private String Descripcion;
	private String FechaRegistro;
	private UsuarioBean Usuario;
	private NoticiaBean Noticia;
	
	public int getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getFechaRegistro() {
		return FechaRegistro;
	}
	public void setFechaRegistro(String fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}
	public UsuarioBean getUsuario() {
		return Usuario;
	}
	public void setUsuario(UsuarioBean usuario) {
		Usuario = usuario;
	}
	public NoticiaBean getNoticia() {
		return Noticia;
	}
	public void setNoticia(NoticiaBean noticia) {
		Noticia = noticia;
	}
	

	
}
