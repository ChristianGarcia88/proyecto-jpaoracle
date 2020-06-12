package com.example.modelo;

public class DTOOrden {
	
private Integer  id_orden;
private   String nombreE;
private   String nombreC;
public Integer getId_orden() {
	return id_orden;
}
public void setId_orden(Integer id_orden) {
	this.id_orden = id_orden;
}
public String getNombreE() {
	return nombreE;
}
public void setNombreE(String nombreE) {
	this.nombreE = nombreE;
}
public String getNombreC() {
	return nombreC;
}
public void setNombreC(String nombreC) {
	this.nombreC = nombreC;
}
public DTOOrden(Integer id_orden, String nombreE, String nombreC) {
	super();
	this.id_orden = id_orden;
	this.nombreE = nombreE;
	this.nombreC = nombreC;
}




}
