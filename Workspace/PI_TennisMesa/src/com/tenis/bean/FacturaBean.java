package com.tenis.bean;

public class FacturaBean {
	private int idFactura;
	private String FechaRegistro;
	private EstadoFacturaBean Estado;
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
	public EstadoFacturaBean getEstado() {
		return Estado;
	}
	public void setEstado(EstadoFacturaBean estado) {
		Estado = estado;
	}
	public UsuarioBean getUsuario() {
		return Usuario;
	}
	public void setUsuario(UsuarioBean usuario) {
		Usuario = usuario;
	}
	
	
	
	
	
	
}
