package com.tenis.service;
import java.util.List;

import com.tenis.bean.PaisBean;
public interface PaisService {
	
	public abstract int eliminaPais(int idPais) throws Exception;
	public abstract int insertaPais(PaisBean obj) throws Exception;
	public abstract int actualizaPais(PaisBean obj) throws Exception;
	public abstract List<PaisBean> consultaPais(String filtro) throws Exception;

}
