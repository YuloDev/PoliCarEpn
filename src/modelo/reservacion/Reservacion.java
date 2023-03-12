/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.reservacion;

import modelo.usuarios.Cuenta;
import modelo.viaje.Asiento;
import modelo.viaje.Viaje;

/**
 *
 * @author Cesar
 */
public class Reservacion {

    private Viaje viaje;
    private Asiento[] listaDeAsientos;
    private double precio;
    private Cuenta cuenta;
    private RestriccionFechaReservacion restriccion;

    public Reservacion(Viaje viaje, Cuenta cuenta, int numeroAsientosRequeridos) {
        this.viaje = viaje;

        this.restriccion = new RestriccionFechaReservacion(cuenta.getListaReservacion());
        if (restriccion.verificarRestriccion(this)) {
            return;
        }

        this.listaDeAsientos = new Asiento[10];
        Asiento[] asientosDelViaje = viaje.getListaDeAsientos();
        int numeroAsientosDisponibles = 0;
        for (Asiento asiento : asientosDelViaje) {
            if (asiento.solicitar()) {
                añadirAsiento(asiento);
                numeroAsientosDisponibles++;
            }
            if (numeroAsientosDisponibles == numeroAsientosRequeridos) break;
        }
        if (numeroAsientosDisponibles!=numeroAsientosRequeridos) return;
        
        for (Asiento asiento : listaDeAsientos) {
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
        for (Asiento asiento : listaDeAsientos) {
            asiento.actualizarEstado();
        }
    }

    public void calcularPrecioReservacion() {
        this.precio = 0;
        for (Asiento asiento : listaDeAsientos) {
            if (asiento != null) {
                this.precio += asiento.getPrecio();
            }
        }
    }

    public void añadirAsiento(Asiento asiento) {
        for (int i = 0; i < listaDeAsientos.length; i++) {
            if (listaDeAsientos[i] == null) {
                listaDeAsientos[i] = asiento;
                return;
            }
        }
        System.out.println("Máximo de asientos");
    }

    public void quitarAsiento(Asiento asiento) {
        for (int i = 0; i < listaDeAsientos.length; i++) {
            if (listaDeAsientos[i].equals(asiento)) {
                listaDeAsientos[i] = null;
                return;
            }
        }
        System.out.println("La reservacion no se encuentra");
    }

    public Viaje getViaje() {
        return viaje;
    }

    public Asiento[] getListaDeAsientos() {
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
