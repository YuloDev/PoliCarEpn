package modelo.viaje;

import modelo.viaje.Asiento;
import modelo.externo.Fecha;
import modelo.usuarios.Cuenta;
import modelo.reservacion.Reservacion;
import modelo.usuarios.Usuario;

import java.util.Arrays;

import modelo.reservacion.ListaReservacion;

public class Viaje {

    private ListaAsiento listaDeAsientos;
    private ListaReservacion reservaciones;
    private Usuario usuario;
    public String ubicacionPartida;
    public String ubicacionDestino;
    private Cuenta cuenta;
    private Fecha fecha;

    public Viaje(String ubicacionPartida, String ubicacionDestino, int numAsientos, double precioUnitarioAsiento, Cuenta cuenta, Fecha fecha) {
        listaDeAsientos = new ListaAsiento();
        this.ubicacionPartida = ubicacionPartida;
        this.ubicacionDestino = ubicacionDestino;
        this.cuenta = cuenta;
        this.fecha = fecha;
        iniciarViaje(numAsientos,precioUnitarioAsiento,fecha);
        this.reservaciones = new ListaReservacion();
        this.fecha = fecha;
    }

    public void iniciarViaje(int numAsientos,double precioUnitarioAsiento,Fecha fecha) {
           for (int i = 0; i < numAsientos; i++) {
            listaDeAsientos.añadirAsiento(new Asiento(precioUnitarioAsiento));
        }
        this.reservaciones = new ListaReservacion();
        this.fecha = fecha;

    }

    public ListaAsiento getListaDeAsientos() {
        return listaDeAsientos;
    }

    public ListaReservacion getListaReservacion() {
        return reservaciones;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getUbicacionPartida() {
        return ubicacionPartida;
    }

    public String getUbicacionDestino() {
        return ubicacionDestino;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public Fecha getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Viaje{"
                + "asientos=" + listaDeAsientos.getAsientos()
                + ", ubicacionPartida='" + ubicacionPartida + '\''
                + ", ubicacionDestino='" + ubicacionDestino + '\''
                + '}';
    }
}
