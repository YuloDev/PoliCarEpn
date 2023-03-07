package modelo.ranking;

import modelo.externo.Fecha;
import modelo.viaje.Viaje;

public class Calificacion {

    protected int puntaje;
    protected Viaje viaje;
    protected Fecha fecha;

    public Calificacion(Viaje viaje) {
        this.viaje = viaje;
        this.fecha = new Fecha();
    }
    
    public Calificacion(){}

    public void ingresar(int puntaje) {
        this.puntaje = puntaje;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public int getPuntaje() {
        return puntaje;
    }

}
