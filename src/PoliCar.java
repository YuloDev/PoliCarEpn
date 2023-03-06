/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import modelo.usuarios.Vehiculo;
import modelo.usuarios.Usuario;
import modelo.usuarios.Pasajero;
import modelo.usuarios.Conductor;
import modelo.ranking.CalificacionConductor;
import modelo.ranking.CalificacionExperiencia;
import modelo.ranking.CalificacionVehiculo;
import modelo.reservacion.Reservacion;
import modelo.viaje.Viaje;


public class PoliCar {


    public static void main(String[] args) {

        Usuario nuevoUsuario = new Usuario("Rafael", "Piedra", "0983973649", 202010344);
        Pasajero cuentaPasajero = new Pasajero("r.p@epn.edu.ec", "1234", nuevoUsuario);
        Pasajero cuentaPasajero1 = new Pasajero("r.p@epn.edu.ec", "1234", nuevoUsuario);
        Pasajero cuentaPasajero2 = new Pasajero("r.p@epn.edu.ec", "1234", nuevoUsuario);

        Vehiculo vehiculo = new Vehiculo("PBC123", "Kia rio", "rojo", 2019, 4);
             
        Conductor cuentaConductor = null;
        /*
        if (vehiculo.validarAño()){
            cuentaConductor = new Conductor("r.p@epn.edu.ec", "1234",
                nuevoUsuario, vehiculo);
        }
        */
        Viaje nuevoViaje = new Viaje("Quito", "Santa Rosa",
                cuentaConductor.obtenerCantidadAsientos(),2.3, cuentaConductor);
        cuentaConductor.crearViaje(nuevoViaje);
        System.out.println(nuevoViaje);
        System.out.println(nuevoViaje.getListaDeAsientos().length);
        
        Reservacion reservacion1 = new Reservacion(nuevoViaje,cuentaPasajero,4);
        // Se utiliza un if para comprobar los datos de reservación porque si no hay asientos disponibles 
        // Reservacion no puede eliminarse a si misma (combox solo con asientos disponibles)
        // (otra opcion: lanzar un error)
        if (reservacion1.getCuenta()!=null){
            cuentaPasajero.crearReservacion(reservacion1);
        }
        //Todos los asientos ocupados
        Reservacion reservacion2 = new Reservacion(nuevoViaje,cuentaPasajero,1);
        if (reservacion2.getCuenta()!=null){
            cuentaPasajero.crearReservacion(reservacion2);
        }
        System.out.println(reservacion1);
        System.out.println(reservacion2);
        
        
        //ranking
        
        CalificacionConductor calificacionConductor = new CalificacionConductor(nuevoViaje);
        CalificacionVehiculo calificacionVehiculo = new CalificacionVehiculo(nuevoViaje);
        CalificacionExperiencia calificacionExperiencia = new CalificacionExperiencia(nuevoViaje);
        
        calificacionConductor.ingresar(4);
        calificacionVehiculo.ingresar(3);
        calificacionExperiencia.ingresar(3);
        calificacionExperiencia.agregarComentario("hahahah");
        
        
        cuentaPasajero.calificarViaje( calificacionConductor, calificacionVehiculo, calificacionExperiencia);
        
        System.out.println(cuentaConductor.getEvaluacion().calcularCalificacionTotal());
        
    }
}

