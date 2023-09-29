package org.example;

import org.example.domain.model.CentroDistribucion;
import org.example.domain.model.Persona;
import org.example.domain.service.*;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        //primer ejercicio
        primerEjercicio();

        //segundo ejercicio
        segundoEjercicio();

        //tercer ejericio
        tercerEjercicio();
    }

    public static void primerEjercicio(){
        System.out.println("************************************** PRIMER EJERCICIO **************************************");
        System.out.println("respondiendo la pregunta 1");
        //se implementa el servicio
        PersonaService personaService = new PersonaService();

        //se obtiene la DATA del servicio
        List<Persona> listPersonas = personaService.getPersonas();

        //pintando la lista desordenada
        personaService.getListOrder(listPersonas, 0);

        //pintando la lista ordenada por DNI
        personaService.getListOrder(listPersonas, Constantes.ORDER_BY_DNI);

        //pintando la lista ordenada por Apellido Paterno
        personaService.getListOrder(listPersonas, Constantes.ORDER_BY_APPATERNO);
    }

    public static void segundoEjercicio(){
        System.out.println("");
        System.out.println("************************************** SEGUNDO EJERCICIO **************************************");
        System.out.println("respondiendo la pregunta 2");
        //se implementa el servicio
        CentroDistribucionService centroDistribucionService = new CentroDistribucionService();

        //obteniendo los centros de distribucion
        List<CentroDistribucion> listCentros =centroDistribucionService.getCentrosDistribucion();

        //recorriendo y pintando las descripciones
        listCentros.stream().forEach( centro -> centroDistribucionService.getDescripcion(centro.getNombre()));
    }

    public static void tercerEjercicio(){
        System.out.println("");
        System.out.println("************************************** TERCER EJERCICIO **************************************");
        System.out.println("respondiendo la pregunta 3");
        //se obtienen los servicios
        Comportamiento1Service comportaimento1Service = new Comportamiento1Service();
        Comportamiento2Service comportaimento2Service = new Comportamiento2Service();
        Comportamiento3Service comportaimento3Service = new Comportamiento3Service();

        //obteniendo diferentes comportaientos bajo una misma firma (metodo)
        comportaimento1Service.ejecutarFirma();
        comportaimento2Service.ejecutarFirma();
        comportaimento3Service.ejecutarFirma();
    }
}
