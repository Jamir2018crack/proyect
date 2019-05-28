package com.tenis.bean;

public class FacturaBean {
	private int idFactura;
	private String FechaRegistro;
	private String Estado;
	private UsuarioBean Usuario;
	
	public int getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	public String getFechaRegistro() {
		return FechaRegistro;
	}
	public void setFechaRegistro(String fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public UsuarioBean getUsuario() {
		return Usuario;
	}
	public void setUsuario(UsuarioBean usuario) {
		Usuario = usuario;
	}
	
	
	
}
