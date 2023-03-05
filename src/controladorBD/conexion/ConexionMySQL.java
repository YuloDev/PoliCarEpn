/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorBD.conexion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnitaGabriela
 */
public class ConexionMySQL {

    String baseDatos = "bdpolicarepn";
    String usuario = "root";
    String clave = "1234";
    String url = "jdbc:mysql://localhost:3306/";
    String driver = "com.mysql.jdbc.Driver";
    Connection cn;

    public Connection conectar() {

        try {
            Class.forName(driver);
            cn = (Connection) DriverManager.getConnection(url + baseDatos + "?user=" + usuario + "&password=" + clave + "&useSSL=false");
            System.out.println("Conectado");
        } catch (SQLException ex) {
            System.out.println("Error de conexión");
            //Logger.getLogger(ConexionMySQL.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cn;

    }
}