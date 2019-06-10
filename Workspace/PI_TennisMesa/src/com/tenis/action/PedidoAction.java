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
import com.tenis.bean.EstadoFacturaBean;
import com.tenis.bean.FacturaBean;
import com.tenis.bean.PedidoFilFecBean;
import com.tenis.bean.UsuarioBean;
import com.tenis.service.PedidoService;
import com.tenis.service.PedidoServiceImpl;

@SuppressWarnings("serial")
@ParentPackage("dawi")
public class PedidoAction extends ActionSupport {

	private static final Log log = LogFactory.getLog(PedidoAction.class);

	//Para la consulta
	private List<FacturaBean> pedidos= new ArrayList<FacturaBean>();
	private String filtro ="";
	
	//para el registrar y actualizar
	private String id;
	private Date fechaActual=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	private String fechaRegistro = sdf.format(fechaActual);
	private EstadoFacturaBean estado;
	private UsuarioBean usuario;
	
	private List<FacturaBean> lstConsulta = new ArrayList<FacturaBean>();
	private PedidoFilFecBean filtroBean;
	
	@Action(value="/consultaXPedidoFecha",
			results={@Result(name="success",location="/PedidoXFecha.jsp")
	})
	public String consulta02(){
		PedidoServiceImpl service = new PedidoServiceImpl();
		try {
			lstConsulta = service.consultaPedidoFecha(filtroBean);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return SUCCESS;
		
	}
	
	@Action(value="/eliminaPedido",results={@Result(name="success", location="/crudPedido.jsp")	})
	public String elimina(){
		log.info("En eliminar pedido");
		try {
			PedidoService service = new PedidoServiceImpl();
			service.eliminaPedido(Integer.parseInt(id));
			pedidos =  service.consultaPedido(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return SUCCESS;
	}
	
	
	@Action(value="/actualizaPedido",results={@Result(name="success", location="/crudPedido.jsp")})
	public String actualiza(){
		log.info("En actualizar pedido");	
		try {
			PedidoService service = new PedidoServiceImpl();
			
			FacturaBean obj = new FacturaBean();
			obj.setIdFactura(Integer.parseInt(id));
			obj.setEstado(estado);
			
			
			service.actualizaPedido(obj);
			pedidos =  service.consultaPedido(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return SUCCESS;
	}
	

	@Action(value="/registraPedido",results={@Result(name="success", location="/crudPedido.jsp")})
	public String registra(){
		log.info("En registrar pedido");		
		
		try {
			PedidoService service = new PedidoServiceImpl();
			
			FacturaBean obj = new FacturaBean();
			obj.setFechaRegistro(fechaRegistro);
			obj.setEstado(estado);
			obj.setUsuario(usuario);
			
			
			
			service.insertaPedido(obj);
			pedidos =  service.consultaPedido(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return SUCCESS;
	}
	
	@Action(value="/consultaPedido",results={@Result(name="success", location="/crudPedido.jsp")})
	public String listar(){
		log.info("En listar pedido");	
		PedidoService service = new PedidoServiceImpl();
		try {
			pedidos =  service.consultaPedido(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	


	



}
