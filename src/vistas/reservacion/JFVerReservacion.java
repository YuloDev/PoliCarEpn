/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas.reservacion;

import controladorBD.ranking.SqlCalificacion;
import controladorBD.reservacion.SqlReservacion;
import controladorBD.reservacion.SqlTiempoDeReserva;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ranking.Calificacion;
import modelo.reservacion.Reservacion;
import modelo.usuarios.Pasajero;
import modelo.viaje.Asiento;
import vistas.pago.JFPagoTransferencia;
import vistas.ranking.JFrameCalificacion;
import vistas.ranking.JFrameRanking;

/**
 *
 * @author Cesar
 */
public class JFVerReservacion extends javax.swing.JFrame {

    private Reservacion reservacionSeleccionada;
    private SqlReservacion sqlReservacion = new SqlReservacion();

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
        
        btnPagar.setEnabled(false);
        if (sqlReservacion.verificarPagoTransferenciaNoRealizado(reservacion)){
            btnPagar.setEnabled(true);
        }
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
        for (Asiento a : reservacionSeleccionada.getListaDeAsientos().getAsientos()) {
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
                    .addGroup(pnlDatosViajeLayout.createSequentialGroup()
                        .addGroup(pnlDatosViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUbicaciónDestino)
                            .addComponent(lblFecha)
                            .addComponent(lblNombreConductor)
                            .addComponent(lblApellidoConductor)
                            .addComponent(lblNumeroAsientos)
                            .addComponent(lblUbicaciónPartida))
                        .addGap(29, 29, 29)
                        .addGroup(pnlDatosViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUbicaciónDestino, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                            .addComponent(txtFecha)
                            .addComponent(txtNombreConductor, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtApellidoConductor)
                            .addComponent(txtNumeroAsientos, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtUbicaciónPartida))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosViajeLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVolver)
                        .addGap(33, 33, 33)
                        .addComponent(btnPagar)
                        .addGap(36, 36, 36)
                        .addComponent(btnCalificar)
                        .addGap(245, 245, 245))))
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
                .addGap(51, 51, 51)
                .addGroup(pnlDatosViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver)
                    .addComponent(btnPagar)
                    .addComponent(btnCalificar))
                .addGap(95, 95, 95))
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
        this.setVisible(false);
        JFListaReservacionPasajero jFListaReservacionPasajero = new JFListaReservacionPasajero( (Pasajero) reservacionSeleccionada.getCuenta());
        jFListaReservacionPasajero.setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        
        JFPagoTransferencia jFPagoTransferencia = null;
        try {
            jFPagoTransferencia = new JFPagoTransferencia(reservacionSeleccionada, (Pasajero) reservacionSeleccionada.getCuenta());
        } catch (SQLException ex) {
            Logger.getLogger(JFVerReservacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        jFPagoTransferencia.setVisible(true);
    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnCalificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalificarActionPerformed
        //TODO add your handling code here:
        SqlCalificacion sqlCalificacion = new SqlCalificacion();
        if (!sqlCalificacion.existeCalificacion(reservacionSeleccionada)) {
            new JFrameCalificacion(this.reservacionSeleccionada.getViaje()).setVisible(true);
            sqlCalificacion.actualizarEstadoCalificacion(reservacionSeleccionada);
        }else{
            JOptionPane.showMessageDialog(this, "Este viaje ya ha sido calificado!");
        } 
    }//GEN-LAST:event_btnCalificarActionPerformed

    private void txtNombreConductorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreConductorMouseClicked
        
        new JFrameRanking(this.reservacionSeleccionada.getViaje().getCuenta().getUsuario().getCodUnico()).setVisible(true);
    }//GEN-LAST:event_txtNombreConductorMouseClicked

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
