package ranking;

import java.time.LocalDateTime;
import viaje.Viaje;

public abstract class Calificacion {

    protected double puntaje;
    protected Viaje viaje;
    protected LocalDateTime localDateTime;

    public Calificacion(Viaje viaje) {
        this.viaje = viaje;
        this.localDateTime = LocalDateTime.now();
    }

    public Calificacion(double puntaje) {
        this.puntaje = puntaje;
    }

    public Calificacion() {
        this.localDateTime = LocalDateTime.now();
    }
    
    public void ingresar(double puntaje) {
        this.puntaje = puntaje;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }

    public void mostrar() {
        System.out.println("La calificacion es:" + this.puntaje);
    }

    public double getPuntaje() {
        return puntaje;
    }

}
