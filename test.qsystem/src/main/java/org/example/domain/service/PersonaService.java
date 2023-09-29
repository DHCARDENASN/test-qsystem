package org.example.domain.service;

import org.example.Constantes;
import org.example.domain.model.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonaService {

    public List<Persona> getPersonas() {
        List<Persona> personas = new ArrayList<>();
        personas.add(Persona.builder()
                .dni("75976256")
                .appPaterno("Cardenas")
                .appMatterno("Navarro").build());

        personas.add(Persona.builder()
                .dni("12345678")
                .appPaterno("Gomez")
                .appMatterno("Perez").build());

        personas.add(Persona.builder()
                .dni("85214763")
                .appPaterno("Paredes")
                .appMatterno("Torres").build());

        personas.add(Persona.builder()
                .dni("87654321")
                .appPaterno("Malca")
                .appMatterno("Peña").build());

        personas.add(Persona.builder()
                .dni("65432189")
                .appPaterno("Quispe")
                .appMatterno("Alva").build());

        return personas;
    }

    public List<Persona> getListOrder(List<Persona> listPersona,Integer order){
        List<Persona> personasOrdenadas = null;
        switch (order){
            case Constantes.ORDER_BY_DNI:
                System.out.println("Ordenando por DNI..");
                 personasOrdenadas = listPersona.stream()
                        .sorted((p1, p2) -> p1.getDni().compareTo(p2.getDni()))
                        .collect(Collectors.toList());
                break;
            case Constantes.ORDER_BY_APPATERNO:
                System.out.println("Ordenando por apellido paterno..");
                personasOrdenadas = listPersona.stream()
                        .sorted((p1, p2) -> p1.getAppPaterno().compareTo(p2.getAppPaterno()))
                        .collect(Collectors.toList());
                break;
            default:
                System.out.println("Lista desordenada..");
                personasOrdenadas = listPersona;
                break;
        }

        personasOrdenadas.stream().forEach(persona -> System.out.println("DNI: " + persona.getDni() +
                ", Apellido: " + persona.getAppPaterno()));

        return personasOrdenadas;
    }



}
