package com.tenis.dao;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.tenis.bean.FacturaBean;
import com.tenis.bean.PedidoFilFecBean;

public class MySqlPedidoDAO implements PedidoDAO{
	
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
	public int eliminaPedido(int idPedido) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			salida = session.delete("SQL_eliminaFactura",idPedido);
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
	public int insertaPedido(FacturaBean obj) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			salida = session.insert("SQL_insertaFactura",obj);
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
	public int actualizaPedido(FacturaBean obj) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			salida = session.update("SQL_actualizaFactura",obj);
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
	public List<FacturaBean> consultaPedido(String filtro) throws Exception {
		SqlSession session = null;
		List<FacturaBean> salida = null;
		try{
			session = sqlMapper.openSession();
			salida = session.selectList("SQL_listaFactura","%"+filtro+"%");
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return salida;
	}

	@Override
	public List<FacturaBean> consultaPedidoFecha(PedidoFilFecBean filtro) throws Exception {
		List<FacturaBean> salida =  new ArrayList<FacturaBean>();
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			salida = session.selectList("SQL_consultaFacturaFecha",filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			session.close();
		}
		return salida;
	}


}
