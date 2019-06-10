package com.tenis.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.tenis.bean.PortalBean;
import com.tenis.service.PortalService;
import com.tenis.service.PortalServiceImpl;

@SuppressWarnings("serial")
@ParentPackage("dawi")
public class PortalAction extends ActionSupport {

	private static final Log log = LogFactory.getLog(PortalAction.class);

	//Para la consulta
	private List<PortalBean> portales= new ArrayList<PortalBean>();
	private String filtro ="";
	
	//para el registrar y actualizar
	private String id;
	private String nombre;
	private String url;

	
	private List<PortalBean> lstConsulta = new ArrayList<PortalBean>();

	
	@Action(value="/eliminaPortal",results={@Result(name="success", location="/crudPortal.jsp")	})
	public String elimina(){
		log.info("En eliminar portal");
		try {
			PortalService service = new PortalServiceImpl();
			service.eliminaPortal(Integer.parseInt(id));
			portales =  service.consultaPortal(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return SUCCESS;
	}
	
	
	@Action(value="/actualizaPortal",results={@Result(name="success", location="/crudPortal.jsp")})
	public String actualiza(){
		log.info("En actualizar portal");	
		try {
			PortalService service = new PortalServiceImpl();
			
			PortalBean obj = new PortalBean();
			obj.setIdPortal(Integer.parseInt(id));
			obj.setNombre(nombre);
			obj.setUrl(url);
			
			service.actualizaPortal(obj);
			portales =  service.consultaPortal(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return SUCCESS;
	}
	

	@Action(value="/registraPortal",results={@Result(name="success", location="/crudPortal.jsp")})
	public String registra(){
		log.info("En registrar portal");		
		
		try {
			PortalService service = new PortalServiceImpl();
			
			PortalBean obj = new PortalBean();
			obj.setNombre(nombre);
			obj.setUrl(url);
			
			service.insertaPortal(obj);
			portales =  service.consultaPortal(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return SUCCESS;
	}
	
	@Action(value="/consultaPortal",results={@Result(name="success", location="/crudPortal.jsp")})
	public String listar(){
		log.info("En listar portal");	
		
		PortalService service = new PortalServiceImpl();
		try {
			portales =  service.consultaPortal(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public static byte[] getBytesFromFile(File file) throws IOException {
		if (file != null) {
			InputStream is = new FileInputStream(file);

			byte[] bytes = new byte[(int) file.length()];

			int offset = 0;
			int numRead = 0;
			while (offset < bytes.length
					&& (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
				offset += numRead;
			}

			is.close();
			return bytes;
		} else {
			return null;
		}
	}

	public static File getFileFromBytes(byte[] fileBytes, String archivoDestino) {
		File f2 = null;
		try {
			f2 = new File(archivoDestino);
			OutputStream out = new FileOutputStream(f2);
			out.write(fileBytes);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f2;

	}



	public String getFiltro() {
		return filtro;
	}


	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}




	public static Log getLog() {
		return log;
	}


	public List<PortalBean> getPortales() {
		return portales;
	}


	public void setPortales(List<PortalBean> portales) {
		this.portales = portales;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public List<PortalBean> getLstConsulta() {
		return lstConsulta;
	}


	public void setLstConsulta(List<PortalBean> lstConsulta) {
		this.lstConsulta = lstConsulta;
	}


	




}
