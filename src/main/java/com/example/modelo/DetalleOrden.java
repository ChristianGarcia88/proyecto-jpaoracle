package com.example.modelo;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class DetalleOrden {

	
	
	
	@Id
	@GeneratedValue (strategy =GenerationType.AUTO ) 
	private Integer id_detalle_orden;
	
	public DetalleOrden() {}
	public DetalleOrden( Orden orden, Producto producto, Integer cantidad) {
	
		this.orden = orden;
		this.producto = producto;
		this.cantidad=cantidad;
	}

	@ManyToOne()
	@JoinColumn(name = "id_orden" )
	private  Orden orden;
	
	
	@ManyToOne
	@JoinColumn(name = "id_producto") 
	private Producto  producto;
	
	@Column
	private  Integer  cantidad;

	public Integer getId_detalle_orden() {
		return id_detalle_orden;
	}

	public void setId_detalle_orden(Integer id_detalle_orden) {
		this.id_detalle_orden = id_detalle_orden;
	}

	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return  super.toString() ;
	}
	
}
