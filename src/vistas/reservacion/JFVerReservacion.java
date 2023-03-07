/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas.reservacion;

import java.time.format.DateTimeFormatter;
import modelo.externo.Fecha;
import modelo.ranking.Calificacion;
import modelo.reservacion.Reservacion;
import modelo.usuarios.Conductor;
import modelo.usuarios.Pasajero;
import modelo.usuarios.Usuario;
import modelo.usuarios.Vehiculo;
import modelo.viaje.Asiento;
import modelo.viaje.Viaje;
import vistas.ranking.JFrameCalificacion;
import vistas.ranking.JFrameRanking;

/**
 *
 * @author Cesar
 */
public class JFVerReservacion extends javax.swing.JFrame {

    private Reservacion reservacionSeleccionada;

    /**
     * Creates new form jfmVerResrvacion
     */
    public JFVerReservacion(Reservacion reservacion) {
        initComponents();
        setTitle("PoliCar4");
        setSize(817, 650);
        setResizable(false);
        this.setLocationRelativeTo(null);

        this.reservacionSeleccionada = reservacion;
        llenarDatos();
        
        
        //TODO set_Visible false para pagar su ya esta pagado o si es en efectivo
    }

    private void llenarDatos() {
        txtUbicaciónPartida.setText(reservacionSeleccionada.getViaje().getUbicacionPartida());
        txtUbicaciónDestino.setText(reservacionSeleccionada.getViaje().getUbicacionDestino());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHora = reservacionSeleccionada.getViaje().getFecha().getFechaYHora().format(formatter);

        txtFecha.setText(fechaHora);
        txtNombreConductor.setText(reservacionSeleccionada.getViaje().getCuenta().getUsuario().getNombre());
        txtApellidoConductor.setText(reservacionSeleccionada.getViaje().getCuenta().getUsuario().getApellido());

        int numeroAsientos = 0;
        for (Asiento a : reservacionSeleccionada.getListaDeAsientos()) {
            if (a != null) {
                numeroAsientos++;
            }
        }
        txtNumeroAsientos.setText(String.valueOf(numeroAsientos));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlDatosViaje = new javax.swing.JPanel();
        lblUbicaciónPartida = new javax.swing.JLabel();
        lblUbicaciónDestino = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblNombreConductor = new javax.swing.JLabel();
        lblApellidoConductor = new javax.swing.JLabel();
        txtUbicaciónPartida = new javax.swing.JTextField();
        txtUbicaciónDestino = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtNombreConductor = new javax.swing.JTextField();
        txtApellidoConductor = new javax.swing.JTextField();
        lblNumeroAsientos = new javax.swing.JLabel();
        txtNumeroAsientos = new javax.swing.JTextField();
        btnVolver = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        btnCalificar = new javax.swing.JButton();
        lblReservacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlDatosViaje.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        lblUbicaciónPartida.setText("Ubicación Partida");

        lblUbicaciónDestino.setText("Ubicación Destino");

        lblFecha.setText("Fecha");

        lblNombreConductor.setText("Nombre Conductor");

        lblApellidoConductor.setText("Apellido Conductor");
        lblApellidoConductor.setToolTipText("");

        txtUbicaciónPartida.setEditable(false);

        txtUbicaciónDestino.setEditable(false);

        txtFecha.setEditable(false);

        txtNombreConductor.setEditable(false);
        txtNombreConductor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNombreConductorMouseClicked(evt);
            }
        });

        txtApellidoConductor.setEditable(false);

        lblNumeroAsientos.setText("Número de Asientos");

        txtNumeroAsientos.setEditable(false);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        btnCalificar.setText("Calificar");
        btnCalificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDatosViajeLayout = new javax.swing.GroupLayout(pnlDatosViaje);
        pnlDatosViaje.setLayout(pnlDatosViajeLayout);
        pnlDatosViajeLayout.setHorizontalGroup(
            pnlDatosViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosViajeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUbicaciónDestino)
                    .addComponent(lblFecha)
                    .addComponent(lblNombreConductor)
                    .addComponent(lblApellidoConductor)
                    .addComponent(lblNumeroAsientos)
                    .addComponent(lblUbicaciónPartida))
                .addGap(29, 29, 29)
                .addGroup(pnlDatosViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUbicaciónDestino)
                    .addComponent(txtFecha)
                    .addComponent(txtNombreConductor, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtApellidoConductor)
                    .addComponent(txtNumeroAsientos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtUbicaciónPartida))
                .addContainerGap())
            .addGroup(pnlDatosViajeLayout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(btnVolver)
                .addGap(18, 18, 18)
                .addComponent(btnPagar)
                .addGap(18, 18, 18)
                .addComponent(btnCalificar)
                .addContainerGap(221, Short.MAX_VALUE))
        );
        pnlDatosViajeLayout.setVerticalGroup(
            pnlDatosViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosViajeLayout.createSequentialGroup()
                .addGroup(pnlDatosViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosViajeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblUbicaciónPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtUbicaciónPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDatosViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUbicaciónDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUbicaciónDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidoConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellidoConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumeroAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(pnlDatosViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver)
                    .addComponent(btnPagar)
                    .addComponent(btnCalificar))
                .addGap(77, 77, 77))
        );

        lblReservacion.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        lblReservacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReservacion.setText("RESERVACIÓN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDatosViaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblReservacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(lblReservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlDatosViaje, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 751, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        //Sentencia para mostrar el panel anterior
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        //Sentencia para mostrar el panel de pago
    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnCalificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalificarActionPerformed
        // TODO add your handling code here:
        //this.setVisible(false);
        //Sentencia para mostrar el panel de calificacion
        new JFrameCalificacion(new Calificacion(this.reservacionSeleccionada.getViaje())).setVisible(true);
    }//GEN-LAST:event_btnCalificarActionPerformed

    private void txtNombreConductorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreConductorMouseClicked
        // TODO add your handling code here:
        new JFrameRanking(new Calificacion(this.reservacionSeleccionada.getViaje())).setVisible(true);
    }//GEN-LAST:event_txtNombreConductorMouseClicked

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
            java.util.logging.Logger.getLogger(JFVerReservacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFVerReservacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFVerReservacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFVerReservacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
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
                        cuentaConductor.obtenerCantidadAsientos(), 2.3, cuentaConductor, new Fecha("2023-03-06 17:05:28"));
                cuentaConductor.crearViaje(nuevoViaje);

                Usuario nuevoUsuarioPasajero = new Usuario("O", "J", "0983973634", 202114325);
                Pasajero cuentaPasajero = new Pasajero("martha.ruiz@epn.edu.ec", "1234", nuevoUsuarioPasajero);

                Reservacion reservacion = new Reservacion(nuevoViaje, cuentaPasajero, 4);
                cuentaPasajero.crearReservacion(reservacion);
                /**
                 * ******************Borrar*********************+
                 */
                new JFVerReservacion(reservacion).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalificar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblApellidoConductor;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblNombreConductor;
    private javax.swing.JLabel lblNumeroAsientos;
    private javax.swing.JLabel lblReservacion;
    private javax.swing.JLabel lblUbicaciónDestino;
    private javax.swing.JLabel lblUbicaciónPartida;
    private javax.swing.JPanel pnlDatosViaje;
    private javax.swing.JTextField txtApellidoConductor;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNombreConductor;
    private javax.swing.JTextField txtNumeroAsientos;
    private javax.swing.JTextField txtUbicaciónDestino;
    private javax.swing.JTextField txtUbicaciónPartida;
    // End of variables declaration//GEN-END:variables
}
