/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.viaje;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author stalinnarvaezmolina
 */
public class ContabilizadorDeRutas {

    ListaViaje listaViaje;
    Viaje[] viajes;
    String[] rutas;

    public ContabilizadorDeRutas(ListaViaje listaViaje) {
        this.listaViaje = listaViaje;
        viajes = listaViaje.getViajes();
        rutas = new String[viajes.length];
    }

    public String[][] mostrarRutasRepetidas() {//String partida, String destino
        for (int i = 0; i < viajes.length; i++) {
            if (viajes[i] != null) {
                rutas[i] = viajes[i].ubicacionPartida + "-" + viajes[i].ubicacionDestino;
            }
        }

        String[][] arreglo = new String[20][3];
        for (int i = 0; i < viajes.length; i++) {
            if (viajes[i] != null) {
                //System.out.println("Partida: " + viajes[i].ubicacionPartida + " Destino: " + viajes[i].ubicacionDestino + " Frecuencia " + getRutasRepetidas(viajes[i].ubicacionPartida,viajes[i].ubicacionDestino));
                arreglo[i][0] = viajes[i].ubicacionPartida;
                arreglo[i][1] = viajes[i].ubicacionDestino;
                arreglo[i][2] = String.valueOf(getRutasRepetidas(viajes[i].ubicacionPartida, viajes[i].ubicacionDestino));
            }
        }

        String[][] arregloLimpio = eliminarFilasRepetidas(arreglo);

        for (int i = 0; i < arregloLimpio.length - 1; i++) {
            for (int j = 0; j < arregloLimpio.length - 2; j++) {
                if (Integer.parseInt(arregloLimpio[j][2]) < Integer.parseInt(arregloLimpio[j + 1][2])) {
                    String[] temp = arregloLimpio[j];
                    arregloLimpio[j] = arregloLimpio[j + 1];
                    arregloLimpio[j + 1] = temp;
                }
            }
        }
//aqui toca borrar esto porque unicamente esta imprimiento con fines de ver si funciona toca devolcer el arreglo para mostraslo
//en la tabla del JFrame 
        for (int i = 0; i < arregloLimpio.length; i++) {
            for (int j = 0; j < arregloLimpio[i].length; j++) {
                if (arregloLimpio[i][j] != null) {
                    System.out.print(arregloLimpio[i][j] + " ");
                }
            }
            System.out.println();
        }
        return arregloLimpio;

    }

    private int getRutasRepetidas(String partida, String destino) {
        Map<String, Integer> mapRutas = new HashMap<>();
        int rutasRepetidas = 0;

        for (String ruta : rutas) {
            if (ruta != null) {
                String[] ciudades = ruta.split("-");
                String ciudadPartida = ciudades[0];
                String ciudadDestino = ciudades[1];

                if (ciudadPartida.equals(partida) && ciudadDestino.equals(destino)) {
                    if (mapRutas.containsKey(ruta)) {
                        rutasRepetidas++;
                    } else {
                        mapRutas.put(ruta, 1);
                        rutasRepetidas++;
                    }
                }
            }
        }
        return rutasRepetidas;
    }

    public static String[][] eliminarFilasRepetidas(String[][] arreglo) {
        int tamano = arreglo.length;
        boolean[] duplicados = new boolean[tamano];
        int numeroUnicos = tamano;
        for (int i = 0; i < tamano; i++) {
            if (!duplicados[i]) {
                for (int j = i + 1; j < tamano; j++) {
                    if (Arrays.equals(arreglo[i], arreglo[j])) {
                        duplicados[j] = true;
                        numeroUnicos--;
                    }
                }
            }
        }
        String[][] unicos = new String[numeroUnicos][];
        int contador = 0;
        for (int i = 0; i < tamano; i++) {
            if (!duplicados[i]) {
                unicos[contador++] = arreglo[i];
            }
        }
        return unicos;
    }

}
