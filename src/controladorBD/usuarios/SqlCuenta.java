/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorBD.usuarios;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.usuarios.Cuenta;
/**
 *
 * @author Lenovo
 */
public class SqlCuenta extends controladorBD.conexion.ConexionMySQL{
    
    public boolean login(String correo, String contrasenia) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conectar();

        String sql = "SELECT * FROM cuenta WHERE correo=? and contrasenia=?;";
        try {
            ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, contrasenia);
            rs = ps.executeQuery();

            if (rs.next()) {
                if (correo.equals(rs.getString(4)) && contrasenia.equals(rs.getString(5))) {
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
    
}
