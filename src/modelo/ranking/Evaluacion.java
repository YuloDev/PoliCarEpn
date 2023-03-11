package modelo.ranking;

public class Evaluacion {

    private Calificacion[] listaCalificaciones;
    double promedio;

    public Evaluacion() {
        this.listaCalificaciones = new Calificacion[30];
        this.promedio = 0;
    }

    public double calcularCalificacionTotal() {
        int i = 0;
        
        for (int j = 0; j < listaCalificaciones.length; j++) {
            if (listaCalificaciones[j] != null) {
                promedio = promedio + listaCalificaciones[j].getPuntaje();
                i++;
            }else{
                break;
            }
        }
        promedio = promedio / i;

        double promedioR = java.lang.Math.round(promedio * 100.0) / 100.0;

        return promedioR;

    }

    public void añadirCalificacion(Calificacion calificacion) {
        for (int i = 0; i < listaCalificaciones.length; i++) {
            if (this.listaCalificaciones[i] == null) {
                this.listaCalificaciones[i] = calificacion;
                break;
            }
        }
    }

    public void quitarCalificacion(Calificacion calificacion) {
        for (int i = 0; i < listaCalificaciones.length; i++) {
            if (listaCalificaciones[i].equals(calificacion)) {
                listaCalificaciones[i] = null;
                return;
            }
        }
    }

    public Calificacion[] getListaCalificaciones() {
        return listaCalificaciones;
    }
}
