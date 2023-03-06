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
import modelo.usuarios.Vehiculo;

/**
 *
 * @author Lenovo
 */
public class SqlVehiculo extends controladorBD.conexion.ConexionMySQL{
    
        public boolean registrarVehiculo(Vehiculo vehiculo){
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
    
}
