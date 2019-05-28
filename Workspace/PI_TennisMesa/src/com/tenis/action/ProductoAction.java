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
import com.tenis.bean.ProductoBean;
import com.tenis.service.ProductoService;
import com.tenis.service.ProductoServiceImpl;

@SuppressWarnings("serial")
@ParentPackage("dawi")
public class ProductoAction extends ActionSupport {

	private static final Log log = LogFactory.getLog(ProductoAction.class);

	//Para la consulta
	private List<ProductoBean> productos= new ArrayList<ProductoBean>();
	private List<CategoriaBean> lstCategoria;
	private String filtro ="";
	
	//para el registrar y actualizar
	private String id;
	private String nombre;
	private String nombreCat;
	private String descripcion;
	private double precio;
	private int stock;
	private File imagen;
	private CategoriaBean categoria;

	@Action(value="/eliminaProducto",results={@Result(name="success", location="/crudProducto.jsp")	})
	public String elimina(){
		log.info("En eliminar producto");
		try {
			ProductoService service = new ProductoServiceImpl();
			service.eliminaProducto(Integer.parseInt(id));
			productos =  service.consultaProducto(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return SUCCESS;
	}
	
	
	@Action(value="/actualizaProducto",results={@Result(name="success", location="/crudProducto.jsp")})
	public String actualiza(){
		log.info("En actualizar producto");	
		try {
			ProductoService service = new ProductoServiceImpl();
			
			ProductoBean obj = new ProductoBean();
			obj.setIdProducto(Integer.parseInt(id));
			obj.setNombre(nombre);
			obj.setDescripcion(descripcion);
			obj.setPrecio(precio);
			obj.setStock(stock);
			//obj.setImagen(imagen);
			obj.setCategoria(categoria);
			
			service.actualizaProducto(obj);
			productos =  service.consultaProducto(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return SUCCESS;
	}
	

	@Action(value="/registraProductos",results={@Result(name="success", location="/crudProducto.jsp")})
	public String registra(){
		log.info("En registrar producto");		
		
		try {
			ProductoService service = new ProductoServiceImpl();
			
			ProductoBean obj = new ProductoBean();
			obj.setNombre(nombre);
			obj.setDescripcion(descripcion);
			obj.setPrecio(precio);
			obj.setStock(stock);
			obj.setImagen(getBytesFromFile(imagen));
			obj.setCategoria(categoria);
			
			service.insertaProducto(obj);
			productos =  service.consultaProducto(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return SUCCESS;
	}
	
	@Action(value="/consultaProducto",results={@Result(name="success", location="/crudProducto.jsp")})
	public String listar(){
		log.info("En listar producto");	
		ProductoService service = new ProductoServiceImpl();
		try {
			productos =  service.consultaProducto(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	@Action(value="/registraCate",results={@Result(name="success", location="/crudProducto.jsp")})
	public String registraCate(){
		log.info("En registrar categoria");		
		
		try {
			ProductoService service = new ProductoServiceImpl();
			
			CategoriaBean obj = new CategoriaBean();
			obj.setNombre(nombreCat);
			
			service.insertaCategoria(obj);
			productos =  service.consultaProducto(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return SUCCESS;
	}
	
	@Action(value="/cargaCategoria" ,results={@Result(name="success",type="json")})
	public String cargaProducto(){
		try {
			ProductoService service = new ProductoServiceImpl();
			
			lstCategoria = service.consultaCategoria(filtro);
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


	public List<ProductoBean> getProductos() {
		return productos;
	}


	public void setProductos(List<ProductoBean> productos) {
		this.productos = productos;
	}


	public List<CategoriaBean> getLstCategoria() {
		return lstCategoria;
	}


	public void setLstCategoria(List<CategoriaBean> lstCategoria) {
		this.lstCategoria = lstCategoria;
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


	public String getNombreCat() {
		return nombreCat;
	}


	public void setNombreCat(String nombreCat) {
		this.nombreCat = nombreCat;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public File getImagen() {
		return imagen;
	}


	public void setImagen(File imagen) {
		this.imagen = imagen;
	}


	public CategoriaBean getCategoria() {
		return categoria;
	}


	public void setCategoria(CategoriaBean categoria) {
		this.categoria = categoria;
	}


	public static Log getLog() {
		return log;
	}




}
