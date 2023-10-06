package com.qsystem.demo.aplication.service;

import org.springframework.stereotype.Service;

import com.qsystem.demo.domain.model.CentroDistribucion;
import com.qsystem.demo.domain.puerto.CentroDistribucionRepository;


public class DomainCentroDistribucionService implements CentroDistribucionService {

	
	private final CentroDistribucionRepository centroDistribucionRepository;
	
	public String saveCentroDistribucion (CentroDistribucion centroDistribucion) throws Exception{
		System.out.println("DomainCentroDistribucionService-saveCentroDistribucion");
		return centroDistribucionRepository.saveCentroDistribucion(centroDistribucion);
	}
	
	public DomainCentroDistribucionService(CentroDistribucionRepository centroDistribucionRepository) {
		this.centroDistribucionRepository = centroDistribucionRepository;
	}
	
	@Override
	public Iterable<CentroDistribucion> getCentrosDistribucion() {	
		return centroDistribucionRepository.getCentrosDistribucion();
	}

	@Override
	public CentroDistribucion getDescripcion(String centroDistribucion) throws Exception {		
		return centroDistribucionRepository.getDescripcion(centroDistribucion);
	}
	

}
