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
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.usuarios.Cuenta;
import modelo.usuarios.Usuario;
import modelo.usuarios.Vehiculo;

/**
 *
 * @author Lenovo
 */
public class SqlVehiculo extends controladorBD.conexion.ConexionMySQL {

    public boolean registrarVehiculo(Vehiculo vehiculo) {
        PreparedStatement ps = null;
        Connection con = conectar();
        String sql = "INSERT INTO vehiculo (placa, modelo, color, anio, numeroasientos) VALUES (?,?,?,?,?);";

        try {
            ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(sql);
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, vehiculo.getPlaca());
            ps.setString(2, vehiculo.getModelo());
            ps.setString(3, vehiculo.getColor());
            ps.setInt(4, vehiculo.getAño());
            ps.setInt(5, vehiculo.getNumeroAsientos());

            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public Vehiculo obtenerVehiculo(String correo) {
        Vehiculo vehiculo = null;

        ResultSet rs = null;
        com.mysql.jdbc.PreparedStatement ps = null;
        ConexionMySQL con = new ConexionMySQL();
        Connection conexion = con.conectar();

        String sql = "select ve.placa, modelo, color, anio, numeroasientos "
                + "from vehiculo ve join cuenta cu on ve.placa= cu.placa "
                + "where correo = ?;";
        try {
            ps = (com.mysql.jdbc.PreparedStatement) conexion.prepareStatement(sql);
            ps.setString(1, correo);
            rs = ps.executeQuery();
            if (rs.next()) {
                vehiculo = new Vehiculo(rs.getString(0),rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
                System.out.println("Vehiculo instanciado");
                return vehiculo;
            }
            return null;
        } catch (SQLException e) {
            return null;
        }
    }

    public HashMap<String,Vehiculo> obtenerVehiculos() {
        HashMap<String,Vehiculo> vehiculos = new HashMap<String,Vehiculo>();
        
        ResultSet rs = null;
        com.mysql.jdbc.PreparedStatement ps = null;
        ConexionMySQL con = new ConexionMySQL();
        Connection conexion = con.conectar();

        String sql = "select * from vehiculo";
        try {
            ps = (com.mysql.jdbc.PreparedStatement) conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                vehiculos.put(rs.getString(1),new Vehiculo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5)));
            }
            System.out.println("Instanciación de Vehiculos");
            return vehiculos;
        } catch (SQLException e) {
            return null;
        }
    }

}
