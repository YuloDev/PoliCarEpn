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
    
        public boolean registrarUsuario(Usuario usr){
            PreparedStatement ps = null;
            Connection con = conectar();

             String sql = "INSERT INTO usuario (codigounico, nombre, apellido, telefono) VALUES (?,?,?,?);";
            try{
                ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(sql);
                ps = (PreparedStatement) con.prepareStatement(sql);  
                
                ps.setInt(1, usr.getCodUnico());
                ps.setString(2, usr.getNombre());
                ps.setString(3, usr.getApellido());
                ps.setString(4, usr.getTelefono());
                ps.execute();
                return true;
            }catch(SQLException ex){
                Logger.getLogger(SqlUsuario.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }       
        }
        
        public boolean registrarPasajero(Usuario usr, Cuenta cuenta , String tipoCuenta){
        PreparedStatement ps = null;        
        Connection con = conectar();
         
         String sql = "INSERT INTO cuenta (codigounico, correo, contrasenia, tipocuenta) VALUES (?,?,?,?);";         
         
        try {
            ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(sql);
            ps = (PreparedStatement) con.prepareStatement(sql);           
            
           
            ps.setInt(1, usr.getCodUnico());
            ps.setString(2, cuenta.getCorreo());
            ps.setString(3, cuenta.getContraseña());
            ps.setString(4, tipoCuenta);

            ps.execute();            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
            }
        }
        
        public boolean registrarConductor(Usuario usr, Cuenta cuenta , String tipoCuenta, String placa){
            PreparedStatement ps = null;            
            Connection con = conectar();            
            String sql = "INSERT INTO cuenta (placa, codigounico, correo, contrasenia, tipocuenta) VALUES (?,?,?,?,?);";            
            try {
                ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(sql);
                ps = (PreparedStatement) con.prepareStatement(sql);             

                ps.setString(1, placa);
                ps.setInt(2, usr.getCodUnico());
                ps.setString(3, cuenta.getCorreo());
                ps.setString(4, cuenta.getContraseña());
                ps.setString(5, tipoCuenta);

                ps.execute();                
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(SqlUsuario.class.getName()).log(Level.SEVERE, null, ex);
                return false;
                }
            }
   
    }
     

    