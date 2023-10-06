package com.qsystem.demo.domain.puerto;



import java.beans.JavaBean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.qsystem.demo.domain.model.CentroDistribucion;

/*
 Contrato/Interfaz que sirve para que la capa infrastructure 
 se conecte a la capa modelo
 */


public interface CentroDistribucionRepository {
	
	String saveCentroDistribucion (CentroDistribucion centroDistribucion) throws Exception;
	Iterable<CentroDistribucion> getCentrosDistribucion();	
	CentroDistribucion getDescripcion(String centroDistribucion) throws Exception;
	
}
