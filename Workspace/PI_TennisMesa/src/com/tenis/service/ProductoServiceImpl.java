package com.tenis.service;
import java.util.List;

import com.tenis.bean.CategoriaBean;
import com.tenis.bean.ProductoBean;
import com.tenis.dao.MySqlProductoDAO;

public class ProductoServiceImpl implements ProductoService {
	
	MySqlProductoDAO dao = new MySqlProductoDAO();


	@Override
	public int eliminaProducto(int idProducto) throws Exception {
		return dao.eliminaProducto(idProducto);
	}

	@Override
	public int insertaProducto(ProductoBean obj) throws Exception {
		return  dao.insertaProducto(obj);
	}

	@Override
	public int actualizaProducto(ProductoBean obj) throws Exception {
		return dao.actualizaProducto(obj);
	}

	@Override
	public List<ProductoBean> consultaProducto(String filtro) throws Exception {
		return dao.consultaProducto(filtro);
	}

	@Override
	public int eliminaCategoria(int idCategoria) throws Exception {
		return dao.eliminaCategoria(idCategoria);
	}

	@Override
	public int insertaCategoria(CategoriaBean obj) throws Exception {
		return dao.insertaCategoria(obj);
	}

	@Override
	public int actualizaCategoria(CategoriaBean obj) throws Exception {
		return dao.actualizaCategoria(obj);
	}

	@Override
	public List<CategoriaBean> consultaCategoria(String filtro) throws Exception {
		return dao.consultaCategoria(filtro);
	}



}
