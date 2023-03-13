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
import modelo.reservacion.Reservacion;
import modelo.usuarios.Cuenta;
import modelo.viaje.Viaje;
import static vistas.usuarios.JFLogin.reservaciones;

/**
 *
 * @author Cesar
 */
public class SqlTiempoDeReserva {

    public String obtenerFechaFin(Reservacion reservacion) {

        Cuenta cuentaPasajero = reservacion.getCuenta();

        int idCuentaPasajero = obtenerIDCuenta(cuentaPasajero);
        double valorReservacion = reservacion.getPrecio();

        ResultSet rs = null;
        PreparedStatement ps = null;
        ConexionMySQL con = new ConexionMySQL();
        Connection conexion = con.conectar();

        String sql = "select fechafin from fechadecancelacion where idreservacion = "
                + "(select idreservacion from reservacion re join cuenta cu "
                + "on re.idcuenta = cu.idcuenta where cu.idcuenta = ? and re.valor = ?);";

        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setInt(1, idCuentaPasajero);
            ps.setDouble(2, valorReservacion);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
            return null;
        } catch (SQLException e) {
            return null;
        }
    }

    public boolean EliminarFechaFin(Reservacion reservacion) {
        Cuenta cuentaPasajero = reservacion.getCuenta();

        int idCuentaPasajero = obtenerIDCuenta(cuentaPasajero);
        double valorReservacion = reservacion.getPrecio();

        PreparedStatement ps = null;
        ConexionMySQL con = new ConexionMySQL();
        Connection conexion = con.conectar();

        String sql = "delete from fechadecancelacion where idreservacion = "
                + "(select  idreservacion from reservacion re join cuenta cu "
                + "on re.idcuenta = cu.idcuenta where cu.idcuenta = ? and re.valor = ?);";
        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setInt(1, idCuentaPasajero);
            ps.setDouble(2, valorReservacion);
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }

        return true;
    }

    private int obtenerIDCuenta(Cuenta cuentaPasajero) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        ConexionMySQL con = new ConexionMySQL();
        Connection conexion = con.conectar();

        String sql = "SELECT IDCUENTA FROM CUENTA WHERE CORREO = ?";
        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setString(1, cuentaPasajero.getCorreo());
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.toString());
            return 0;
        }
    }

    public boolean registrarTiempoDeReserva(Reservacion reservacionActual) {

        int idReservacion = 0;
        for (int id : reservaciones.keySet()) {
            idReservacion = id;
        }
        idReservacion++;
        PreparedStatement ps = null;
        ConexionMySQL con = new ConexionMySQL();
        Connection conexion = con.conectar();

        String sql = "insert into fechadecancelacion (idreservacion, fechafin) values (?,DATE_ADD(NOW(),INTERVAL 20 MINUTE));";
        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setInt(1, idReservacion);
            ps.execute();
            System.out.println("Tiempo registrado");
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("Tiempo no registrado");
            return false;
        }
    }

    public boolean eliminarTiempoDeReserva(Reservacion reservacionActual) {

        int idReservacion = -1;
        for (int id : reservaciones.keySet()) {
            Reservacion reservacion = reservaciones.get(id);
            if (reservacionActual.equals(reservacion)) {
                idReservacion = id;
            }
        }
        if (idReservacion == -1) {
            idReservacion = 0;
            for (int id : reservaciones.keySet()) {
                idReservacion = id;
            }
        }
        idReservacion++;

        PreparedStatement ps = null;
        ConexionMySQL con = new ConexionMySQL();
        Connection conexion = con.conectar();

        String sql = "delete from fechadecancelacion where idreservacion = ?;";
        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setInt(1, idReservacion);
            ps.execute();
            System.out.println("Tiempo eliminado");
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("Tiempo no eliminado");
            return false;
        }

    }

    public boolean actualizarTiempoDeReserva(Reservacion reservacionSeleccionada) {

        int idReservacion = 0;
        for (int id : reservaciones.keySet()) {
            Reservacion reservacion = reservaciones.get(id);
            if (reservacionSeleccionada.equals(reservacion)) {
                idReservacion = id;
            }
        }

        PreparedStatement ps = null;
        ConexionMySQL con = new ConexionMySQL();
        Connection conexion = con.conectar();

        String sql = "update fechadecancelacion set fechafin = NOW() where idreservacion = ?;";
        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setInt(1, idReservacion);
            ps.execute();
            System.out.println("Tiempo actualizado");
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("Tiempo no actualizado");
            return false;
        }

    }

}
