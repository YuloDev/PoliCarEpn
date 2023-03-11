/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorBD.viaje;

import controladorBD.conexion.ConexionMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import modelo.reservacion.Reservacion;
import modelo.usuarios.Pasajero;
import modelo.viaje.Asiento;
import modelo.viaje.Viaje;

/**
 *
 * @author Cesar
 */
public class SqlAsiento {

    /*
    public HashMap<Integer, Asiento> obtenerAsientos(HashMap<Integer,Viaje> viajes) {
        HashMap<Integer, Reservacion> asientos = new HashMap<Integer, Reservacion>();

        ResultSet rs = null;
        com.mysql.jdbc.PreparedStatement ps = null;
        ConexionMySQL con = new ConexionMySQL();
        java.sql.Connection conexion = con.conectar();

        String sql = "select * from asientos";
        try {
            ps = (com.mysql.jdbc.PreparedStatement) conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                Viaje viaje = viajes.get(rs.getInt(2));
                
                asientos.put(rs.getInt(1),);
                Pasajero cuentaTemp = (Pasajero) cuentas.get(rs.getInt(3));

                Reservacion reservacion = new Reservacion(viajes.get(rs.getInt(2)), cuentaTemp, rs.getInt(5));

                asientos.put(rs.getInt(1), reservacion);

                cuentaTemp.crearReservacion(reservacion);
            }
            System.out.println("Instanciación de Reservaciones");
            return asientos;
        } catch (SQLException e) {
            return null;
        }

    }
*/
}
