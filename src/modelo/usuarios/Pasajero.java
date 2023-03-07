package modelo.usuarios;


import modelo.ranking.Calificacion;
import modelo.ranking.Evaluacion;
import modelo.reservacion.Reservacion;

public class Pasajero extends Cuenta {

    public Pasajero(String correo, String contraseña, Usuario usuario) {
        super(correo, contraseña, usuario);
    }

    public void crearReservacion(Reservacion nuevaReservacion) {
        listaReservacion.añadirReservacion(nuevaReservacion);
    }

    public void cancelarReservacion(Reservacion reservacion) {
        //Codigo de cancelar reservacion
        reservacion.cancelar();
    }

    public void calificarViaje(Calificacion ... calificaciones) {
        //codigo calificar viaje
        Evaluacion evaluacionConductor = calificaciones[0].getViaje().getCuenta().getEvaluacion();
        for (Calificacion calificacion : calificaciones) {
            evaluacionConductor.añadirCalificacion(calificacion);
        }
    }

    @Override
    public String toString() {
        return usuario.toString()
                + "\nPasajero";
    }

}
