/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import modelo.externo.Fecha;
import modelo.usuarios.Vehiculo;
import modelo.usuarios.Usuario;
import modelo.usuarios.Pasajero;
import modelo.usuarios.Conductor;
import modelo.ranking.CalificacionConductor;
import modelo.ranking.CalificacionExperiencia;
import modelo.ranking.CalificacionVehiculo;
import modelo.ranking.Evaluacion;
import modelo.reservacion.Reservacion;
import modelo.viaje.Viaje;
import vistas.usuarios.JFInicio;


public class PoliCar {


    public static void main(String[] args) {

        Usuario nuevoUsuario = new Usuario("Rafael", "Piedra", "0983973649", 202010344);
        Pasajero cuentaPasajero = new Pasajero("r.p@epn.edu.ec", "1234", nuevoUsuario);
        Pasajero cuentaPasajero1 = new Pasajero("r.p@epn.edu.ec", "1234", nuevoUsuario);
        Pasajero cuentaPasajero2 = new Pasajero("r.p@epn.edu.ec", "1234", nuevoUsuario);
        
        Vehiculo vehiculo = new Vehiculo("PBC123", "Kia rio", "rojo", 2019, 4);     
        Conductor cuentaConductor = new Conductor("r.p@epn.edu.ec", "1234", nuevoUsuario, vehiculo);
        Viaje nuevoViaje = new Viaje("Quito", "Santa Rosa",cuentaConductor.obtenerCantidadAsientos(),2.3, cuentaConductor, new Fecha("2023-03-05 17:05:28"));
        cuentaConductor.crearViaje(nuevoViaje);
        Reservacion reservacion1 = new Reservacion(nuevoViaje,cuentaPasajero,4);
        Reservacion reservacion2 = new Reservacion(nuevoViaje,cuentaPasajero1,4);
        Viaje nuevoViaje1 = new Viaje("Quito", "Guayakill",cuentaConductor.obtenerCantidadAsientos(),2.3, cuentaConductor, new Fecha("2023-02-07 17:05:28"));
        cuentaConductor.crearViaje(nuevoViaje1);
        Reservacion reservacion3 = new Reservacion(nuevoViaje1,cuentaPasajero2,4);
        Viaje nuevoViaje2 = new Viaje("Manta", "Guayakill",cuentaConductor.obtenerCantidadAsientos(),2.3, cuentaConductor, new Fecha("2023-02-05 17:05:28"));
        cuentaConductor.crearViaje(nuevoViaje2);
        Reservacion reservacion4 = new Reservacion(nuevoViaje2,cuentaPasajero,4);
        
        
        //prueba ranking
        
        Evaluacion evaluacion = new Evaluacion();
        
        CalificacionConductor cal1 = new CalificacionConductor(nuevoViaje);
        cal1.ingresar(4);
        CalificacionVehiculo cal5 = new CalificacionVehiculo(nuevoViaje);
        cal5.ingresar(2);
        CalificacionConductor cal2 = new CalificacionConductor(nuevoViaje1);
        cal2.ingresar(3);
        CalificacionConductor cal3 = new CalificacionConductor(nuevoViaje2);
        cal3.ingresar(5);
        
        
        evaluacion.añadirCalificacion(cal1);
        evaluacion.añadirCalificacion(cal2);
        evaluacion.añadirCalificacion(cal3);
        evaluacion.añadirCalificacion(cal5);
        
        System.out.println("Array antes: " + evaluacion.toString());
        
        System.out.println("promedio " + evaluacion.calcularCalificacionDeViajesRecientes());
        
        
        
        
        
        
        
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new JFInicio().setVisible(true);
//            }
//        });
        
        
        
        
        /*
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
        /*
        Viaje nuevoViaje = new Viaje("Quito", "Santa Rosa",
                cuentaConductor.obtenerCantidadAsientos(),2.3, cuentaConductor, new Fecha("2023-03-05 17:05:28"));
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
        */
        
    }
}

