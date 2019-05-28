package com.tenis.service;
import java.util.List;

import com.tenis.bean.PaisBean;
import com.tenis.bean.UsuarioBean;
import com.tenis.dao.MySqlUsuarioDAO;

public class UsuarioServiceImpl implements UsuarioService {
	
	MySqlUsuarioDAO dao = new MySqlUsuarioDAO();

	@Override
	public int eliminaUsuario(int idUsuario) throws Exception {
		return dao.eliminaUsuario(idUsuario);
	}

	@Override
	public int insertaUsuario(UsuarioBean obj) throws Exception {
		return dao.insertaUsuario(obj);
	}

	@Override
	public int actualizaUsuario(UsuarioBean obj) throws Exception {
		return dao.actualizaUsuario(obj);
	}

	@Override
	public List<UsuarioBean> consultaUsuario(String filtro) throws Exception {
		return dao.consultaUsuario(filtro);
	}

	@Override
	public List<PaisBean> consultaPais(String filtro) throws Exception {
		return dao.consultaPais(filtro);
	}



}
