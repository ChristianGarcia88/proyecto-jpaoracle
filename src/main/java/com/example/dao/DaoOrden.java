package com.example.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.modelo.Orden;
import com.example.persistence.IOrden;
@Controller
public class DaoOrden {

	@Autowired
	private IOrden ordenP;
	
	private  Orden orden;
	
	
	@Autowired
	 private DetalleOrdenDao d;
	
	
	public Orden getOrden() {
		return orden;
	}


	public void setOrden(Orden orden) {
		this.orden = orden;
	}


	public void crearOrden( Orden  orden) {
		
		
		this.orden= orden;
		
	} 
	
	@Transactional
	public void  guardarOrden( ) {
		
		ordenP.save(this.orden);
		d.getListaDetalle().forEach(elemento->{ d.guardaDetalle(elemento) ;
		//System.out.println(elemento.getProducto().getDescripcion() +" " + elemento.getCantidad());
		});
	}
}
