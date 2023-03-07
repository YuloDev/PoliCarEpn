package controladorBD.viaje;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import controladorBD.conexion.ConexionMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

        String sql = "SELECT UBICACIONPARTIDA, UBICACIONDESTINO,FECHA FROM VIAJE; ";
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

}
