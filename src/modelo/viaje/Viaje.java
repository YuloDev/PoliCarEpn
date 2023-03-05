package modelo.viaje;

import modelo.viaje.Asiento;
import modelo.externo.Fecha;
import modelo.usuarios.Cuenta;
import modelo.reservacion.Reservacion;
import modelo.usuarios.Usuario;

import java.util.Arrays;
import modelo.reservacion.ListaReservacion;

public class Viaje {
    public Asiento[] listaDeAsientos;
    ListaReservacion reservaciones;
    Usuario[] usuarios;
    String ubicacionPartida;
    String ubicacionDestino;
    Cuenta cuenta;
    Fecha fecha;


    public Viaje(String ubicacionPartida, String ubicacionDestino, int numAsientos, double precioUnitarioAsiento, Cuenta cuenta) {
        listaDeAsientos = new Asiento[numAsientos];
        this.ubicacionPartida = ubicacionPartida;
        this.ubicacionDestino = ubicacionDestino;
        this.cuenta = cuenta;
        for (int i = 0; i < listaDeAsientos.length; i++) {
            listaDeAsientos[i] = new Asiento(precioUnitarioAsiento);
        }
        this.reservaciones = new ListaReservacion();
        this.fecha = new Fecha();
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
    
    public Asiento[] getListaDeAsientos() {
        return listaDeAsientos;
    }

    public ListaReservacion getListaReservacion() {
        return reservaciones;
    }

    public Usuario[] getUsuarios() {
        return usuarios;
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
   
    @Override
    public String toString() {
        return "Viaje{" +
                "asientos=" + Arrays.toString(listaDeAsientos) +
                ", ubicacionPartida='" + ubicacionPartida + '\'' +
                ", ubicacionDestino='" + ubicacionDestino + '\'' +
                '}';
    }
}
