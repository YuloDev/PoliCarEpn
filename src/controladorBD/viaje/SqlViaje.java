package controladorBD.viaje;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import controladorBD.conexion.ConexionMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import modelo.externo.Fecha;
import modelo.usuarios.Conductor;
import modelo.usuarios.Cuenta;
import modelo.usuarios.Usuario;
import modelo.viaje.Asiento;
import modelo.viaje.Viaje;
import static vistas.usuarios.JFLogin.viajes;

public class SqlViaje extends ConexionMySQL {

    ArrayList lista = new ArrayList();

    public boolean registrarViaje(Viaje nuevoViaje, int numeroDeAsientos, double precioAsiento, String fecha) {
        
        int idCuenta = obtenerIDCuentaConductor(nuevoViaje.getCuenta());
        
        PreparedStatement ps = null;
        Connection con = conectar();
        String sql = "INSERT INTO VIAJE (idcuenta, numerodeasientos, precioporasiento, ubicacionpartida, ubicaciondestino, fecha) "
                + " VALUES (?,?,?,?,?,?);";
        try {
            ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(sql);
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, idCuenta);
            ps.setInt(2, numeroDeAsientos);
            ps.setDouble(3, precioAsiento);
            ps.setString(4, nuevoViaje.getUbicacionPartida());
            ps.setString(5, nuevoViaje.getUbicacionDestino());
            ps.setString(6, fecha);
            ps.execute();
            System.out.println("bandera");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    private int obtenerIDCuentaConductor(Cuenta cuentaConductor) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        ConexionMySQL con = new ConexionMySQL();
        java.sql.Connection conexion = con.conectar();

        String sql = "SELECT IDCUENTA FROM CUENTA WHERE CORREO = ? AND TIPOCUENTA = \"Conductor\"";

        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setString(1, cuentaConductor.getCorreo());
            rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("bandera1");
                return rs.getInt(1);
            }
            return -2;
        } catch (SQLException e) {
            return -2;
        }
    }
    
    public void consultarViajes() throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        java.sql.Connection con = conectar();

        String sql = "SELECT UBICACIONPARTIDA, UBICACIONDESTINO, FECHA FROM VIAJE; ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String[] viaje = {rs.getString(1), rs.getString(2), rs.getString(3)};
                this.lista.add(viaje);
            }
            //return rs.getFloat(1);
        } catch (SQLException e) {
            //return 0.0f;
        }
    }

    public void instanciarViajes(Conductor conductor) {
        ResultSet rs = null;
        com.mysql.jdbc.PreparedStatement ps = null;
        ConexionMySQL con = new ConexionMySQL();
        Connection conexion = con.conectar();

        String sql = "SELECT UBICACIONPARTIDA, UBICACIONDESTINO, NUMERODEASIENTOS, PRECIOPORASIENTO, FECHA "
                + "FROM VIAJE VI JOIN CUENTA CU ON VI.IDCUENTA=CU.IDCUENTA "
                + "WHERE CORREO = ?;";
        try {
            ps = (com.mysql.jdbc.PreparedStatement) conexion.prepareStatement(sql);
            ps.setString(1, conductor.getCorreo());
            rs = ps.executeQuery();
            while (rs.next()) {
                String cadenaFecha = rs.getString(5).substring(0, 19);
                Viaje nuevoViaje = new Viaje(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), conductor, new Fecha(cadenaFecha));
                conductor.crearViaje(nuevoViaje);
            }
            System.out.println("Viajes instanciados");
        } catch (SQLException e) {
            System.out.println("fallo viajes");
        }
    }

    /*
    public HashMap<Integer, Viaje> consultarTodosLosViajes() {
        ResultSet rs = null;
        com.mysql.jdbc.PreparedStatement ps = null;
        ConexionMySQL con = new ConexionMySQL();
        Connection conexion = con.conectar();

        String sql = "SELECT UBICACIONPARTIDA, UBICACIONDESTINO, NUMERODEASIENTOS, PRECIOPORASIENTO, FECHA "
                + "FROM VIAJE VI JOIN CUENTA CU ON VI.IDCUENTA=CU.IDCUENTA "
                + "WHERE CORREO = ?;";
        try {
            ps = (com.mysql.jdbc.PreparedStatement) conexion.prepareStatement(sql);
            ps.setString(1, conductor.getCorreo());
            rs = ps.executeQuery();
            while (rs.next()) {
                String cadenaFecha = rs.getString(5).substring(0, 19);
                Viaje nuevoViaje = new Viaje(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), conductor, new Fecha(cadenaFecha));
                conductor.crearViaje(nuevoViaje);
            }
            System.out.println("Viajes instanciados");
        } catch (SQLException e) {
            System.out.println("fallo viajes");
        }
    }*/

    public HashMap<Integer,Viaje> obtenerViajes(HashMap<Integer,Cuenta> cuentas) {
        HashMap<Integer,Viaje> viajes = new HashMap<Integer,Viaje>();

        ResultSet rs = null;
        com.mysql.jdbc.PreparedStatement ps = null;
        ConexionMySQL con = new ConexionMySQL();
        java.sql.Connection conexion = con.conectar();

        String sql = "select * from viaje";
        try {
            ps = (com.mysql.jdbc.PreparedStatement) conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Conductor cuentaTemp = (Conductor) cuentas.get(rs.getInt(2));
                
                Fecha fechaTemp = new Fecha(rs.getString(7).substring(0, 19));
                
                Viaje viaje = new Viaje(rs.getString(5), rs.getString(6), rs.getInt(3), rs.getDouble(4), cuentaTemp, fechaTemp);
                
                viajes.put(rs.getInt(1), viaje);

                cuentaTemp.crearViaje(viaje);
            }
            System.out.println("Instanciación de Viajes");
            return viajes;
        } catch (SQLException e) {
            return null;
        }
        
    }

}
