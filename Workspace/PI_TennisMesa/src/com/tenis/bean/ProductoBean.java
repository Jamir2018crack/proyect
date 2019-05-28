package com.tenis.bean;

public class ProductoBean {
	private int idProducto;
	private String Nombre;
	private String Descripcion;
	private double Precio;
	private int Stock;
	private byte[] Imagen;
	private CategoriaBean Categoria;
	
	
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public double getPrecio() {
		return Precio;
	}
	public void setPrecio(double precio) {
		Precio = precio;
	}
	public int getStock() {
		return Stock;
	}
	public void setStock(int stock) {
		Stock = stock;
	}
	
	public byte[] getImagen() {
		return Imagen;
	}
	public void setImagen(byte[] imagen) {
		Imagen = imagen;
	}
	public CategoriaBean getCategoria() {
		return Categoria;
	}
	public void setCategoria(CategoriaBean categoria) {
		Categoria = categoria;
	}
	

	
}
