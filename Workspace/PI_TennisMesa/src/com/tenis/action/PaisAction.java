package com.tenis.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.tenis.bean.PaisBean;
import com.tenis.service.PaisService;
import com.tenis.service.PaisServiceImpl;

@SuppressWarnings("serial")
@ParentPackage("dawi")
public class PaisAction extends ActionSupport {

	private static final Log log = LogFactory.getLog(PaisAction.class);

	//Para la consulta
	private List<PaisBean> paises= new ArrayList<PaisBean>();
	private String filtro ="";
	
	//para el registrar y actualizar
	private String id;
	private String nombre;
	
	@Action(value="/eliminaPais",results={@Result(name="success", location="/crudPais.jsp")	})
	public String elimina(){
		log.info("En eliminar pais");
		try {
			PaisService service = new PaisServiceImpl();
			service.eliminaPais(Integer.parseInt(id));
			paises =  service.consultaPais(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return SUCCESS;
	}
	
	
	@Action(value="/actualizaPais",results={@Result(name="success", location="/crudPais.jsp")})
	public String actualiza(){
		log.info("En actualizar pais");	
		try {
			PaisService service = new PaisServiceImpl();
			
			PaisBean obj = new PaisBean();
			obj.setIdPais(Integer.parseInt(id));
			obj.setNombre(nombre);
			
			service.actualizaPais(obj);
			paises =  service.consultaPais(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return SUCCESS;
	}

	
	
	@Action(value="/registraPais",results={@Result(name="success", location="/crudPais.jsp")})
	public String registra(){
		log.info("En registrar pais");		
		
		try {
			PaisService service = new PaisServiceImpl();
			
			PaisBean obj = new PaisBean();
			obj.setNombre(nombre);
			
			service.insertaPais(obj);
			paises =  service.consultaPais(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return SUCCESS;
	}
	
	@Action(value="/consultaPais",results={@Result(name="success", location="/crudPais.jsp")})
	public String listar(){
		log.info("En listar pais");	
		PaisService service = new PaisServiceImpl();
		try {
			paises =  service.consultaPais(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}


	public List<PaisBean> getPaises() {
		return paises;
	}


	public void setPaises(List<PaisBean> paises) {
		this.paises = paises;
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


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public static Log getLog() {
		return log;
	}
	
	
	
	
}


