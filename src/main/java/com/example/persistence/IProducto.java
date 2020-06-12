package com.example.persistence;

import javax.persistence.NamedNativeQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.modelo.Producto;

public interface IProducto   extends JpaRepository<Producto, Integer> {

	
	@Query  ("select  p from Producto p where p.id_producto=:id")
	Producto encontrarProducto (@Param (value = "id")int id1);
}
