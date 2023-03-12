/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorBD.ranking;

import com.mysql.jdbc.PreparedStatement;
import controladorBD.conexion.ConexionMySQL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import modelo.externo.Fecha;
import modelo.usuarios.Cuenta;
import modelo.viaje.Viaje;
import static vistas.usuarios.JFLogin.cuentas;
import static vistas.usuarios.JFLogin.viajes;

/**
 *
 * @author Cesar
 */
public class SqlPenalizacion {

    public void registrarPenalizacion(Cuenta cuenta, Fecha fecha) {
        
        int idCuenta = 0;
        for (int id : cuentas.keySet()) {
            Cuenta cuentaConductor = cuentas.get(id);
            if (cuentaConductor .equals(cuenta)) {
                idCuenta = id;
            }
        }
        
        DateTimeFormatter formatterLS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        PreparedStatement ps = null;
        Connection cn = new ConexionMySQL().conectar();
        String sql = "UPDATE CUENTA SET FECHAPENALIZACION = ? WHERE IDCUENTA = ?;";
        try {
            ps = (PreparedStatement) cn.prepareStatement(sql);
            ps.setString(1, fecha.getFechaYHora().format(formatterLS));
            ps.setInt(2, idCuenta);
            ps.execute();
            System.out.println("Penalización actualizada");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
