package com.tenis.dao;
import java.util.List;

import com.tenis.bean.PaisBean;
import com.tenis.bean.UsuarioBean;
public interface UsuarioDAO {
	public abstract int eliminaUsuario(int idUsuario) throws Exception;
	public abstract int insertaUsuario(UsuarioBean obj) throws Exception;
	public abstract int actualizaUsuario(UsuarioBean obj) throws Exception;
	public abstract List<UsuarioBean> consultaUsuario(String filtro) throws Exception;
	
	public abstract List<PaisBean> consultaPais(String filtro) throws Exception;
	
	

}
