/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorBD.reservacion;

import com.mysql.jdbc.PreparedStatement;
import controladorBD.conexion.ConexionMySQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import modelo.externo.Fecha;
import modelo.reservacion.Reservacion;
import modelo.usuarios.Conductor;
import modelo.usuarios.Cuenta;
import modelo.usuarios.Pasajero;
import modelo.viaje.Viaje;

/**
 *
 * @author Cesar
 */
public class SqlReservacion {

    public boolean registrarReservacion(Reservacion reservacion) {
        Viaje viaje = reservacion.getViaje();
        Cuenta cuentaConductor = reservacion.getViaje().getCuenta();
        Cuenta cuentaPasajero = reservacion.getCuenta();

        int idCuentaPasajero = obtenerIDCuenta(cuentaPasajero);
        int idViaje = obtenerIDViaje(cuentaConductor, viaje);

        PreparedStatement ps = null;
        ConexionMySQL con = new ConexionMySQL();
        Connection conexion = con.conectar();
        String sql = "INSERT INTO RESERVACION (IDVIAJE,IDCUENTA,VALOR) "
                + "VALUES (?,?,?);";
        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setInt(1, idViaje); //IDVIAJE
            ps.setInt(2, idCuentaPasajero); // IDCUENTA
            ps.setDouble(3, reservacion.getPrecio()); // VALOR
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("1");
            return false;
        }
    }

    private int obtenerIDViaje(Cuenta cuentaConductor, Viaje viaje) {

        int idCuentaConductor = obtenerIDCuenta(cuentaConductor);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaViaje = viaje.getFecha().getFechaYHora().format(formatter);

        ResultSet rs = null;
        PreparedStatement ps = null;
        ConexionMySQL con = new ConexionMySQL();
        Connection conexion = con.conectar();

        String sql = "SELECT IDVIAJE FROM VIAJE WHERE IDCUENTA = ? AND FECHA = ?;";

        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setInt(1, idCuentaConductor);
            ps.setString(2, fechaViaje);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return -1;
        } catch (SQLException e) {
            return -1;
        }
    }

    private int obtenerIDCuenta(Cuenta cuentaPasajero) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        ConexionMySQL con = new ConexionMySQL();
        Connection conexion = con.conectar();

        String sql = "SELECT IDCUENTA FROM CUENTA WHERE CORREO = ?;";

        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setString(1, cuentaPasajero.getCorreo());
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return -2;
        } catch (SQLException e) {
            return -2;
        }
    }

    public boolean verificarTipoDePagoEnEfectivo(Reservacion reservacion) {
        Viaje viaje = reservacion.getViaje();
        Cuenta cuentaConductor = reservacion.getViaje().getCuenta();
        Cuenta cuentaPasajero = reservacion.getCuenta();

        int idCuentaPasajero = obtenerIDCuenta(cuentaPasajero);
        int idViaje = obtenerIDViaje(cuentaConductor, viaje);

        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionMySQL con = new ConexionMySQL();
        Connection conexion = con.conectar();
        String sql = "SELECT count(*) FROM "
                + "RESERVACION R JOIN FACTURA F "
                + "ON R.IDRESERVACION = F.IDRESERVACION "
                + "JOIN PAGO PAGO "
                + "ON F.IDFACTURA = PAGO.IDFACTURA "
                + "WHERE PAGO.TIPOPAGO = 'efectivo' "
                + "AND R.IDVIAJE = ? AND R.IDCUENTA = ?;";

        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setInt(1, idViaje); //IDVIAJE
            ps.setInt(2, idCuentaPasajero); // IDCUENTA
            rs = ps.executeQuery();
            rs.next();
            if (rs.getInt(1) == 0) {
                return false;
            }
            System.out.println("Si");
            return true;
        } catch (SQLException e) {
            System.out.println("1");
            return false;
        }

    }

    public HashMap<Integer,Reservacion> obtenerReservaciones(HashMap<Integer,Viaje> viajes, HashMap<Integer,Cuenta> cuentas) {
        HashMap<Integer,Reservacion> reservaciones = new HashMap<Integer,Reservacion>();

        ResultSet rs = null;
        com.mysql.jdbc.PreparedStatement ps = null;
        ConexionMySQL con = new ConexionMySQL();
        java.sql.Connection conexion = con.conectar();

        String sql = "select * from reservacion";
        try {
            ps = (com.mysql.jdbc.PreparedStatement) conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                Pasajero cuentaTemp = (Pasajero) cuentas.get(rs.getInt(3));

                Reservacion reservacion = new Reservacion(viajes.get(rs.getInt(2)), cuentaTemp, rs.getInt(5));

                reservaciones.put(rs.getInt(1),reservacion);

                cuentaTemp.crearReservacion(reservacion);
            }
            System.out.println("Instanciación de Reservaciones");
            return reservaciones;
        } catch (SQLException e) {
            return null;
        }
    }

}
