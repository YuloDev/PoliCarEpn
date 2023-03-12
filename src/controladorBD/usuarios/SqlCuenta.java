/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorBD.usuarios;

import controladorBD.conexion.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import modelo.usuarios.Conductor;
import modelo.usuarios.Cuenta;
import modelo.usuarios.Pasajero;
import modelo.usuarios.Usuario;
import modelo.usuarios.Vehiculo;

/**
 *
 * @author Lenovo
 */
public class SqlCuenta extends controladorBD.conexion.ConexionMySQL {

    public boolean iniciarSesion(String correo, String contrasenia, String tipoCuenta) {
        //metodo para iniciar sesion
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conectar();

        String sql = "SELECT * FROM cuenta WHERE correo=? and contrasenia=? and tipocuenta=?;";
        try {
            ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, contrasenia);
            ps.setString(3, tipoCuenta);
            rs = ps.executeQuery();

            if (rs.next()) {
                if (correo.equals(rs.getString(4)) && contrasenia.equals(rs.getString(5)) && tipoCuenta.equals(rs.getString(6))) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        } catch (SQLException e) {
            return false;
        }
    }

    public String verificarCuenta(String correo, String contrasenia) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conectar();
        String tipoCuenta = "";

        String sql = "SELECT tipocuenta FROM cuenta WHERE correo=?";
        try {
            ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, correo);
            rs = ps.executeQuery();
            while (rs.next()) {
                tipoCuenta = rs.getString("tipocuenta");
            }
        } catch (SQLException e) {

        }

        return tipoCuenta;
    }

    public HashMap<Integer,Cuenta> obtenerCuentas(HashMap<Integer,Usuario> usuarios, HashMap<String,Vehiculo> vehiculos) {
        HashMap<Integer,Cuenta> cuentas = new HashMap<Integer,Cuenta>();

        ResultSet rs = null;
        com.mysql.jdbc.PreparedStatement ps = null;
        ConexionMySQL con = new ConexionMySQL();
        Connection conexion = con.conectar();

        String sql = "select * from cuenta";
        try {
            ps = (com.mysql.jdbc.PreparedStatement) conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                Usuario usuarioTemp = usuarios.get(rs.getInt(3));
                
                if (rs.getString(6).equals("Conductor")) {
                    Vehiculo vehiculoTemp = vehiculos.get(rs.getString(2));
                    cuentas.put(rs.getInt(1), new Conductor(rs.getString(4), rs.getString(5), usuarioTemp, vehiculoTemp));
                } else {
                    cuentas.put(rs.getInt(1), new Pasajero(rs.getString(4), rs.getString(5), usuarioTemp, rs.getDouble(7)));
                }
            }
            System.out.println("Instanciación de Cuentas");
            return cuentas;
        } catch (SQLException e) {
            return null;
        }
    }
}
