package com.tenis.dao;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.tenis.bean.PortalBean;

public class MySqlPortalDAO implements PortalDAO{
	
	SqlSessionFactory sqlMapper = null;
	{
		String archivo = "ConfiguracionIbatis.xml";
		try {
			Reader reader = Resources.getResourceAsReader(archivo);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int eliminaPortal(int idPortal) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			salida = session.delete("SQL_eliminaPortal",idPortal);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			session.close();
		}
		return salida;
	}

	@Override
	public int insertaPortal(PortalBean obj) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			salida = session.insert("SQL_insertaPortal",obj);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			session.close();
		}
		return salida;
	}

	@Override
	public int actualizaPortal(PortalBean obj) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			salida = session.update("SQL_actualizaPortal",obj);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			session.close();
		}
		return salida;
	}

	@Override
	public List<PortalBean> consultaPortal(String filtro) throws Exception {
		SqlSession session = null;
		List<PortalBean> salida = null;
		try{
			session = sqlMapper.openSession();
			salida = session.selectList("SQL_listaPortal","%"+filtro+"%");
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return salida;
	}


}
