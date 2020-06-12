package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.modelo.DetalleOrden;
import com.example.persistence.IDetalleOrden;

@Controller
public class DetalleOrdenDao {
	
	@Autowired
	private IDetalleOrden  ordenDetalleP;
	
	
	private List<DetalleOrden>  listaDetalle =  new ArrayList<>();


	public List<DetalleOrden> getListaDetalle() {
		return listaDetalle;
	}


	public void setListaDetalle(List<DetalleOrden> listaDetalle) {
		this.listaDetalle = listaDetalle;
	}
	
	@Transactional(value = TxType.REQUIRED)
	public void guardaDetalle( DetalleOrden elemento ) {
		
		
	 ordenDetalleP.save(elemento);
	 
	 ordenDetalleP.obtenerTodo("Admin").forEach(objeto->{
		 
		System.out.println(objeto.getOrden().getCliente().getNombre()+" "+objeto.getOrden().getEmpleado().getNombre()+	  " "+ objeto.getOrden().getId_orden() +" "+ objeto.getId_detalle_orden() +" "+ objeto.getProducto().getDescripcion() + " "+ objeto.getCantidad());
	 });
		
	 
	 System.out.print("----------------   prueba dos DTO-------------");
	 
	 
	 ordenDetalleP.pruebaDos().stream().forEach(objetoTo ->{System.out.println(objetoTo.getId_orden() + " " + objetoTo.getNombreC() + " "+ objetoTo.getNombreE());});
		
	}

	
}
