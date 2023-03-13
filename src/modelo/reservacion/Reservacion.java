/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.reservacion;

import modelo.usuarios.Cuenta;
import modelo.viaje.Asiento;
import modelo.viaje.ListaAsiento;
import modelo.viaje.Viaje;

/**
 *
 * @author Cesar
 */
public class Reservacion {

    private Viaje viaje;
    private ListaAsiento listaDeAsientos;
    private double precio;
    private Cuenta cuenta;
    private RestriccionFechaReservacion restriccion;

    public Reservacion(Viaje viaje, Cuenta cuenta, int numeroAsientosRequeridos) {
        this.viaje = viaje;
        
        this.restriccion = new RestriccionFechaReservacion(cuenta.getListaReservacion());
        if (restriccion.verificarRestriccion(this)) {
            throw new IllegalArgumentException("Ya existe una reservación para la misma fecha y hora");
        }
        this.listaDeAsientos = new ListaAsiento();
        ListaAsiento listaAsientosDelViaje = viaje.getListaDeAsientos();
        int numeroAsientosDisponibles = 0;
        for (Asiento asiento : listaAsientosDelViaje.getAsientos()) {
            if (asiento != null) {
                if (asiento.solicitar()) {
                    listaDeAsientos.añadirAsiento(asiento);
                    numeroAsientosDisponibles++;
                }
                if (numeroAsientosDisponibles == numeroAsientosRequeridos) {
                    break;
                }
            }
        }
        if (numeroAsientosDisponibles != numeroAsientosRequeridos) {
            throw new IllegalArgumentException("No existen asientos disponibles para la resevacion");
        }

        for (Asiento asiento : listaDeAsientos.getAsientos()) {
            if (asiento != null) {
                asiento.actualizarEstado();
            }
        }

        this.cuenta = cuenta;
        calcularPrecioReservacion();
        viaje.getListaReservacion().añadirReservacion(this);
    }

    public void cancelar() {
        cuenta.getListaReservacion().quitarReservacion(this);
        viaje.getListaReservacion().quitarReservacion(this);
        for (Asiento asiento : listaDeAsientos.getAsientos()) {
            if (asiento != null) {
                asiento.actualizarEstado();
            }
        }
    }

    public void calcularPrecioReservacion() {
        this.precio = 0;
        for (Asiento asiento : listaDeAsientos.getAsientos()) {
            if (asiento != null) {
                this.precio += asiento.getPrecio();
            }
        }
    }

    public Viaje getViaje() {
        return viaje;
    }

    public ListaAsiento getListaDeAsientos() {
        return listaDeAsientos;
    }

    public double getPrecio() {
        return precio;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    @Override
    public String toString() {
        return "Reservacion{" + "viaje=" + viaje + ", listaDeAsientos=" + listaDeAsientos + ", precio=" + precio + ", cuenta=" + cuenta + '}';
    }

}
