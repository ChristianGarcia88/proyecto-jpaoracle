package com.example.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedNativeQuery(name="Orden.nombreConsulta", query = "select *  from  orden o inner join empleado d on (o.id_empleado=d.id) where  d.nombre='Admin' ", resultClass = Orden.class) 
public class Orden {

	public Orden(){}
	
	public Orden(Cliente cliente, Empleado empleado, Date fecha_generada) { 
		super();
		this.cliente = cliente;
		this.empleado = empleado;
		this.fecha_generada = fecha_generada;
	}


	@Id
	@GeneratedValue (strategy =GenerationType.AUTO )
	private   Integer id_orden;
	
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente  cliente;
	
	@ManyToOne
	@JoinColumn(name = "id_empleado")
	private Empleado empleado; 
	
	@Column
	@Temporal (TemporalType.DATE)
	private  Date  fecha_generada;
	
	
	@Column
	@Temporal (TemporalType.DATE)
	private Date fecha_entregada;


	public Integer getId_orden() {
		return id_orden;
	}


	public void setId_orden(Integer id_orden) {
		this.id_orden = id_orden;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Empleado getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}


	public Date getFecha_generada() {
		return fecha_generada;
	}


	public void setFecha_generada(Date fecha_generada) {
		this.fecha_generada = fecha_generada;
	}


	public Date getFecha_entregada() {
		return fecha_entregada;
	}


	public void setFecha_entregada(Date fecha_entregada) {
		this.fecha_entregada = fecha_entregada;
	}
	
	
	
	
	
}
