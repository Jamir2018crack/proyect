package com.tenis.bean;

public class PortalBean {
	private int idPortal;
	private String Titulo;
	private String Subtitulo;
	private String Url;
	private String FecRegistro;
	
	
	
	public int getIdPortal() {
		return idPortal;
	}
	public void setIdPortal(int idPortal) {
		this.idPortal = idPortal;
	}
	
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getSubtitulo() {
		return Subtitulo;
	}
	public void setSubtitulo(String subtitulo) {
		Subtitulo = subtitulo;
	}
	public String getFecRegistro() {
		return FecRegistro;
	}
	public void setFecRegistro(String fecRegistro) {
		FecRegistro = fecRegistro;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	
	
}
