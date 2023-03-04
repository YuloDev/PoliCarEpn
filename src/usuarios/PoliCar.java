/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package usuarios;

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
                cuentaConductor.obtenerCantidadAsientos(),2.3);
        cuentaConductor.crearViaje(nuevoViaje);
        System.out.println(nuevoViaje);
        cuentaPasajero.crearReservacion(new Reservacion(4, nuevoViaje));
        cuentaPasajero.crearReservacion(new Reservacion(1, nuevoViaje));
        cuentaPasajero.crearReservacion(new Reservacion(1, nuevoViaje));
        cuentaPasajero.crearReservacion(new Reservacion(1, nuevoViaje));
        cuentaPasajero.crearReservacion(new Reservacion(1, nuevoViaje));
        cuentaPasajero.crearReservacion(new Reservacion(1, nuevoViaje));
    }

}

