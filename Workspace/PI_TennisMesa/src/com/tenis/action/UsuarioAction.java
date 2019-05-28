package com.tenis.action;

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
import com.tenis.bean.PaisBean;
import com.tenis.bean.UsuarioBean;
import com.tenis.service.UsuarioService;
import com.tenis.service.UsuarioServiceImpl;

@SuppressWarnings("serial")
@ParentPackage("dawi")
public class UsuarioAction extends ActionSupport {

	private static final Log log = LogFactory.getLog(UsuarioAction.class);

	//Para la consulta
	private List<UsuarioBean> usuarios= new ArrayList<UsuarioBean>();
	private List<PaisBean> lstPais;
	private String filtro ="";
	
	//para el registrar y actualizar
	private String id;
	private String nombre;
	private String apellido;
	
	private Date fechaActual=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	private String fechaRegistro = sdf.format(fechaActual);
	
	private String correo;
	private String contrasenia;
	private String ciudad;
	private String direccion;
	private String telefono;
	private String nombrePai;
	private PaisBean pais;

	@Action(value="/eliminaUsuario",results={@Result(name="success", location="/crudUsuario.jsp")	})
	public String elimina(){
		log.info("En eliminar usuario");
		try {
			UsuarioService service = new UsuarioServiceImpl();
			service.eliminaUsuario(Integer.parseInt(id));
			usuarios =  service.consultaUsuario(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return SUCCESS;
	}
	
	
	@Action(value="/actualizaUsuario",results={@Result(name="success", location="/crudUsuario.jsp")})
	public String actualiza(){
		log.info("En actualizar usuario");	
		try {
			UsuarioService service = new UsuarioServiceImpl();
			
			UsuarioBean obj = new UsuarioBean();
			obj.setIdUsuario(Integer.parseInt(id));
			obj.setNombre(nombre);
			obj.setApellido(apellido);
			obj.setFechaRegistro(fechaRegistro);
			obj.setCorreo(correo);
			obj.setContrasenia(contrasenia);
			obj.setCiudad(ciudad);
			obj.setDireccion(direccion);
			obj.setTelefono(telefono);
			obj.setPais(pais);;
			
			service.actualizaUsuario(obj);
			usuarios =  service.consultaUsuario(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return SUCCESS;
	}
	

	@Action(value="/registraUsuario",results={@Result(name="success", location="/crudUsuario.jsp")})
	public String registra(){
		log.info("En registrar usuario");		
		
		try {
			UsuarioService service = new UsuarioServiceImpl();
			
			UsuarioBean obj = new UsuarioBean();
			obj.setNombre(nombre);
			obj.setApellido(apellido);
			obj.setFechaRegistro(fechaRegistro);
			obj.setCorreo(correo);
			obj.setContrasenia(contrasenia);
			obj.setCiudad(ciudad);
			obj.setDireccion(direccion);
			obj.setTelefono(telefono);
			obj.setPais(pais);
			
			service.insertaUsuario(obj);
			usuarios =  service.consultaUsuario(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return SUCCESS;
	}
	
	@Action(value="/consultaUsuario",results={@Result(name="success", location="/crudUsuario.jsp")})
	public String listar(){
		log.info("En listar usuario");	
		UsuarioService service = new UsuarioServiceImpl();
		try {
			usuarios =  service.consultaUsuario(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	@Action(value="/cargaPais" ,results={@Result(name="success",type="json")})
	public String cargaPais(){
		try {
			UsuarioService service = new UsuarioServiceImpl();
			
			lstPais = service.consultaPais(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}


	public List<UsuarioBean> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<UsuarioBean> usuarios) {
		this.usuarios = usuarios;
	}


	public List<PaisBean> getLstPais() {
		return lstPais;
	}


	public void setLstPais(List<PaisBean> lstPais) {
		this.lstPais = lstPais;
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


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
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


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getContrasenia() {
		return contrasenia;
	}


	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getNombrePai() {
		return nombrePai;
	}


	public void setNombrePai(String nombrePai) {
		this.nombrePai = nombrePai;
	}


	public PaisBean getPais() {
		return pais;
	}


	public void setPais(PaisBean pais) {
		this.pais = pais;
	}


	public static Log getLog() {
		return log;
	}




}
