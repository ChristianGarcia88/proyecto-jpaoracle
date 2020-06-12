package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.modelo.Producto;
import com.example.persistence.IProducto;

@Component
public class DaoProducto {

	@Autowired
	private IProducto  productoP;
	
	
	public List<Producto> listarProducto(){
		
		
		return productoP.findAll();
		
		
	}
	
	
	public Producto encontrarProducto(int id ) {
		
		
		return productoP.encontrarProducto(id) ;
	}
}
