/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package usuarios;

import ranking.CalificacionConductor;
import ranking.CalificacionExperiencia;
import ranking.CalificacionVehiculo;
import reservacion.Reservacion;
import viaje.Viaje;


public class PoliCar {


    public static void main(String[] args) {

        Usuario nuevoUsuario = new Usuario("Rafael", "Piedra", "0983973649", 202010344);
        Pasajero cuentaPasajero = new Pasajero("r.p@epn.edu.ec", "1234", nuevoUsuario);
        Pasajero cuentaPasajero1 = new Pasajero("r.p@epn.edu.ec", "1234", nuevoUsuario);
        Pasajero cuentaPasajero2 = new Pasajero("r.p@epn.edu.ec", "1234", nuevoUsuario);

        Conductor cuentaConductor = new Conductor("r.p@epn.edu.ec", "1234",
                nuevoUsuario, new Vehiculo("PBC123", "Kia rio", "rojo", 2019, 4));
        Viaje nuevoViaje = new Viaje("Quito", "Santa Rosa",
                cuentaConductor.obtenerCantidadAsientos(),2.3, cuentaConductor);
        cuentaConductor.crearViaje(nuevoViaje);
        System.out.println(nuevoViaje);
        System.out.println(nuevoViaje.getAsientos().length);
        
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
        
        CalificacionConductor calificacionConductor = new CalificacionConductor(reservacion1.getViaje());
        CalificacionVehiculo calificacionVehiculo = new CalificacionVehiculo(reservacion1.getViaje());
        CalificacionExperiencia calificacionExperiencia = new CalificacionExperiencia(reservacion1.getViaje());
        
        calificacionConductor.ingresar(4);
        calificacionVehiculo.ingresar(3);
        calificacionExperiencia.ingresar(3);
        calificacionExperiencia.agregarComentario("hahahah");
        
        
        cuentaPasajero.calificarViaje(reservacion1, calificacionConductor, calificacionVehiculo, calificacionExperiencia);
        
        System.out.println(cuentaConductor.getEvaluacion().calcularCalificacionTotal());
        
    }
}

