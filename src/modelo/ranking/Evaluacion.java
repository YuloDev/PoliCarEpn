package modelo.ranking;

import modelo.externo.Fecha;
import modelo.viaje.Viaje;

public class Evaluacion {

    private Calificacion[] listaCalificaciones;
    private int numeroCalificacionesExistentes = -1;
    private double promedio;

    public Evaluacion() {
        this.listaCalificaciones = new Calificacion[100];
        this.promedio = 0;
    }

    public double calcularCalificacionTotal() {
        int i = 0;

        for (int j = 0; j < listaCalificaciones.length; j++) {
            if (listaCalificaciones[j] != null) {
                promedio = promedio + listaCalificaciones[j].getPuntaje();
                i++;
            } else {
                break;
            }
        }
        promedio = promedio / i;
        double promedioR = java.lang.Math.round(promedio * 100.0) / 100.0;
        return promedioR;
    }

    public double calcularCalificacionDeViajesRecientes() {

        Viaje[] viajesRecientes = new Viaje[3];
        int numViajes = 0;

        double promedio = 0;
        int numCalificaciones = 0;

        for (int i = numeroCalificacionesExistentes; i >= 0; i--) {
            viajesRecientes[numViajes] = listaCalificaciones[i].getViaje();
            if (numViajes > 0 && viajesRecientes[numViajes].equals(viajesRecientes[numViajes - 1])) {
                continue;
            }
            for (int j = numeroCalificacionesExistentes; j >= 0; j--) {
                if (viajesRecientes[numViajes].equals(listaCalificaciones[j].getViaje())) {
                    promedio += listaCalificaciones[j].puntaje;
                    numCalificaciones++;
                }
            }
            numViajes++;
            if (numViajes == 3) {
                break;
            }
        }
        return promedio = promedio / numCalificaciones;
    }

    public void añadirCalificacion(Calificacion calificacion) {
        for (int i = 0; i < listaCalificaciones.length; i++) {
            if (this.listaCalificaciones[i] == null) {
                this.listaCalificaciones[i] = calificacion;
                numeroCalificacionesExistentes++;
                break;
            }
        }
    }

    public void quitarCalificacion(Calificacion calificacion) {
        for (int i = 0; i < listaCalificaciones.length; i++) {
            if (listaCalificaciones[i].equals(calificacion)) {
                listaCalificaciones[i] = null;
                numeroCalificacionesExistentes--;
                return;
            }
        }
    }

    public Calificacion[] getListaCalificaciones() {
        return listaCalificaciones;
    }

    public int getNumCalificaciones() {
        return numeroCalificacionesExistentes;
    }

    //quitar
    @Override
    public String toString() {

        for (int i = 0; i <= numeroCalificacionesExistentes; i++) {
            System.out.println("i = " + listaCalificaciones[i]);
        }

        return "Evaluacion{" + "listaCalificaciones=" + listaCalificaciones + '}';
    }

}
