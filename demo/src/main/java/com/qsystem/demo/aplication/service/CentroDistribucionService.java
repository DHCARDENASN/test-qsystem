package com.qsystem.demo.aplication.service;

import com.qsystem.demo.domain.model.CentroDistribucion;

public interface CentroDistribucionService {
	
	String saveCentroDistribucion (CentroDistribucion centroDistribucion) throws Exception;
	Iterable<CentroDistribucion> getCentrosDistribucion();	
	CentroDistribucion getDescripcion(String centroDistribucion) throws Exception;
}
