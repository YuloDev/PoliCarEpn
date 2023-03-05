package modelo.ranking;

import modelo.externo.Fecha;
import java.time.LocalDateTime;
import modelo.viaje.Viaje;

public abstract class Calificacion {

    protected double puntaje;
    protected Viaje viaje;
    protected Fecha fecha;

    public Calificacion(Viaje viaje) {
        this.viaje = viaje;
        this.fecha = new Fecha();
    }

    public void ingresar(double puntaje) {
        this.puntaje = puntaje;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void mostrar() {
        System.out.println("La calificacion es:" + this.puntaje);
    }

    public double getPuntaje() {
        return puntaje;
    }

}
