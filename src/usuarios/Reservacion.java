package usuarios;

import viaje.Viaje;

public class Reservacion {
    int numeroAsientos;
    Viaje viaje;

    public Reservacion(int numeroAsientos, Viaje viaje) {
        this.numeroAsientos = numeroAsientos;
        this.viaje = viaje;

    }

    public double calcularPrecioReservacion() {
        double precio = 0;
        for (int i = 0; i < numeroAsientos; i++) {
            viaje.asientos[i].actualizarEstado();
            precio = viaje.asientos[i].getPrecio();
        }
        System.out.println("el precio del asiento es " + precio * numeroAsientos );
        return precio * numeroAsientos;
    }
}
