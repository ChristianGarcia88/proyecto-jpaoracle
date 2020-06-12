package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.modelo.Empleado;
import com.example.persistence.IEmpleado;

@Controller
public class EmpleadoDao {

	@Autowired
	private IEmpleado empleadoP;
	
	
	private Empleado empleado;
	



	public Empleado getEmpleado() {
		return empleado;
	}




	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}




	public  List<Empleado> listarEmpleados(){
		
		
		return  empleadoP.findAll();
		
		
	}
	
	
	public Empleado recuperarEmpleado(int id) {
		
	return	empleadoP.recuperarEmpleado(id);
		
		
	}
	
}
