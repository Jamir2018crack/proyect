package com.tenis.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.tenis.bean.NoticiaBean;
import com.tenis.bean.NoticiaFilFecBean;
import com.tenis.service.NoticiaService;
import com.tenis.service.NoticiaServiceImpl;

@SuppressWarnings("serial")
@ParentPackage("dawi")
public class NoticiaAction extends ActionSupport {

	private static final Log log = LogFactory.getLog(NoticiaAction.class);

	//Para la consulta
	private List<NoticiaBean> noticias= new ArrayList<NoticiaBean>();
	private String filtro ="";
	
	//para el registrar y actualizar
	private String id;
	private String titulo;
	private String contenido;
	private File imagen;

	private Date fechaActual=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	private String fechaRegistro = sdf.format(fechaActual);
	
	private List<NoticiaBean> lstConsulta = new ArrayList<NoticiaBean>();
	private NoticiaFilFecBean filtroBean;
	
	@Action(value="/consultaXNoticiaFecha",
			results={@Result(name="success",location="/NoticiaXFecha.jsp")
	})
	public String consulta02(){
		NoticiaServiceImpl service = new NoticiaServiceImpl();
		try {
			lstConsulta = service.consultaNoticiaFecha(filtroBean);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return SUCCESS;
		
	}
	
	@Action(value="/eliminaNoticia",results={@Result(name="success", location="/crudNoticia.jsp")	})
	public String elimina(){
		log.info("En eliminar noticia");
		try {
			NoticiaService service = new NoticiaServiceImpl();
			service.eliminaNoticia(Integer.parseInt(id));
			noticias =  service.consultaNoticia(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return SUCCESS;
	}
	
	
	@Action(value="/actualizaNoticia",results={@Result(name="success", location="/crudNoticia.jsp")})
	public String actualiza(){
		log.info("En actualizar noticia");	
		try {
			NoticiaService service = new NoticiaServiceImpl();
			
			NoticiaBean obj = new NoticiaBean();
			obj.setIdNoticia(Integer.parseInt(id));
			obj.setTitulo(titulo);
			obj.setContenido(contenido);
			
			service.actualizaNoticia(obj);
			noticias =  service.consultaNoticia(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return SUCCESS;
	}
	

	@Action(value="/registraNoticia",results={@Result(name="success", location="/crudNoticia.jsp")})
	public String registra(){
		log.info("En registrar noticia");		
		
		try {
			NoticiaService service = new NoticiaServiceImpl();
			
			NoticiaBean obj = new NoticiaBean();
			obj.setTitulo(titulo);
			obj.setContenido(contenido);
			obj.setImagen(getBytesFromFile(imagen));
			obj.setFechaRegistro(fechaRegistro);
			
			service.insertaNoticia(obj);
			noticias =  service.consultaNoticia(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return SUCCESS;
	}
	
	@Action(value="/consultaNoticia",results={@Result(name="success", location="/crudNoticia.jsp")})
	public String listar(){
		log.info("En listar noticia");	
		NoticiaService service = new NoticiaServiceImpl();
		try {
			noticias =  service.consultaNoticia(filtro);
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


	public List<NoticiaBean> getNoticias() {
		return noticias;
	}


	public void setNoticias(List<NoticiaBean> noticias) {
		this.noticias = noticias;
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


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getContenido() {
		return contenido;
	}


	public void setContenido(String contenido) {
		this.contenido = contenido;
	}


	public static Log getLog() {
		return log;
	}


	public Date getFechaActual() {
		return fechaActual;
	}


	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}


	public SimpleDateFormat getSdf() {
		return sdf;
	}


	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}


	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public List<NoticiaBean> getLstConsulta() {
		return lstConsulta;
	}


	public void setLstConsulta(List<NoticiaBean> lstConsulta) {
		this.lstConsulta = lstConsulta;
	}


	public NoticiaFilFecBean getFiltroBean() {
		return filtroBean;
	}


	public void setFiltroBean(NoticiaFilFecBean filtroBean) {
		this.filtroBean = filtroBean;
	}
	
	public File getImagen() {
		return imagen;
	}

	public void setImagen(File imagen) {
		this.imagen = imagen;
	}




}
