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
    /*
    
        public boolean registrarUsuario(Usuario usr, Cuenta cuenta ){
        PreparedStatement ps = null;
         Connection con = conectar();
         
         String sql = "INSERT INTO usuario (codigounico, nombre, apellido,telefono) VALUES (?,?,?,?);";
         String sql2 = "INSERT INTO cuenta (codigounico, correo, contrasenia, tipocuenta) VALUES (?,?,?,?);";
         
        try {
            ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(sql);
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, usr.);
            ps.setString(2, usr.getNombreDeUsuario());
            ps.setString(3, usr.getClaveDeUsuario());
            ps.setString(4, usr.getTipoDeUsuario());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
   
    }*/
     

}
