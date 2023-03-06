package controladorBD.ranking;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import controladorBD.conexion.ConexionMySQL;
import java.sql.ResultSet;
import java.sql.Timestamp;
import modelo.ranking.Calificacion;
import modelo.ranking.Evaluacion;

public class SqlCalificacion {

    private Calificacion calificacion;

    public SqlCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }
    
    //solo para prueba, borrar despues
    public SqlCalificacion(){}

    public boolean ingresarCalificacion(int idViaje, int tipoCaificacion) {
        PreparedStatement ps = null;

        Connection cn = new ConexionMySQL().conectar();
        String sql = "insert into calificacion (idviaje, idcuenta, puntuacion, fecha, tipocalificacion) values (?, (select idcuenta from cuenta where codigounico = ?),?,?,?);";
        try {
            ps = (PreparedStatement) cn.prepareStatement(sql);
            ps.setInt(1, idViaje);
            ps.setInt(2, this.calificacion.getViaje().getCuenta().getUsuario().getCodUnico());
            ps.setInt(3, this.calificacion.getPuntaje());
            ps.setTimestamp(4, Timestamp.valueOf(calificacion.getFecha().determinarTiempoActual()));
            ps.setInt(5, tipoCaificacion);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Evaluacion seleccionarCalificacion(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        calificacion = new Calificacion();
        Evaluacion evaluacion = new Evaluacion();
        Connection con = new ConexionMySQL().conectar();
        String sql = "select puntuacion from calificacion where idcuenta = (select idcuenta from cuenta where codigounico = ?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, this.calificacion.getViaje().getCuenta().getUsuario().getCodUnico());
            rs = ps.executeQuery();
            while (rs.next()) {                
                calificacion.ingresar(rs.getInt("puntuacion")); //revisar si no da problema, sino crear nuevo objeto
                evaluacion.añadirCalificacion(calificacion);
            }
            return evaluacion;
        } catch (SQLException e) {
            return evaluacion;
        }
    }
    
    //solo para prueba, borrar despues
    public Evaluacion seleccionarCalificacion(int codUnico){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Evaluacion evaluacion = new Evaluacion();
        Connection con = new ConexionMySQL().conectar();
        String sql = "select puntuacion from calificacion where idcuenta = (select idcuenta from cuenta where codigounico = ?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, codUnico);
            rs = ps.executeQuery();
            while (rs.next()) {                
                //calificacion.ingresar(rs.getInt("puntuacion"));
                Calificacion c = new Calificacion();
                c.ingresar(rs.getInt("puntuacion"));
                evaluacion.añadirCalificacion(c);
            }
            return evaluacion;
        } catch (SQLException e) {
            e.printStackTrace();
            return evaluacion;
        }
    }
}
