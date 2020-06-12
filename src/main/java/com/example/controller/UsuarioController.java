package com.example.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.example.modelo.Cliente;
import com.example.persistence.ICliente;

@Controller
public class UsuarioController {
	
	@Autowired
	private  ICliente   pCliente;
	
	@PostMapping("/agregarCliente")
	public String agregarUsuario(  Cliente  cliente, Model m, RedirectAttributes r ) {
		
		Cliente c=pCliente.save(cliente);
		if(c != null) {
			
			r.addFlashAttribute("mensaje", "Se ha agregado exitosamente");
			r.addFlashAttribute("arreglo",Arrays.asList(new Cliente(1,"christian"),new Cliente(2, "pedro")));
		}
		
		return "redirect:/index";
		
		
		
	}
	

}
