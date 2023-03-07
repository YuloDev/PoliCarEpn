/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas.reservacion;

import controladorBD.conexion.ConexionMySQL;
import controladorBD.reservacion.SqlTiempoDeReserva;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import modelo.externo.Fecha;
import modelo.pago.Factura;
import modelo.pago.Pago;
import modelo.pago.PagoTransferencia;
import modelo.reservacion.Reservacion;
import modelo.usuarios.Conductor;
import modelo.usuarios.Pasajero;
import modelo.usuarios.Usuario;
import modelo.usuarios.Vehiculo;
import modelo.viaje.Viaje;
import java.time.Duration;

/**
 *
 * @author Cesar
 */
public class jfmTestDeTemporizador extends javax.swing.JFrame {

    /**
     * Creates new form jfmVentana
     */
    public jfmTestDeTemporizador() {
        initComponents();
        setTitle("PoliCar4");
        setSize(817, 650);
        setResizable(false);
        this.setLocationRelativeTo(null);

        ConexionMySQL con = new ConexionMySQL();
        Connection conexion = con.conectar();

        pnlVentana.setLayout(new BorderLayout());

        /**
         * ******************Borrar*********************+
         */
        Usuario nuevoUsuario = new Usuario("Luis", "Narvaez", "0985381267", 201821107);
        Vehiculo vehiculo = new Vehiculo("PCM1478", "Kia rio", "negro", 2018, 5);
        Conductor cuentaConductor = null;
        if (vehiculo.validarAño()) {
            cuentaConductor = new Conductor("luis.narvaez@epn.edu.ec", "963mv",
                    nuevoUsuario, vehiculo);
        }
        Viaje nuevoViaje = new Viaje("Quito", "Santa Rosa",
                cuentaConductor.obtenerCantidadAsientos(), 0.625, cuentaConductor, new Fecha("2023-03-06 17:05:28"));
        cuentaConductor.crearViaje(nuevoViaje);

        Usuario nuevoUsuarioPasajero = new Usuario("O", "J", "0983973634", 202114325);
        Pasajero cuentaPasajero = new Pasajero("martha.ruiz@epn.edu.ec", "1234", nuevoUsuarioPasajero);

        Reservacion reservacion = new Reservacion(nuevoViaje, cuentaPasajero, 4);
        cuentaPasajero.crearReservacion(reservacion);
        /**
         * ******************Borrar*********************+
         */

        /* Ejemplo para eliminar controlador de tiempo de pago*/
        Factura factura = new Factura(3.05);
        
        Pago pagoTransf = new PagoTransferencia(factura, 20*60*1000);
       
        SqlTiempoDeReserva sqlTiempoDeReserva = new SqlTiempoDeReserva();

        String cadenaFechaFin = sqlTiempoDeReserva.obtenerFechaFin(reservacion);

        
        DateTimeFormatter formatterSL = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.s");
        LocalDateTime fechaFin = LocalDateTime.parse(cadenaFechaFin, formatterSL);
        
        LocalDateTime fechaActual = LocalDateTime.now();

        Duration duracionRestante = Duration.between(fechaActual, fechaFin);
        long tiempoRestante = duracionRestante.toMillis();
        
        //Se da el formato de hh:mm:ss
        String cadenaTiempoRestante = String.format("%d:%02d:%02d:%02d", 
            duracionRestante.toDays(),
            duracionRestante.toHours() % 24,
            duracionRestante.toMinutes() % 60,
            duracionRestante.toSeconds() % 60);

        System.out.println("Tiempo restante: " + cadenaTiempoRestante);
        System.out.println("Tiempo restante (en milisegundos) " + tiempoRestante);
        
        if (tiempoRestante<0){
            System.out.println("Se pausa");
            pagoTransf.getControlador().pausarContolador();
        }
        
        // Luego se debe eliminar de la tabla
        /* 
        // En caso de pagar eliminar de la tabla la feacha de fin
        if (sqlTiempoDeReserva.EliminarFechaFin(reservacion)){
            System.out.println("Se elimino");
            pagoTransf.getControlador().pausarContolador();
        }
        */
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlVentana = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout pnlVentanaLayout = new javax.swing.GroupLayout(pnlVentana);
        pnlVentana.setLayout(pnlVentanaLayout);
        pnlVentanaLayout.setHorizontalGroup(
            pnlVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        pnlVentanaLayout.setVerticalGroup(
            pnlVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlVentana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlVentana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jfmTestDeTemporizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfmTestDeTemporizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfmTestDeTemporizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfmTestDeTemporizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfmTestDeTemporizador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlVentana;
    // End of variables declaration//GEN-END:variables
}
