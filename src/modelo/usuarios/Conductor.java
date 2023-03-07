package modelo.usuarios;

import modelo.reservacion.Reservacion;
import modelo.viaje.Viaje;

public class Conductor extends Cuenta {

    
    public Conductor(String correo, String contraseña, Usuario usuario, Vehiculo vehiculo) {
        super(correo, contraseña, usuario);
        this.vehiculo = vehiculo;

    }

    public void crearViaje(Viaje nuevoViaje) {
        listaViaje.añadirViaje(nuevoViaje);
    }

    public void cancelarViaje(Viaje viaje) {
        listaViaje.quitarViaje(viaje);
        for (Reservacion reservacion : viaje.getListaReservacion().getReservaciones()) {
            if (reservacion != null) {
                reservacion.getCuenta().getListaReservacion().quitarReservacion(reservacion);
            }
        }
    }
    
    
    @Override
    public void cambiarCuenta() {
        
    }

    public int obtenerCantidadAsientos() {
        return vehiculo.getNumeroAsientos();
    }

    @Override
    public String toString() {

        return usuario.toString() + "\nConductor " + "\n" + vehiculo.mostrarInfo();
    }

}
