package com.example.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Cliente {
	
	public Cliente(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private  int id ;
	public Cliente() {
		
	}
	@Column
	private String nombre;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
}
