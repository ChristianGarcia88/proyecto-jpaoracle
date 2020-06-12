package com.example.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.modelo.Cliente;

public interface ICliente  extends  JpaRepository<Cliente, Integer>{
	
	
	@Query("select  c from Cliente c  where c.id=?1")
	Cliente recuperaCliente( int id) ; 

}
