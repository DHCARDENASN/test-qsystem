package com.qsystem.demo.infrastructure.adaptador.firebase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.qsystem.demo.Constantes;
import com.qsystem.demo.domain.model.CentroDistribucion;
import com.qsystem.demo.domain.model.Persona;
import com.qsystem.demo.domain.puerto.CentroDistribucionRepository;
import com.qsystem.demo.domain.puerto.PersonaRepository;
import com.qsystem.demo.infrastructure.exceptions.ResourceNotFoundException;
import com.qsystem.demo.infrastructure.rest.controller.RestApiController;

@Repository
public class FirebaseRepository  implements CentroDistribucionRepository, PersonaRepository{
	private static Logger log = LoggerFactory.getLogger(FirebaseRepository.class);
	
	private static final String COLLECTION_NAME_CENTRO_DISTRIBUCION = "centro-distribucion";
	private static final String COLLECTION_NAME_PERSONAS = "personas";
	
	public String  saveCentroDistribucion(CentroDistribucion centroDistribucion) throws Exception {		
		log.info("FirebaseRepository-saveCentroDistribucion");
		
		Firestore dbFireStore = FirestoreClient.getFirestore();
		
		ApiFuture<WriteResult> collectionApiFuture=  dbFireStore.collection(COLLECTION_NAME_CENTRO_DISTRIBUCION)
													.document(centroDistribucion.getNombre().toUpperCase())
													.set(centroDistribucion);
						
		return collectionApiFuture.get().getUpdateTime().toString();
	}

	@Override
	public Iterable<CentroDistribucion> getCentrosDistribucion()  {
		log.info("FirebaseRepository-getCentrosDistribucion");
		List<CentroDistribucion> listCentros = new ArrayList();	
		try {
				
			Firestore dbFireStore = FirestoreClient.getFirestore();
			
			ApiFuture<QuerySnapshot> future=  dbFireStore.collection(COLLECTION_NAME_CENTRO_DISTRIBUCION)
														.get();
										 
			List<QueryDocumentSnapshot> documents = future.get().getDocuments();
			for (QueryDocumentSnapshot document : documents) {			  
			  listCentros.add(document.toObject(CentroDistribucion.class));
			}
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return listCentros;
	}

	@Override
	public CentroDistribucion getDescripcion(String nombreCentroDistribucion) throws Exception{
		log.info("FirebaseRepository-getDescripcion");
		CentroDistribucion centroDistribucion = null;
		
		Firestore dbFireStore = FirestoreClient.getFirestore();
		
		DocumentReference documentReference=  dbFireStore.collection(COLLECTION_NAME_CENTRO_DISTRIBUCION)
													.document(nombreCentroDistribucion.toUpperCase());
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		
		DocumentSnapshot document = future.get();
		
		
		if(document.exists()) {
			centroDistribucion = document.toObject(CentroDistribucion.class);
		}else {
			throw new ResourceNotFoundException("Recurso no encontrado");
		}
		
		return centroDistribucion;
		
	}
	
	@Override
	public String savePersona(Persona persona) throws Exception {
		log.info("FirebaseRepository-savePersona");
		
		Firestore dbFireStore = FirestoreClient.getFirestore();
		
		ApiFuture<WriteResult> collectionApiFuture=  dbFireStore.collection(COLLECTION_NAME_PERSONAS)
													.document(persona.getDni())
													.set(persona);
						
		return collectionApiFuture.get().getUpdateTime().toString();
	}
	
	@Override
	public Iterable<Persona> getPersonas(String order) throws Exception {
		log.info("FirebaseRepository-getCentrosDistribucion");
		List<Persona> listPersonas = new ArrayList();
		List<Persona> personasOrdenadas = new ArrayList();	
		
		Firestore dbFireStore = FirestoreClient.getFirestore();
			
			ApiFuture<QuerySnapshot> future=  dbFireStore.collection(COLLECTION_NAME_PERSONAS)
														.get();
										 
			List<QueryDocumentSnapshot> documents = future.get().getDocuments();
			for (QueryDocumentSnapshot document : documents) {			  
				listPersonas.add(document.toObject(Persona.class));
				
			}
			
			switch (order){
			 case Constantes.ORDER_BY_RANDOM:
	                System.out.println("Ordenando Random: ");
	                personasOrdenadas= listPersonas;
	                Collections.shuffle(listPersonas);
	                break;
            case Constantes.ORDER_BY_DNI:
                System.out.println("Ordenando por DNI: ");
                 personasOrdenadas = listPersonas.stream()
                        .sorted((p1, p2) -> p1.getDni().compareTo(p2.getDni()))
                        .collect(Collectors.toList());
                break;
            case Constantes.ORDER_BY_APPATERNO:
                System.out.println("Ordenando por apellido paterno: ");
                personasOrdenadas = listPersonas.stream()
                        .sorted((p1, p2) -> p1.getAppPaterno().compareTo(p2.getAppPaterno()))
                        .collect(Collectors.toList());
                break;
            default:
            	throw new ResourceNotFoundException("Parametro no encontrado");               
        }
								
		
		return personasOrdenadas;
	}

	@Override
	public Iterable<Persona> getListOrder(Iterable<Persona> listPersona, Integer order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona getPersona(String dni) throws Exception {
		log.info("FirebaseRepository-getDescripcion");
		Persona persona = null;
		
		Firestore dbFireStore = FirestoreClient.getFirestore();
		
		DocumentReference documentReference=  dbFireStore.collection(COLLECTION_NAME_PERSONAS)
													.document(dni);
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		
		DocumentSnapshot document = future.get();
		
		
		if(document.exists()) {
			persona = document.toObject(Persona.class);
		}else {
			throw new ResourceNotFoundException("Recurso no encontrado");
		}
		
		
													
		return persona;
	}

	

}
