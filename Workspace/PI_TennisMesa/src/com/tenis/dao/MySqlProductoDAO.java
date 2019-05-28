package com.tenis.dao;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.tenis.bean.CategoriaBean;
import com.tenis.bean.ProductoBean;

public class MySqlProductoDAO implements ProductoDAO{
	
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
	public int eliminaProducto(int idProducto) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			salida = session.delete("SQL_eliminaProducto",idProducto);
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
	public int insertaProducto(ProductoBean obj) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			salida = session.insert("SQL_insertaProducto",obj);
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
	public int actualizaProducto(ProductoBean obj) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			salida = session.update("SQL_actualizaProducto",obj);
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
	public List<ProductoBean> consultaProducto(String filtro) throws Exception {
		SqlSession session = null;
		List<ProductoBean> salida = null;
		try{
			session = sqlMapper.openSession();
			salida = session.selectList("SQL_listaProducto","%"+filtro+"%");
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return salida;
	}

	@Override
	public int eliminaCategoria(int idCategoria) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			salida = session.delete("SQL_eliminaProducto",idCategoria);
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
	public int insertaCategoria(CategoriaBean obj) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			salida = session.insert("SQL_insertaCategoria",obj);
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
	public int actualizaCategoria(CategoriaBean obj) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			salida = session.update("SQL_actualizaCategoria",obj);
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
	public List<CategoriaBean> consultaCategoria(String filtro) throws Exception {
		SqlSession session = null;
		List<CategoriaBean> salida = null;
		try{
			session = sqlMapper.openSession();
			salida = session.selectList("SQL_listaCategoria","%"+filtro+"%");
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return salida;
	}


}
