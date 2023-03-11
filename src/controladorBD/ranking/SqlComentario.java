package controladorBD.ranking;

import controladorBD.conexion.ConexionMySQL;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.ranking.Comentario;

public class SqlComentario {

    public boolean registrarComentario(Comentario co) {
        PreparedStatement ps = null;
        Connection con = new ConexionMySQL().conectar();
        String sql = "INSERT INTO comentario (idcalificacion, contenido) VALUES ((select max(idcalificacion) from calificacion), ? );";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, co.getContenido());
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String [] mostrarComentarios(int codUnico) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String [] comentarios = new String[3];
        int i=0;
        Connection con = new ConexionMySQL().conectar();
        String sql = "SELECT cu.contenido FROM comentario as cu join calificacion as ca on cu.idcalificacion = ca.idcalificacion WHERE idcuenta = (select idcuenta from cuenta where codigounico = ?) ORDER BY idcomentario DESC LIMIT 3 ;";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, codUnico);
            rs = ps.executeQuery();
            while (rs.next()) {                
                comentarios[i] = rs.getString("cu.contenido");
                i++;
            }
            return comentarios;
        } catch (SQLException e) {
            return comentarios;
        }
    }
}
