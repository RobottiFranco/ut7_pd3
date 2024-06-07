package com.example;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * Hello world!
 */
public final class App {

    public static void main(String[] args) {
        /* ej1 */
        TGrafoDirigido VUELE_SEGURO = (TGrafoDirigido) UtilGrafos.cargarGrafo("aeropuertos.txt", "conexiones.txt",
                false, TGrafoDirigido.class);
        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(VUELE_SEGURO.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, VUELE_SEGURO.getVertices(), "Matriz vuelos");

        Double[][] floyd = VUELE_SEGURO.floyd();
        UtilGrafos.imprimirMatrizMejorado(floyd, VUELE_SEGURO.getVertices(), "Matriz Floyd");

        /* ej2 */
        TCaminos caminoMontevideoCuritiva = VUELE_SEGURO.todosLosCaminos("Montevideo", "Curitiba");
        TCaminos caminoPorto_AlegreSantos = VUELE_SEGURO.todosLosCaminos("Porto_Alegre", "Santos");

        caminoMontevideoCuritiva.imprimirCaminosConsola();
        caminoPorto_AlegreSantos.imprimirCaminosConsola();

        /* ej3 */
        List<TVertice> bpf = (ArrayList) VUELE_SEGURO.bpf();
        for (TVertice tVertice : bpf) {
            System.out.println(tVertice.getEtiqueta());
        }

        System.out.println("===========================");

        bpf = (ArrayList) VUELE_SEGURO.bpf("Montevideo");
        for (TVertice tVertice : bpf) {
            System.out.println(tVertice.getEtiqueta());
        }
    }
}
