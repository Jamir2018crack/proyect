package com.tenis.service;
import java.util.List;

import com.tenis.bean.NoticiaBean;
import com.tenis.bean.NoticiaFilFecBean;
import com.tenis.dao.MySqlNoticiaDAO;

public class NoticiaServiceImpl implements NoticiaService {
	
	MySqlNoticiaDAO dao = new MySqlNoticiaDAO();

	@Override
	public int eliminaNoticia(int idNoticia) throws Exception {
		return dao.eliminaNoticia(idNoticia);
	}

	@Override
	public int insertaNoticia(NoticiaBean obj) throws Exception {
		return dao.insertaNoticia(obj);
	}

	@Override
	public int actualizaNoticia(NoticiaBean obj) throws Exception {
		return dao.actualizaNoticia(obj);
	}

	@Override
	public List<NoticiaBean> consultaNoticia(String filtro) throws Exception {
		return dao.consultaNoticia(filtro);	
	}

	@Override
	public List<NoticiaBean> consultaNoticiaFecha(NoticiaFilFecBean filtro) throws Exception {
		return dao.consultaNoticiaFecha(filtro);
	}



}
