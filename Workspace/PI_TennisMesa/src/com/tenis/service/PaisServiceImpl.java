package com.tenis.service;
import java.util.List;

import com.tenis.bean.PaisBean;
import com.tenis.dao.MySqlPaisDAO;

public class PaisServiceImpl implements PaisService {
	
	MySqlPaisDAO dao = new MySqlPaisDAO();

	@Override
	public int eliminaPais(int idPais) throws Exception {
		return dao.eliminaPais(idPais);
	}

	@Override
	public int insertaPais(PaisBean obj) throws Exception {
		return dao.insertaPais(obj);
	}

	@Override
	public int actualizaPais(PaisBean obj) throws Exception {
		return dao.actualizaPais(obj);
	}

	@Override
	public List<PaisBean> consultaPais(String filtro) throws Exception {
		return dao.consultaPais(filtro);
	}



}
