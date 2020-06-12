package com.example.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.modelo.DTOOrden;
import com.example.modelo.DetalleOrden;

public interface IDetalleOrden  extends  JpaRepository<DetalleOrden, Integer>{
	
	// from  DetalleOrden   e inner join  e.orden inner join  e.producto O  from  DetalleOrden   Y TRAE TODO
	@Query(" from  DetalleOrden   e  where e.orden.empleado.nombre =?1") 
	List<DetalleOrden> obtenerTodo(String nombre);
	
	
	//@Query("select  new com.example.modelo.DTOOrden(d.id_orden, e.nombre, c.nombre) " +" from  Orden d  inner join  d.empleado  e  inner join d.cliente  c")
	@Query("select  new com.example.modelo.DTOOrden(d.id_orden, d.empleado.nombre, d.cliente.nombre) " +" from  Orden d")

	List<DTOOrden> pruebaDos();

}
