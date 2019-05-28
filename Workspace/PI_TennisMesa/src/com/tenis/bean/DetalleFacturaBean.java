package com.tenis.bean;

public class DetalleFacturaBean {
	private int Cantidad;
	private FacturaBean Factura;
	private ProductoBean Producto;
	
	public int getCantidad() {
		return Cantidad;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	public FacturaBean getFactura() {
		return Factura;
	}
	public void setFactura(FacturaBean factura) {
		Factura = factura;
	}
	public ProductoBean getProducto() {
		return Producto;
	}
	public void setProducto(ProductoBean producto) {
		Producto = producto;
	}
	
	
	
}
