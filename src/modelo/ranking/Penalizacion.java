package modelo.ranking;

import modelo.externo.Fecha;
import modelo.usuarios.Cuenta;

public class Penalizacion {

    private Fecha fecha; //fecha donde termina la penalizacion
    private Evaluacion evaluacion;


    public Penalizacion(Evaluacion evaluacion) {
        this.fecha = null;
        this.evaluacion = evaluacion;
    }

    public boolean verificarPenalizacion() {
        if (fecha == null) {
            return false;
        }
        return !this.fecha.compararFechaActual();
    }

    public void generarPenalizacion() {
        //En caso de obtener un comentario negativo en el ultimo viaje
        Calificacion calificacion = this.evaluacion.getListaCalificaciones()[this.evaluacion.getNumCalificaciones()];
        if (((CalificacionExperiencia) calificacion).getComentario().getTipo().equals("Malo")) {
            this.fecha = calificacion.getFecha();
            this.fecha.sumarDias(7);
            return;
        }
        //En caso de obtener promedio bajo       
        if (this.evaluacion.calcularCalificacionDeViajesRecientes() <= 3) {
            this.fecha = calificacion.getFecha();
            this.fecha.sumarDias(7);
        }
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }


}
