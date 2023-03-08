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
import modelo.viaje.Viaje;

public class SqlViaje extends ConexionMySQL {

    ArrayList lista = new ArrayList();

    public void registrarViaje() throws SQLException {
        //obtener idCuenta del conductor
        //puntuacion quemada
        //obtener partida
        //obtener destino
        //obtener fecha - cambiar la forma de registrar la fecha
        PreparedStatement ps = null;
        Connection con = conectar();
        String sql = "INSERT INTO VIAJE (IDCUENTA,PUNTUACION,UBICACIONPARTIDA,UBICACIONDESTINO, FECHA) VALUES (?,?,?,?,?);";
        try {
            ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(sql);
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, 123);
            ps.setFloat(2, (float) 5.4);
            ps.setString(3, "partida");
            ps.setString(4, "destino");
            ps.setString(5, "'yyyy-mm-dd hh:mm:ss'");
            ps.execute();
            con.close();
            //return true;
        } catch (SQLException ex) {
            con.close();
            //return false;
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
