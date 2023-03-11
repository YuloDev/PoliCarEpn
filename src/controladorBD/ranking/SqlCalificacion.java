package controladorBD.ranking;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import controladorBD.conexion.ConexionMySQL;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import modelo.ranking.Calificacion;
import modelo.ranking.Evaluacion;

public class SqlCalificacion {

    private Calificacion calificacion;

    public SqlCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }
    
    //solo para prueba, borrar despues
    public SqlCalificacion(){}

    public boolean ingresarCalificacion(int tipoCaificacion) {
        PreparedStatement ps = null;
        Connection cn = new ConexionMySQL().conectar();
        String sql = "insert into calificacion (idviaje, idcuenta, puntuacion, fecha, tipocalificacion) values (?, (select idcuenta from cuenta where codigounico = ?),?,?,?);";
        try {
            ps = (PreparedStatement) cn.prepareStatement(sql);
            ps.setInt(1, obtenerIDViaje());
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
        Evaluacion evaluacion = new Evaluacion();
        Connection con = new ConexionMySQL().conectar();
        String sql = "select puntuacion from calificacion where idcuenta = (select idcuenta from cuenta where codigounico = ?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, this.calificacion.getViaje().getCuenta().getUsuario().getCodUnico());
            rs = ps.executeQuery();
            while (rs.next()) {
                Calificacion cal = new Calificacion();
                cal.ingresar(rs.getInt("puntuacion")); //revisar si no da problema, sino crear nuevo objeto
                evaluacion.añadirCalificacion(cal);
            }
            return evaluacion;
        } catch (SQLException e) {
            return evaluacion;
        }
    }
    
    private int obtenerIDViaje() {

        int idCuentaConductor = this.calificacion.getViaje().getCuenta().getUsuario().getCodUnico();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaViaje = this.calificacion.getViaje().getFecha().getFechaYHora().format(formatter);

        ResultSet rs = null;
        PreparedStatement ps = null;
        ConexionMySQL con = new ConexionMySQL();
        Connection conexion = con.conectar();

        String sql = "SELECT IDVIAJE FROM VIAJE WHERE IDCUENTA = (select idcuenta from cuenta where codigounico = ?) AND FECHA = ?;";

        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setInt(1, idCuentaConductor);
            ps.setString(2, fechaViaje); //cambiar por fecha
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return -1;
        } catch (SQLException e) {
            return -1;
        }
    }
    
    
}
