/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas.pago;

import controladorBD.pago.SqlPago;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.externo.Fecha;
import modelo.pago.Factura;
import modelo.pago.PagoTransferencia;
import modelo.reservacion.Reservacion;
import modelo.usuarios.Conductor;
import modelo.usuarios.Pasajero;
import modelo.usuarios.Usuario;
import modelo.usuarios.Vehiculo;
import modelo.viaje.Viaje;

/**
 *
 * @author Kevin
 */
public class JFPagoTransferencia extends javax.swing.JFrame {
    JFPago jPago;
    PagoTransferencia pagoTransferencia;
    Factura factura;
    JFFactura jfFactura;
    SqlPago s = new SqlPago();
    /**
     * Creates new form JFPagoTransferencia
     */
    public JFPagoTransferencia(Reservacion reservacion) throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        factura = new Factura(reservacion);
        pagoTransferencia = new PagoTransferencia(factura, 20*60*1000);
        jfFactura = new JFFactura(reservacion);
        jPago = new JFPago(reservacion);
        factura.calcularTotal();
        txtMontoTotal.setText(factura.valorTotal+"");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPagoTransferencia = new javax.swing.JPanel();
        lblMontoTotal = new javax.swing.JLabel();
        txtMontoTotal = new javax.swing.JTextField();
        btnRealizarPago = new javax.swing.JButton();
        btnRegresarPT = new javax.swing.JButton();
        lblPagoTransferencia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlPagoTransferencia.setBorder(javax.swing.BorderFactory.createTitledBorder("Pago Transferencia"));

        lblMontoTotal.setText("Monto Total");

        btnRealizarPago.setText("Realizar Pago");
        btnRealizarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarPagoActionPerformed(evt);
            }
        });

        btnRegresarPT.setText("Regresar");
        btnRegresarPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarPTActionPerformed(evt);
            }
        });

        lblPagoTransferencia.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblPagoTransferencia.setText("Pago Transferencia");

        javax.swing.GroupLayout pnlPagoTransferenciaLayout = new javax.swing.GroupLayout(pnlPagoTransferencia);
        pnlPagoTransferencia.setLayout(pnlPagoTransferenciaLayout);
        pnlPagoTransferenciaLayout.setHorizontalGroup(
            pnlPagoTransferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPagoTransferenciaLayout.createSequentialGroup()
                .addGroup(pnlPagoTransferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPagoTransferenciaLayout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(lblPagoTransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPagoTransferenciaLayout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(lblMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120)
                        .addComponent(txtMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPagoTransferenciaLayout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(btnRealizarPago, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(btnRegresarPT, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        pnlPagoTransferenciaLayout.setVerticalGroup(
            pnlPagoTransferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPagoTransferenciaLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(lblPagoTransferencia)
                .addGap(78, 78, 78)
                .addGroup(pnlPagoTransferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMontoTotal)
                    .addComponent(txtMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(168, 168, 168)
                .addGroup(pnlPagoTransferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRealizarPago, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegresarPT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(145, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addComponent(pnlPagoTransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(16, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(pnlPagoTransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(15, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRealizarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarPagoActionPerformed
        // TODO add your handling code here:
        if(pagoTransferencia.realizarPago()){
            try {
                s.registrarFactura(factura);
                s.insertarSaldo((float)pagoTransferencia.billetera.saldo);
            } catch (SQLException ex) {
                Logger.getLogger(JFPagoTransferencia.class.getName()).log(Level.SEVERE, null, ex);
            }
            jfFactura.setVisible(true);
            this.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Pago no realizado","Pago Transferencia",0);
        }
    }//GEN-LAST:event_btnRealizarPagoActionPerformed

    private void btnRegresarPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarPTActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        jPago.setVisible(true);
    }//GEN-LAST:event_btnRegresarPTActionPerformed

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
            java.util.logging.Logger.getLogger(JFPagoTransferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFPagoTransferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFPagoTransferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPagoTransferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

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
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new JFPagoTransferencia(reservacion).setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(JFPagoTransferencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRealizarPago;
    private javax.swing.JButton btnRegresarPT;
    private javax.swing.JLabel lblMontoTotal;
    private javax.swing.JLabel lblPagoTransferencia;
    private javax.swing.JPanel pnlPagoTransferencia;
    private javax.swing.JTextField txtMontoTotal;
    // End of variables declaration//GEN-END:variables
}