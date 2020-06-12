package com.example.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.modelo.Orden;

public interface IOrden extends JpaRepository<Orden, Integer>  {
	
	
List <Orden>	nombreConsulta ();

}
