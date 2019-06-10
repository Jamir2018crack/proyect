package com.tenis.service;
import java.util.List;

import com.tenis.bean.PortalBean;
import com.tenis.dao.MySqlPortalDAO;

public class PortalServiceImpl implements PortalService {
	
	MySqlPortalDAO dao = new MySqlPortalDAO();

	@Override
	public int eliminaPortal(int idPortal) throws Exception {
		return dao.eliminaPortal(idPortal);
	}

	@Override
	public int insertaPortal(PortalBean obj) throws Exception {
		return dao.insertaPortal(obj);
	}

	@Override
	public int actualizaPortal(PortalBean obj) throws Exception {
		return dao.actualizaPortal(obj);
	}

	@Override
	public List<PortalBean> consultaPortal(String filtro) throws Exception {
		return dao.consultaPortal(filtro);	
	}



}
