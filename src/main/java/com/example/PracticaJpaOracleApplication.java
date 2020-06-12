package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.dao.DaoCliente;
import com.example.modelo.Orden;
import com.example.persistence.IOrden;

@SpringBootApplication
public class PracticaJpaOracleApplication  implements  CommandLineRunner {
@Autowired
private  IOrden orden;
	public static void main(String[] args) {
		SpringApplication.run(PracticaJpaOracleApplication.class, args);
		
    
		
	}
	


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("-----------------------------Prueba NamedNativeQuery  ---------------------------------------------------------");
orden.nombreConsulta().stream().forEach(objeto ->{System.out.println(objeto.getId_orden()+ " " +   objeto.getCliente().getNombre() + " " +	objeto.getId_orden());

		}
		);
System.out.println("-----------------------------FIN NamedNativeQuery  ---------------------------------------------------------");	
	}
	
	

}
