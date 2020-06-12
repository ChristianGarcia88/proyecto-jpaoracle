package com.example.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.modelo.Cliente;
import com.example.persistence.ICliente;
import com.example.persistence.IEmpleado;

@Component
public class DaoCliente {
	
	
	private Cliente cliente;
	


public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

@Autowired
	//private  EntityManager  enti;
	private ICliente clienteP;

	public  List<Cliente> mostrarClientes() {
		
		return clienteP.findAll();
		
		
		 
		
	

		
		
	}
	
	public  Cliente recuperaCliente(int id) {
		
		
		
		return clienteP.recuperaCliente(id);
		
	}
	
	
	
}
