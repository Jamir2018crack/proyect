package com.tenis.service;
import java.util.List;

import com.tenis.bean.FacturaBean;
import com.tenis.bean.PedidoFilFecBean;
import com.tenis.dao.MySqlPedidoDAO;

public class PedidoServiceImpl implements PedidoService {
	
	MySqlPedidoDAO dao = new MySqlPedidoDAO();

	@Override
	public int eliminaPedido(int idPedido) throws Exception {
		return dao.eliminaPedido(idPedido);
	}

	@Override
	public int insertaPedido(FacturaBean obj) throws Exception {
		return dao.insertaPedido(obj);
	}

	@Override
	public int actualizaPedido(FacturaBean obj) throws Exception {
		return dao.actualizaPedido(obj);
	}

	@Override
	public List<FacturaBean> consultaPedido(String filtro) throws Exception {
		return dao.consultaPedido(filtro);
	}

	@Override
	public List<FacturaBean> consultaPedidoFecha(PedidoFilFecBean filtro) throws Exception {
		return dao.consultaPedidoFecha(filtro);
	}



}
