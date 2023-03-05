package viaje;

import usuarios.Cuenta;
import reservacion.Reservacion;
import usuarios.Usuario;

import java.util.Arrays;

public class Viaje {
    public Asiento[] asientos;
    Reservacion[] reservaciones;
    Usuario[] usuarios;
    String ubicacionPartida;
    String ubicacionDestino;
    Cuenta cuenta;


    public Viaje(String ubicacionPartida, String ubicacionDestino, int numAsientos, double precioUnitarioAsiento, Cuenta cuenta) {
        asientos = new Asiento[numAsientos];
        this.ubicacionPartida = ubicacionPartida;
        this.ubicacionDestino = ubicacionDestino;
        this.cuenta = cuenta;
        inicializaAsientos(precioUnitarioAsiento);
    }



    public void finalizar() {
        System.out.println("Viaje finalizado");
    }

    public void inicializaAsientos(double precioPorAsiento) {
        for (int i = 0; i < asientos.length; i++) {
            asientos[i] = new Asiento(precioPorAsiento);
        }
    }

    public Asiento[] getAsientos() {
        return asientos;
    }

    public Reservacion[] getReservaciones() {
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
                "asientos=" + Arrays.toString(asientos) +
                ", ubicacionPartida='" + ubicacionPartida + '\'' +
                ", ubicacionDestino='" + ubicacionDestino + '\'' +
                '}';
    }
}
