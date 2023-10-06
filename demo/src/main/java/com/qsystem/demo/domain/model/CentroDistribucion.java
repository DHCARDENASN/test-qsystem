package com.qsystem.demo.domain.model;



public class CentroDistribucion {	
    public String nombre;
    public String descripcion;
    
    public CentroDistribucion() {
    	
    }
    
    public CentroDistribucion(String nombre) {
    	this.nombre = nombre;
    }
    
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
    
    
    

}