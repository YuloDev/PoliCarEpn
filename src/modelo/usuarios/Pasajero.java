package modelo.usuarios;


import modelo.pago.Creditos;
import modelo.ranking.Calificacion;
import modelo.ranking.Evaluacion;
import modelo.reservacion.Reservacion;

public class Pasajero extends Cuenta {
    
    public Pasajero(String correo, String contraseña, Usuario usuario, double valorInicial) {
        super(correo, contraseña, usuario);
        creditos = new Creditos(valorInicial);
    }

    public void crearReservacion(Reservacion nuevaReservacion) {
        listaReservacion.añadirReservacion(nuevaReservacion);
    }


    @Override
    public void calificarViaje(Calificacion ... calificaciones) {
        //codigo calificar viaje
        Evaluacion evaluacionConductor = calificaciones[0].getViaje().getCuenta().getEvaluacion();
        for (Calificacion calificacion : calificaciones) {
            evaluacionConductor.añadirCalificacion(calificacion);
        }
    }

    public Creditos getCreditos() {
        return creditos;
    }

    @Override
    public String toString() {
        return usuario.toString()
                + "\nPasajero";
    }

}
