package com.tenis.dao;
import java.util.List;

import com.tenis.bean.PortalBean;
public interface PortalDAO {
	public abstract int eliminaPortal(int idPortal) throws Exception;
	public abstract int insertaPortal(PortalBean obj) throws Exception;
	public abstract int actualizaPortal(PortalBean obj) throws Exception;
	public abstract List<PortalBean> consultaPortal(String filtro) throws Exception;
	

}
