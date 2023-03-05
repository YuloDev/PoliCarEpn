package modelo.ranking;

import modelo.ranking.Calificacion;

public class Evaluacion {

    private Calificacion[] listaCalificaciones;
    double promedio = 5;

    public Evaluacion() {
        this.listaCalificaciones = new Calificacion[30];
        //this.lista.mostrarLista();
        this.promedio = 0;
    }

    public double calcularCalificacionTotal() {
        int i = 0;
        for (Calificacion calificacion : listaCalificaciones) {
            if (calificacion != null) {
                promedio = promedio + calificacion.getPuntaje();
                i++;
            }
        }
        promedio = promedio / i;

        return promedio;

    }

    public void añadirCalificacion(Calificacion calificacion) {
        for (int i = 0; i < listaCalificaciones.length; i++) {
            if (listaCalificaciones[i] == null) {
                listaCalificaciones[i] = calificacion;
                listaCalificaciones[i].mostrar(); //Eliminar solo prueba
                return;
            }
        }
        System.out.println("Máximo de calificaciones");
    }

    public void quitarCalificacion(Calificacion calificacion) {
        for (int i = 0; i < listaCalificaciones.length; i++) {
            if (listaCalificaciones[i].equals(calificacion)) {
                listaCalificaciones[i] = null;
                return;
            }
        }
        System.out.println("La calificacion no se encuentra");
    }

}
