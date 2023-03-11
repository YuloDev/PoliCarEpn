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
import modelo.viaje.Asiento;
import modelo.viaje.Viaje;
import static vistas.usuarios.JFLogin.viajes;

/**
 *
 * @author Cesar
 */
public class SqlReservacion {

    public boolean registrarReservacion(Reservacion reservacion) {
        Cuenta cuentaPasajero = reservacion.getCuenta();

        int idCuentaPasajero = obtenerIDCuenta(cuentaPasajero);

        int idViaje = 0;
        for (int id : viajes.keySet()) {
            Viaje viaje = viajes.get(id);
            if (viaje.equals(reservacion.getViaje())) {
                idViaje = id;
            }
        }
        int numeroDeAsientos = 0;
        for (Asiento asiento : reservacion.getListaDeAsientos()) {
            if (asiento != null) {
                numeroDeAsientos++;
            }
        }

        PreparedStatement ps = null;
        ConexionMySQL con = new ConexionMySQL();
        Connection conexion = con.conectar();
        String sql = "INSERT INTO RESERVACION (idviaje, idcuenta, valor, numerodeasientos) "
                + "VALUES (?,?,?,?);";
        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setInt(1, idViaje); //IDVIAJE
            ps.setInt(2, idCuentaPasajero); // IDCUENTA
            ps.setDouble(3, reservacion.getPrecio()); // VALOR
            ps.setInt(4, numeroDeAsientos);
            ps.execute();
            ocuparAsientos(idViaje, numeroDeAsientos);
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    private void ocuparAsientos(int idViaje, int numeroDeAsientos) {

        ResultSet rs = null;
        PreparedStatement ps = null;
        ConexionMySQL con = new ConexionMySQL();
        Connection conexion = con.conectar();
        String sql = "SELECT IDASIENTO FROM ASIENTO WHERE IDVIAJE = ? AND ESTADO = 0";
        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setInt(1, idViaje); //IDVIAJE
            rs = ps.executeQuery();
            while (numeroDeAsientos > 0) {
                if (rs.next()) {
                    System.out.println(rs.getInt(1));
                    cambiarEstadoDeAsiento(rs.getInt(1), 1);
                }
                numeroDeAsientos--;
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private void cambiarEstadoDeAsiento(int idAsiento, int estado) {

        PreparedStatement ps = null;
        ConexionMySQL con = new ConexionMySQL();
        Connection conexion = con.conectar();
        String sql = "UPDATE ASIENTO SET ESTADO = ? WHERE IDASIENTO = ?";
        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setInt(1, estado);
            ps.setInt(2, idAsiento);
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
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
            System.out.println(e.toString());
            return -1;
        }
    }

    private int obtenerIDCuenta(Cuenta cuentaPasajero) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        ConexionMySQL con = new ConexionMySQL();
        Connection conexion = con.conectar();

        String sql = "SELECT IDCUENTA FROM CUENTA WHERE CORREO = ? AND TIPOCUENTA = 'Pasajero';";

        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setString(1, cuentaPasajero.getCorreo());
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return -2;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return -2;
        }
    }

    public boolean verificarTipoDePagoEnEfectivo(Reservacion reservacion) {
        Cuenta cuentaPasajero = reservacion.getCuenta();

        int idCuentaPasajero = obtenerIDCuenta(cuentaPasajero);
        
        int idViaje = 0;
        for (int id : viajes.keySet()) {
            Viaje viaje = viajes.get(id);
            if (viaje.equals(reservacion.getViaje())) {
                idViaje = id;
            }
        }

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

    public HashMap<Integer, Reservacion> obtenerReservaciones(HashMap<Integer, Viaje> viajes, HashMap<Integer, Cuenta> cuentas) {
        HashMap<Integer, Reservacion> reservaciones = new HashMap<Integer, Reservacion>();

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

                reservaciones.put(rs.getInt(1), reservacion);

                cuentaTemp.crearReservacion(reservacion);
            }
            System.out.println("Instanciación de Reservaciones");
            return reservaciones;
        } catch (SQLException e) {
            return null;
        }
    }

}
