package org.example.domain.service;

import org.example.Constantes;
import org.example.domain.model.CentroDistribucion;
import java.util.ArrayList;
import java.util.List;

public class CentroDistribucionService {

    public List<CentroDistribucion> getCentrosDistribucion(){
        List<CentroDistribucion> listCentros = new ArrayList<>();
        listCentros.add(
                CentroDistribucion.builder()
                        .nombre("LURIN").build() );

        listCentros.add(
                CentroDistribucion.builder()
                        .nombre("ICA").build() );

        listCentros.add(
                CentroDistribucion.builder()
                        .nombre("TRUJILLO").build() );

        listCentros.add(
                CentroDistribucion.builder()
                        .nombre("HUANUCO").build() );

        return listCentros;
    }

    public void getDescripcion(String centroDistribucion){

        switch (centroDistribucion){
            case Constantes.CENTRO_DIST_LURIN:
                System.out.println("En el centro de distribución de "+centroDistribucion+
                        " los lunes juegan futbol los empleadores.");
                break;
            case Constantes.CENTRO_DIST_ICA:
                System.out.println("En el centro de distribución de "+centroDistribucion+
                        " no se trabaja feriados nacionales.");
                break;
            case Constantes.CENTRO_DIST_TRUJILLO:
                System.out.println("En el centro de distribución de "+centroDistribucion+
                        " se celebra la marinera.");
                break;
            case Constantes.CENTRO_DIST_HUANUCO:
                System.out.println("En el centro de distribución de "+centroDistribucion+
                        " los sabados se trabaja hasta medio dia.");
                break;
            default:
                System.out.println("Centro de distrubución "+centroDistribucion+ "no reconocido");
                break;
        }

    }
}
