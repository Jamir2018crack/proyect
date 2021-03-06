package com.tenis.dao;
import java.util.List;

import com.tenis.bean.NoticiaBean;
import com.tenis.bean.NoticiaFilFecBean;
public interface NoticiaDAO {
	public abstract int eliminaNoticia(int idNoticia) throws Exception;
	public abstract int insertaNoticia(NoticiaBean obj) throws Exception;
	public abstract int actualizaNoticia(NoticiaBean obj) throws Exception;
	public abstract List<NoticiaBean> consultaNoticia(String filtro) throws Exception;
	
	public List<NoticiaBean> consultaNoticiaFecha(NoticiaFilFecBean filtro) throws Exception;

}
