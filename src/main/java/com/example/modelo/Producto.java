package com.example.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Producto {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Integer  id_producto;
	
	
	public Integer getId_producto() {
		return id_producto;
	}


	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Column
	private String descripcion;


	public Producto(Integer id_producto) {
		super();
		this.id_producto = id_producto;
		
	}
	public Producto() {
		
	}
}
