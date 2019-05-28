package com.tenis.bean;

public class HistorialCompraBean {
	private int idHistorial;
	private String FechaCompra;
	private FacturaBean Factura;
	
	
	public int getIdHistorial() {
		return idHistorial;
	}
	public void setIdHistorial(int idHistorial) {
		this.idHistorial = idHistorial;
	}
	public String getFechaCompra() {
		return FechaCompra;
	}
	public void setFechaCompra(String fechaCompra) {
		FechaCompra = fechaCompra;
	}
	public FacturaBean getFactura() {
		return Factura;
	}
	public void setFactura(FacturaBean factura) {
		Factura = factura;
	}
	
	
	
}
