/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.reservacion;


/**
 *
 * @author Cesar
 */
public class ListaReservacion {
    private Reservacion[] reservaciones;

    public ListaReservacion() {
        this.reservaciones = new Reservacion[100];
    }
    
    public void añadirReservacion(Reservacion reservacion) {
        for (int i = 0; i < reservaciones.length; i++) {
            if (reservaciones[i]==null) {
                reservaciones[i] = reservacion;
                return;
            }
        }
        System.out.println("Máximo de reservaciones");
    }

    public void quitarReservacion(Reservacion reservacion) {
        for (int i = 0; i < reservaciones.length; i++) {
            if (reservaciones[i].equals(reservacion)) {
                reservaciones[i] = null;
                return;
            }
        }
        System.out.println("La reservacion no se encuentra");
    }

    public Reservacion[] getReservaciones() {
        return reservaciones;
    }
}
