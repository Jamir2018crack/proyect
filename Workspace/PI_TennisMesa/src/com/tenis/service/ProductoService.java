package com.tenis.service;
import java.util.List;

import com.tenis.bean.CategoriaBean;
import com.tenis.bean.ProductoBean;
public interface ProductoService {
	public abstract int eliminaProducto(int idProducto) throws Exception;
	public abstract int insertaProducto(ProductoBean obj) throws Exception;
	public abstract int actualizaProducto(ProductoBean obj) throws Exception;
	public abstract List<ProductoBean> consultaProducto(String filtro) throws Exception;
	
	public abstract int eliminaCategoria(int idCategoria) throws Exception;
	public abstract int insertaCategoria(CategoriaBean obj) throws Exception;
	public abstract int actualizaCategoria(CategoriaBean obj) throws Exception;
	public abstract List<CategoriaBean> consultaCategoria(String filtro) throws Exception;

}
