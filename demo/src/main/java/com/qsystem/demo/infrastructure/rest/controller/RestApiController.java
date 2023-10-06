package com.qsystem.demo.infrastructure.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qsystem.demo.aplication.service.CentroDistribucionService;
import com.qsystem.demo.aplication.service.PersonaService;
import com.qsystem.demo.domain.model.CentroDistribucion;
import com.qsystem.demo.domain.model.Persona;

@RestController
@RequestMapping("api")
public class RestApiController {
	private static Logger log = LoggerFactory.getLogger(RestApiController.class);
	
	private final CentroDistribucionService centroDistribucionService;
	private final PersonaService personaService;
	
	public RestApiController(CentroDistribucionService centroDistribucionService, PersonaService personaService) {
		this.centroDistribucionService = centroDistribucionService;
		this.personaService = personaService;
	}
	
	
	@PutMapping("/primerejercicio/agregar")
	public ResponseEntity savePersona(@RequestBody Persona persona) throws Exception{
		log.info("PUT - Ingresando a savePersona..");
		this.personaService.savePersona(persona);
		return new ResponseEntity<>(this.personaService.getPersona(persona.getDni()), HttpStatus.CREATED);
	}
	
	
	@GetMapping("/primerejercicio/{order}")
	public ResponseEntity<Iterable<Persona>> listPersonas(@PathVariable String order) throws Exception{
		log.info("Ingresando a listPersonas..");
		return new ResponseEntity<>(this.personaService.getPersonas(order), HttpStatus.OK);
	}
	
	
	@GetMapping("/segundoejercicio")
	public ResponseEntity<Iterable<CentroDistribucion>> listCentroDistribucion(){
		log.info("Ingresando a listCentroDistribucion..");
		return new ResponseEntity<>(this.centroDistribucionService.getCentrosDistribucion(), HttpStatus.OK);
	}
			
	@PutMapping("/segundoejercicio/agregar")
	public ResponseEntity saveCentroDistribucion(@RequestBody CentroDistribucion centroDistribucion) throws Exception{
		log.info("POST - Ingresando a saveCentroDistribucion..");
		this.centroDistribucionService.saveCentroDistribucion(centroDistribucion);
		return new ResponseEntity<>(centroDistribucionService.getDescripcion(centroDistribucion.getNombre()), HttpStatus.CREATED);						
	}
	
	@PostMapping("/segundoejercicio/{nombre}")
	public ResponseEntity<String> getCentroDistribucion(@PathVariable String nombre) throws Exception{
		log.info("POST - Ingresando a saveCentroDistribucion..");
		return new ResponseEntity<>(centroDistribucionService.getDescripcion(nombre).getDescripcion(), HttpStatus.CREATED);
	}
	
		
}
