package com.tenis.service;
import java.util.List;

import com.tenis.bean.CategoriaBean;
import com.tenis.dao.MySqlCategoriaDAO;

public class CategoriaServiceImpl implements CategoriaService {
	
	MySqlCategoriaDAO dao = new MySqlCategoriaDAO();


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
