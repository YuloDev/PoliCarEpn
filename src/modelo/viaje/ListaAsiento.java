/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.viaje;

/**
 *
 * @author Cesar
 */
public class ListaAsiento {

    private Asiento[] asientos;

    public ListaAsiento() {
        this.asientos = new Asiento[100];
    }

    public void añadirAsiento(Asiento asiento) {
        for (int i = 0; i < asientos.length; i++) {
            if (asientos[i] == null) {
                asientos[i] = asiento;
                return;
            }
        }
        System.out.println("Máximo numero de asientos");
    }

    public void quitarAsiento(Asiento asiento) {
        for (int i = 0; i < asientos.length; i++) {
            if (asientos[i].equals(asiento)) {
                asientos[i] = null;
                return;
            }
        }
        System.out.println("El asiento no se encuentra");
    }

    public Asiento[] getAsientos() {
        return asientos;
    }

}
