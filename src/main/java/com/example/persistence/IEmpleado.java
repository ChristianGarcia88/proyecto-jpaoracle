package com.example.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.modelo.Empleado;

public interface IEmpleado  extends  JpaRepository<Empleado, Integer>{

	@Query("select e from Empleado e  where e.id=:id")
	Empleado  recuperarEmpleado(@Param(value = "id") int id);
}
