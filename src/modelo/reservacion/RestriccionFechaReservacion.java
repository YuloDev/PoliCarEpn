/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.reservacion;

/**
 *
 * @author Cesar
 */
public class RestriccionFechaReservacion {

    private ListaReservacion listaReservacion;

    public RestriccionFechaReservacion(ListaReservacion listaReservacion) {
        this.listaReservacion = listaReservacion;
    }

    public boolean verificarRestriccion(Reservacion reservacion) {
        boolean existeColision = false;
        Reservacion[] reservacionesPasajero = listaReservacion.getReservaciones();
        for (int i = 0; i < reservacionesPasajero.length; i++) {
            if (reservacionesPasajero[i] != null) {
                if (reservacion.getViaje().getFecha().getFechaYHora().equals(reservacionesPasajero[i].getViaje().getFecha().getFechaYHora())) {
                    existeColision = true;
                }
            }
        }
        return existeColision;
    }

}
