package com.tenis.dao;
import java.util.List;

import com.tenis.bean.FacturaBean;
import com.tenis.bean.PedidoFilFecBean;
public interface PedidoDAO {
	public abstract int eliminaPedido(int idPedido) throws Exception;
	public abstract int insertaPedido(FacturaBean obj) throws Exception;
	public abstract int actualizaPedido(FacturaBean obj) throws Exception;
	public abstract List<FacturaBean> consultaPedido(String filtro) throws Exception;
	
	public List<FacturaBean> consultaPedidoFecha(PedidoFilFecBean filtro) throws Exception;

}
