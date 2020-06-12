package com.example.controller;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.dao.DaoCliente;
import com.example.dao.DaoOrden;
import com.example.dao.DaoProducto;
import com.example.dao.DetalleOrdenDao;
import com.example.dao.EmpleadoDao;
import com.example.modelo.Cliente;
import com.example.modelo.DetalleOrden;
import com.example.modelo.Empleado;
import com.example.modelo.Orden;
import com.example.modelo.Producto;
import com.example.persistence.ICliente;

import ch.qos.logback.classic.Logger;

@Controller
public class controlador  implements  ErrorController {
	
	 
	public static  Logger log=   (Logger) LoggerFactory.getLogger(controlador.class);
 

	@Autowired
	private DaoCliente clientedao;
	
	@Autowired
	private EmpleadoDao empleadoDao; 
	
	@Autowired
	private DaoProducto productoDao;
	
	@Autowired
	private  DaoOrden  ordenDao;
	
	@Autowired
	private  DetalleOrdenDao  detalleOrdenDao;
	
	private static int numero=1; 
	
	
	@GetMapping({"/index", "/"})
	public  String  inicializar(Model m ) {
		
	
		System.out.println(m.asMap().get("mensaje"));
		List<Cliente> clientes= (List<Cliente>) m.asMap().get("arreglo");
		if(clientes != null) {
		clientes.stream().forEach(objeto->{ 
												System.out.println("id:" +" " + objeto.getId() + " " +" nombre:"+  " " + objeto.getNombre() );
										});}
		
		
	m.addAttribute("listaCliente", clientedao.mostrarClientes())	;
		return "index";
	
	}
	
	
	@PostMapping("/postCliente")
	
	private  String   postCliente  ( @RequestParam("selector")  int selector ,  Model m ) {
		
		Cliente c= clientedao.recuperaCliente(selector);
	m.addAttribute("cliente",clientedao.recuperaCliente(selector))	;
	clientedao.setCliente(c);
	m.addAttribute("listaEmpleados", empleadoDao.listarEmpleados());
		
		
		 
		return "vistaEmpClien";
	}
	
	
	@GetMapping("/vistaProducto") 
	public  String  vistaProducto(Model m , @RequestParam int idCliente, @RequestParam int empleado) {
		
		
		Empleado e=  empleadoDao.recuperarEmpleado(empleado);
		empleadoDao.setEmpleado(e);
		m.addAttribute("listaProducto", productoDao.listarProducto());
		m.addAttribute("listaDetalle", detalleOrdenDao.getListaDetalle());
		
		if(numero<=1) {
		
		ordenDao.crearOrden(new Orden(clientedao.getCliente(), empleadoDao.getEmpleado(),  new Date()) );
		}
		numero++;
		return "vistaProducto";
	} 

	
	
	@PostMapping("/procesarProducto")
	public String procesarProducto (@RequestParam("producto") int producto,@RequestParam ("cantidad") String cantidad, RedirectAttributes  a) {
		
		if(cantidad=="") {
			a.addFlashAttribute("bandera", true);
			return "redirect:/vistaProducto?idCliente="+ clientedao.getCliente().getId()+ "&empleado=" + empleadoDao.getEmpleado().getId();}
		
		//DetalleOrden  d= new DetalleOrden(ordenDao.getOrden()	, new Producto(producto));
		detalleOrdenDao.getListaDetalle().add(new DetalleOrden(ordenDao.getOrden(), productoDao.encontrarProducto(producto),Integer.parseInt(cantidad)));
		
		
		for(DetalleOrden c : detalleOrdenDao.getListaDetalle()) {
			
			System.out.println("-------------------------prueba------------------------------");  
			System.out.println("objeto: "+ " "+ c.toString());
			System.out.println("empleado: "+ " "+ c.getOrden().getId_orden());
			System.out.println("empleado: "+ " "+ c.getOrden().getEmpleado().getNombre());
			System.out.println("cliente: "+ " "+ c.getOrden().getCliente().getNombre());
			System.out.println("producto: "+ " "+ c.getProducto().getDescripcion());
			System.out.println("cantidad: "+ " "+ c.getCantidad());
			
			System.out.println("-------------------------------------------------------");
			
			
			
		}
		
		
		return "redirect:/vistaProducto?idCliente="+ clientedao.getCliente().getId()+ "&empleado=" + empleadoDao.getEmpleado().getId();
	}

	@PostMapping("/lanzar")
	public String lanzar() { 
		
		ordenDao.guardarOrden();
		detalleOrdenDao.getListaDetalle().clear();
		
		numero=1;
		
		return "algo";
	}
	
	
	/* 1
	@GetMapping("/eliminar/{algo}")
	public String eliminar(@PathVariable ("algo") String algo , Model m ) {    
		
	for (int i =0; i<	detalleOrdenDao.getListaDetalle().size();i++) {
		System.out.println("-----------------------------------------------------");
		
		System.out.println(detalleOrdenDao.getListaDetalle().get(i).toString());
		System.out.println(algo);
		System.out.println("-----------------------------------------------------");
		
		if(detalleOrdenDao.getListaDetalle().get(i).toString().equals(algo)) {
			
			
			detalleOrdenDao.getListaDetalle().remove(i);
			
			
		}
		break;
		
	}
	for(DetalleOrden c : detalleOrdenDao.getListaDetalle()) {
		
		System.out.println("-------------------------------------------------------");  
		System.out.println("objeto: "+ " "+ c.toString());
		System.out.println("empleado: "+ " "+ c.getOrden().getId_orden());
		System.out.println("empleado: "+ " "+ c.getOrden().getEmpleado().getNombre());
		System.out.println("cliente: "+ " "+ c.getOrden().getCliente().getNombre());
		System.out.println("producto: "+ " "+ c.getProducto().getDescripcion());
		System.out.println("cantidad: "+ " "+ c.getCantidad());
		
		System.out.println("-------------------------------------------------------");
		
		
		
	}
		
	return "redirect:/vistaProducto?idCliente="+clientedao.getCliente().getId()  + "&empleado="+ empleadoDao.getEmpleado().getId();
	}*/
	
	/* 3
	@GetMapping("/eliminar")
	public String eliminar(@RequestParam ("algo") String algo , Model m ) {    
		
	for (int i =0; i<	detalleOrdenDao.getListaDetalle().size();i++) {
		System.out.println("-----------------------------------------------------");
		
		System.out.println(detalleOrdenDao.getListaDetalle().get(i).toString());
		System.out.println(algo);
		System.out.println("-----------------------------------------------------");
		
		if(detalleOrdenDao.getListaDetalle().get(i).toString().equals(algo)) {
			
			
			detalleOrdenDao.getListaDetalle().remove(i);
			
			
		}
		break;
		
	}
	for(DetalleOrden c : detalleOrdenDao.getListaDetalle()) {
		
		System.out.println("-------------------------------------------------------");  
		System.out.println("objeto: "+ " "+ c.toString());
		System.out.println("empleado: "+ " "+ c.getOrden().getId_orden());
		System.out.println("empleado: "+ " "+ c.getOrden().getEmpleado().getNombre());
		System.out.println("cliente: "+ " "+ c.getOrden().getCliente().getNombre());
		System.out.println("producto: "+ " "+ c.getProducto().getDescripcion());
		System.out.println("cantidad: "+ " "+ c.getCantidad());
		
		System.out.println("-------------------------------------------------------");
		
		
		
	}
		
	return "redirect:/vistaProducto?idCliente="+clientedao.getCliente().getId()  + "&empleado="+ empleadoDao.getEmpleado().getId();
	}
	*/
	
	
	
	  @GetMapping("/eliminar/{algo}")
	public String eliminar(@PathVariable ("algo") String algo , Model m ) {    
		
	for (int i =0; i<	detalleOrdenDao.getListaDetalle().size();i++) {
		System.out.println("-----------------------------------------------------");
		
		System.out.println(detalleOrdenDao.getListaDetalle().get(i).toString());
		System.out.println(algo);
		System.out.println("-----------------------------------------------------");
		
		if(detalleOrdenDao.getListaDetalle().get(i).toString().equals(algo)) {
			
			
			detalleOrdenDao.getListaDetalle().remove(i);
			
			
		}
		break;
		
	}
	for(DetalleOrden c : detalleOrdenDao.getListaDetalle()) {
		
		System.out.println("-------------------------------------------------------");  
		System.out.println("objeto: "+ " "+ c.toString());
		System.out.println("empleado: "+ " "+ c.getOrden().getId_orden());
		System.out.println("empleado: "+ " "+ c.getOrden().getEmpleado().getNombre());
		System.out.println("cliente: "+ " "+ c.getOrden().getCliente().getNombre());
		System.out.println("producto: "+ " "+ c.getProducto().getDescripcion());
		System.out.println("cantidad: "+ " "+ c.getCantidad());
		
		System.out.println("-------------------------------------------------------");
		
		
		
	}
		
	return "redirect:/vistaProducto?idCliente="+clientedao.getCliente().getId()  + "&empleado="+ empleadoDao.getEmpleado().getId();
	}
	  
	  @GetMapping("/error")
	  public String  redirectionPageError() {
		  
			log.info("ingreso al metodo de la inferface");
		  
		  return "error";
	  }


	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
	
		return "/error";
	}
	
	
	
}
