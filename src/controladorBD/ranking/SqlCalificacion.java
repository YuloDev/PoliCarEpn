package controladorBD.ranking;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import controladorBD.conexion.ConexionMySQL;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import modelo.externo.Fecha;
import modelo.ranking.Calificacion;
import modelo.ranking.CalificacionConductor;
import modelo.ranking.CalificacionExperiencia;
import modelo.ranking.CalificacionVehiculo;
import modelo.ranking.Evaluacion;
import modelo.reservacion.Reservacion;
import modelo.usuarios.Cuenta;
import modelo.viaje.Viaje;

public class SqlCalificacion {

    public boolean ingresarCalificacion(Calificacion calificacion, int tipoCaificacion) {
        PreparedStatement ps = null;
        Connection cn = new ConexionMySQL().conectar();
        String sql = "insert into calificacion (idviaje, idcuenta, puntuacion, fecha, tipocalificacion) values (?, (select idcuenta from cuenta where codigounico = ?),?,?,?);";
        try {
            ps = (PreparedStatement) cn.prepareStatement(sql);
            ps.setInt(1, obtenerIDViaje(calificacion));
            ps.setInt(2, calificacion.getViaje().getCuenta().getUsuario().getCodUnico());
            ps.setInt(3, calificacion.getPuntaje());
            ps.setTimestamp(4, Timestamp.valueOf(calificacion.getFecha().determinarTiempoActual()));
            ps.setInt(5, tipoCaificacion);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void actualizarEstadoCalificacion(Reservacion reservacion) {
        PreparedStatement ps = null;
        Connection con = new ConexionMySQL().conectar();
        String sql = "update reservacion set evaluado = 1 where idviaje = ? and idcuenta = (select idcuenta from cuenta where codigounico = ?);";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, obtenerIDViaje(new Calificacion(reservacion.getViaje())));
            ps.setInt(2, reservacion.getCuenta().getUsuario().getCodUnico());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean existeCalificacion(Reservacion reservacion) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new ConexionMySQL().conectar();
        String sql = "select evaluado from reservacion where idviaje = ? and idcuenta = (select idcuenta from cuenta where codigounico = ?);";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, obtenerIDViaje(new Calificacion(reservacion.getViaje())));
            ps.setInt(2, reservacion.getCuenta().getUsuario().getCodUnico());
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt("evaluado") == 0) {
                    return false;
                } else {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Evaluacion seleccionarCalificacion(int codigoUnico) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Evaluacion evaluacion = new Evaluacion();
        Connection con = new ConexionMySQL().conectar();
        String sql = "select puntuacion from calificacion where idcuenta = "
                + "(select idcuenta from cuenta "
                + "where codigounico = ? "
                + "and tipocuenta = 'Conductor');";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, codigoUnico);
            rs = ps.executeQuery();
            while (rs.next()) {
                Calificacion cal = new Calificacion();
                cal.ingresar(rs.getInt(1)); //revisar si no da problema, sino crear nuevo objeto
                evaluacion.añadirCalificacion(cal);
            }
            return evaluacion;
        } catch (SQLException e) {
            return evaluacion;
        }
    }

    private int obtenerIDViaje(Calificacion calificacion) {

        int idCuentaConductor = calificacion.getViaje().getCuenta().getUsuario().getCodUnico();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaViaje = calificacion.getViaje().getFecha().getFechaYHora().format(formatter);

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

    public void obtenerCalificación(HashMap<Integer, Viaje> viajes, HashMap<Integer, Cuenta> cuentas) {
        ResultSet rs = null;
        com.mysql.jdbc.PreparedStatement ps = null;
        ConexionMySQL con = new ConexionMySQL();
        Connection conexion = con.conectar();

        String sql = "select * from calificacion order by fecha asc, tipocalificacion asc;";
        try {
            ps = (com.mysql.jdbc.PreparedStatement) conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Calificacion calificacionTemp;
                switch (rs.getInt(6)) {
                    case 0:
                        calificacionTemp = new CalificacionConductor(viajes.get(rs.getInt(2)));
                        calificacionTemp.ingresar(rs.getInt(4));
                        break;
                    case 1:
                        calificacionTemp = new CalificacionVehiculo(viajes.get(rs.getInt(2)));
                        calificacionTemp.ingresar(rs.getInt(4));
                        break;
                    default:
                        calificacionTemp = new CalificacionExperiencia(viajes.get(rs.getInt(2)));
                        calificacionTemp.ingresar(rs.getInt(4));

                        obtenerComentario(rs.getInt(1), (CalificacionExperiencia) calificacionTemp);

                        break;
                }
                cuentas.get(rs.getInt(3)).getEvaluacion().añadirCalificacion(calificacionTemp);
            }
            System.out.println("Instanciación de Calificaciones");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void obtenerComentario(int idCalificacion, CalificacionExperiencia calificacionExperiencia) {
        ResultSet rs = null;
        com.mysql.jdbc.PreparedStatement ps = null;
        ConexionMySQL con = new ConexionMySQL();
        Connection conexion = con.conectar();
        System.out.println(idCalificacion);
        String sql = "select * from comentario where idCalificacion = " + idCalificacion;
        try {
            ps = (com.mysql.jdbc.PreparedStatement) conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                calificacionExperiencia.agregarComentario(rs.getString(3), rs.getString(4));
            }
            System.out.println("Instanciación de comentario");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void obtenerPenalizacion(HashMap<Integer, Cuenta> cuentas) {
        ResultSet rs = null;
        com.mysql.jdbc.PreparedStatement ps = null;
        ConexionMySQL con = new ConexionMySQL();
        Connection conexion = con.conectar();

        String sql = "select * from cuenta;";
        try {
            ps = (com.mysql.jdbc.PreparedStatement) conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(8) != null) {
                    Fecha fecha = new Fecha(rs.getString(8).substring(0, 19));
                    cuentas.get(rs.getInt(1)).getPenalizacion().setFecha(fecha);
                }
            }
            System.out.println("Instanciación de Penalización");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
