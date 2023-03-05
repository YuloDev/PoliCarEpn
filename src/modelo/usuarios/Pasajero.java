package modelo.usuarios;

import modelo.usuarios.Cuenta;
import modelo.usuarios.Conductor;
import modelo.ranking.Calificacion;
import modelo.ranking.CalificacionConductor;
import modelo.ranking.CalificacionExperiencia;
import modelo.ranking.CalificacionVehiculo;
import modelo.ranking.Evaluacion;
import modelo.reservacion.Reservacion;

public class Pasajero extends Cuenta {

    public Pasajero(String correo, String contraseña, Usuario usuario) {
        super(correo, contraseña, usuario);
    }

    public Pasajero(String correo, String contraseña, Usuario usuario, Vehiculo vehiculo) {
        super(correo, contraseña, usuario);
        this.vehiculo = vehiculo;
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

    public void cambiarCuenta() {
        Conductor conductor;
        if (this.vehiculo == null) {//verifica si el pasajero posee un vehiculo y lo crea
            //Gui ingresar vehiculo
            conductor = new Conductor(this.correo, this.contraseña, this.usuario, new Vehiculo("PDB1856", "AVEO", "azul", 2010, 4));
            System.out.println("Registro exitoso");
        } else {//si ya tiene vehiculo solo cambia a conductor
            conductor = new Conductor(this.correo, this.contraseña, this.usuario, this.vehiculo);
            System.out.println("Se ha cambiado a conductor");
        }
        usuario.iniciarSesion(correo, contraseña, conductor);
    }

    @Override
    public String toString() {
        return usuario.toString()
                + "\nPasajero";
    }

}
