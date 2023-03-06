/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorBD.usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.usuarios.Cuenta;
import modelo.usuarios.Usuario;

/**
 *
 * @author Cesar
 */
public class SqlUsuario extends controladorBD.conexion.ConexionMySQL {
    
    
        public boolean registrarUsuario(Usuario usr, Cuenta cuenta , String tipoCuenta){
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        Connection con = conectar();
         
         String sql = "INSERT INTO usuario (codigounico, nombre, apellido,telefono) VALUES (?,?,?,?);";
         String sql2 = "INSERT INTO cuenta (codigounico, correo, contrasenia, tipocuenta) VALUES (?,?,?,?);";
         
        try {
            ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(sql);
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps2 = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(sql2);
            ps2 = (PreparedStatement) con.prepareStatement(sql2);
            ps.setInt(1, usr.getCodUnico());
            ps.setString(2, usr.getNombre());
            ps.setString(3, usr.getApellido());
            ps.setString(4, usr.getTelefono());
           
            ps2.setInt(1, usr.getCodUnico());
            ps2.setString(2, cuenta.getCorreo());
            ps2.setString(3, cuenta.getContraseña());
            ps2.setString(4, tipoCuenta);

            ps.execute();
            ps2.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
   
    }
     

}
