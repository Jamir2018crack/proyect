package com.tenis.service;
import java.util.List;

import com.tenis.bean.CategoriaBean;
public interface CategoriaService {
	
	public abstract int eliminaCategoria(int idCategoria) throws Exception;
	public abstract int insertaCategoria(CategoriaBean obj) throws Exception;
	public abstract int actualizaCategoria(CategoriaBean obj) throws Exception;
	public abstract List<CategoriaBean> consultaCategoria(String filtro) throws Exception;

}
