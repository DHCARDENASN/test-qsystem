package com.qsystem.demo.infrastructure.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qsystem.demo.aplication.service.CentroDistribucionService;
import com.qsystem.demo.aplication.service.DomainCentroDistribucionService;
import com.qsystem.demo.aplication.service.DomainPersonaService;
import com.qsystem.demo.aplication.service.PersonaService;
import com.qsystem.demo.domain.puerto.CentroDistribucionRepository;
import com.qsystem.demo.domain.puerto.PersonaRepository;


@Configuration
public class BeanConfiguration {

	@Bean
	CentroDistribucionService centroDistribucionService(final CentroDistribucionRepository centroDistribucionRepository) {
		return new DomainCentroDistribucionService(centroDistribucionRepository);
	}
	
	@Bean
	PersonaService personaService(final PersonaRepository personaRepository) {
		return new DomainPersonaService(personaRepository);
	}
}
