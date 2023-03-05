/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reservacion;

import usuarios.Cuenta;
import viaje.Asiento;
import viaje.Libre;
import viaje.Viaje;

/**
 *
 * @author Cesar
 */
public class Reservacion {

    private Viaje viaje;
    private Asiento[] listaDeAsientos;
    private double precio;
    private Cuenta cuenta;

    public Reservacion(Viaje viaje, Cuenta cuenta, int numeroAsientos) {
        this.viaje = viaje;
        this.listaDeAsientos = new Asiento[10];
        if (!buscarAsientosDisponibles(viaje, numeroAsientos)) {
            return;
        }
        for (Asiento asiento : listaDeAsientos) {
            if (asiento!=null){
                asiento.actualizarEstado();
            }
        }
        this.cuenta = cuenta;
        calcularPrecioReservacion();
    }

    private boolean buscarAsientosDisponibles(Viaje viaje1, int numeroAsientos) {
        Asiento[] asientosDelViaje = viaje1.getAsientos();
        int i = 0;
        for (Asiento asiento : asientosDelViaje) {
            if (asiento.getEstado() instanceof Libre) {
                añadirAsiento(asiento);
                i++;
            }
            if (i==numeroAsientos){
                return true;
            }
        }
        return false;
    }

    public void cancelar() {
        for (Asiento asiento : listaDeAsientos) {
            asiento.actualizarEstado();
        }
    }

    public void calcularPrecioReservacion() {
        this.precio = 0;
        for (Asiento asiento : listaDeAsientos) {
            if (asiento!=null){
                this.precio += asiento.getPrecio();
            }
        }
    }

    public void añadirAsiento(Asiento asiento) {
        for (int i = 0; i < listaDeAsientos.length; i++) {
            if (listaDeAsientos[i]==null) {
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
