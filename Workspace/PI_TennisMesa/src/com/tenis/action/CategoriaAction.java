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
import com.tenis.bean.CategoriaBean;
import com.tenis.service.CategoriaService;
import com.tenis.service.CategoriaServiceImpl;

@SuppressWarnings("serial")
@ParentPackage("dawi")
public class CategoriaAction extends ActionSupport {

	private static final Log log = LogFactory.getLog(CategoriaAction.class);

	//Para la consulta
	private List<CategoriaBean> categorias= new ArrayList<CategoriaBean>();
	private String filtro ="";
	
	//para el registrar y actualizar
	private String id;
	private String nombre;
	
	@Action(value="/eliminaCategoria",results={@Result(name="success", location="/crudCategoria.jsp")	})
	public String elimina(){
		log.info("En eliminar categoria");
		try {
			CategoriaService service = new CategoriaServiceImpl();
			service.eliminaCategoria(Integer.parseInt(id));
			categorias =  service.consultaCategoria(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return SUCCESS;
	}
	
	
	@Action(value="/actualizaCategoria",results={@Result(name="success", location="/crudCategoria.jsp")})
	public String actualiza(){
		log.info("En actualizar categoria");	
		try {
			CategoriaService service = new CategoriaServiceImpl();
			
			CategoriaBean obj = new CategoriaBean();
			obj.setIdCategoria(Integer.parseInt(id));
			obj.setNombre(nombre);
			
			service.actualizaCategoria(obj);
			categorias =  service.consultaCategoria(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return SUCCESS;
	}

	
	
	@Action(value="/registraCategoria",results={@Result(name="success", location="/crudCategoria.jsp")})
	public String registraCate(){
		log.info("En registrar categoria");		
		
		try {
			CategoriaService service = new CategoriaServiceImpl();
			
			CategoriaBean obj = new CategoriaBean();
			obj.setNombre(nombre);
			
			service.insertaCategoria(obj);
			categorias =  service.consultaCategoria(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return SUCCESS;
	}
	
	@Action(value="/consultaCategoria",results={@Result(name="success", location="/crudCategoria.jsp")})
	public String listar(){
		log.info("En listar categoria");	
		CategoriaService service = new CategoriaServiceImpl();
		try {
			categorias =  service.consultaCategoria(filtro);
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


	public List<CategoriaBean> getCategorias() {
		return categorias;
	}


	public void setCategorias(List<CategoriaBean> categorias) {
		this.categorias = categorias;
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


