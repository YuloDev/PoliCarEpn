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


    public Viaje(String ubicacionPartida, String ubicacionDestino, int numAsientos,double precioUnitarioAsiento) {
        asientos = new Asiento[numAsientos];
        this.ubicacionPartida = ubicacionPartida;
        this.ubicacionDestino = ubicacionDestino;
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

    @Override
    public String toString() {
        return "Viaje{" +
                "asientos=" + Arrays.toString(asientos) +
                ", ubicacionPartida='" + ubicacionPartida + '\'' +
                ", ubicacionDestino='" + ubicacionDestino + '\'' +
                '}';
    }
}
