package modelo.ranking;

import modelo.externo.Fecha;
import modelo.usuarios.Cuenta;

public class Penalizacion {

    private Fecha fecha; //fecha donde termina la penalizacion
    private Evaluacion evaluacion;
    private Cuenta cuenta;

    public Penalizacion(Fecha fecha, Cuenta cuenta) {
        this.fecha = fecha;
        this.evaluacion = cuenta.getEvaluacion();
        this.cuenta = cuenta;
    }

    public boolean verificarPenalizacion() {
        if (this.fecha.compararFechaActual()) {
            return false;
        } else {
            return true;
        }
    }

    public void generarPenalizacion() {
        //En caso de obtener un comentario negativo en el ultimo viaje
        Calificacion calificacion = this.evaluacion.getListaCalificaciones()[this.evaluacion.getNumCalificaciones()];
        if (calificacion instanceof CalificacionExperiencia) {
            if (((CalificacionExperiencia) calificacion).getComentario().getTipo().equals("Malo")) {
                this.fecha = new Fecha();
                this.fecha.sumarDias(7);
                return;
            }
        }
        //En caso de obtener promedio bajo       
        if (this.evaluacion.calcularCalificacionDeViajesRecientes() <= 3) {
            this.fecha = new Fecha();
            this.fecha.sumarDias(7);
        }
    }
}
