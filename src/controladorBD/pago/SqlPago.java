/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorBD.pago;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import controladorBD.conexion.ConexionMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.pago.Factura;

/**
 *
 * @author Kevin
 */
public class SqlPago extends ConexionMySQL{
    
     public boolean registrarFactura(Factura factura) throws SQLException{
        PreparedStatement ps = null;
        Connection con = conectar();
        String sql = "INSERT INTO Factura (IDRESERVACION,VALORTOTAL,VALORIVA,VALORSERVICIO) VALUES (?,?,?,?);"; 
        factura.calcularTotal();
        try {
            ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(sql);
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, obtenerUltimaR());
            ps.setString(2, factura.valorTotal+"");
            ps.setString(3, factura.valorIva+"");
            ps.setString(4, factura.valorServicio+"");
            ps.execute();
            con.close();
            return true;
        } catch (SQLException ex) {
            con.close();
            return false;
        }
    }
     
    public int obtenerUltimaR(){
        String idReservacion;
        PreparedStatement ps = null;
        ResultSet rs = null;
        java.sql.Connection con = conectar();

        String sql = "SELECT IDRESERVACION FROM RESERVACION ORDER BY IDRESERVACION DESC; ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            return -1;
        }
    }
    
    public Float obtenerSaldo(){
        String idReservacion;
        PreparedStatement ps = null;
        ResultSet rs = null;
        java.sql.Connection con = conectar();

        String sql = "SELECT SALDO FROM BILLETERAPOLICAR ORDER BY SALDO DESC; ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            System.out.println(rs.getFloat(1));
            return rs.getFloat(1);
        } catch (SQLException e) {
            return 0.0f;
        }
    }
    
    public int obtenerUltimaF(){
        String idReservacion;
        PreparedStatement ps = null;
        ResultSet rs = null;
        java.sql.Connection con = conectar();

        String sql = "SELECT IDFACTURA FROM FACTURA ORDER BY IDFACTURA DESC; ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            return -1;
        }
    }
    
    public boolean insertarSaldo(float saldo) throws SQLException{
        PreparedStatement ps = null;
        Connection con = conectar();
        System.out.println(saldo);
        String sql = "INSERT INTO BILLETERAPOLICAR (SALDO) VALUES (?);"; 
        try {
            ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(sql);
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setFloat(1, saldo);
            ps.execute();
            con.close();
            return true;
        } catch (SQLException ex) {
            con.close();
            System.err.println(ex);
            return false;
        }
    }
    
    public boolean insertarPago(Factura factura, String tipoPago) throws SQLException{
        PreparedStatement ps = null;
        Connection con = conectar();
        factura.calcularTotal();
        String sql = "INSERT INTO PAGO (IDFACTURA,VALORTOTAL,TIPOPAGO) VALUES (?,?,?);"; 
        try {
            ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(sql);
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, obtenerUltimaF());
            ps.setFloat(2, (float)factura.valorTotal);
            ps.setString(3, tipoPago);
            ps.execute();
            con.close();
            return true;
        } catch (SQLException ex) {
            con.close();
            System.err.println(ex);
            return false;
        }
    }
    
}
