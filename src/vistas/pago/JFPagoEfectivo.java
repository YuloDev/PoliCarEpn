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
import modelo.pago.PagoEfectivo;
import modelo.reservacion.Reservacion;
import modelo.usuarios.Conductor;
import modelo.usuarios.Pasajero;
import modelo.usuarios.Usuario;
import modelo.usuarios.Vehiculo;
import modelo.viaje.Viaje;
import vistas.reservacion.JFListaReservacionesConductor;
import vistas.viaje.JFListaViajesDeConductor;

/**
 *
 * @author Kevin
 */
public class JFPagoEfectivo extends javax.swing.JFrame {

    PagoEfectivo pagoEfectivo;
    Factura factura;
    JFPago jPago;
    static Pasajero pasajero;
    SqlPago sqlPago = new SqlPago();
    Reservacion reservacion;

    public JFPagoEfectivo(Reservacion reservacion) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.reservacion = reservacion;
        this.factura = new Factura(reservacion);
        this.pasajero = (Pasajero) reservacion.getCuenta();
        this.pagoEfectivo = new PagoEfectivo(factura, pasajero.getCreditos());
        this.jPago = new JFPago(reservacion);
        this.pasajero = pasajero;
        factura.calcularTotal();
        txtMontoaCancelar.setText(factura.valorTotal + "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPagoEfectivo = new javax.swing.JPanel();
        lblPagoEfectivo = new javax.swing.JLabel();
        lblMontoACancelar = new javax.swing.JLabel();
        txtMontoaCancelar = new javax.swing.JTextField();
        btnPagoRealizado = new javax.swing.JButton();
        btnRegresarPE = new javax.swing.JButton();
        btnNoRealizado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlPagoEfectivo.setBorder(javax.swing.BorderFactory.createTitledBorder("Pago Efectivo"));

        lblPagoEfectivo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblPagoEfectivo.setText("Pago Efectivo");

        lblMontoACancelar.setText("Monto a Cancelar");

        txtMontoaCancelar.setEditable(false);

        btnPagoRealizado.setText("Realizado");
        btnPagoRealizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagoRealizadoActionPerformed(evt);
            }
        });

        btnRegresarPE.setText("Regresar");
        btnRegresarPE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarPEActionPerformed(evt);
            }
        });

        btnNoRealizado.setText("No realizado");
        btnNoRealizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoRealizadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPagoEfectivoLayout = new javax.swing.GroupLayout(pnlPagoEfectivo);
        pnlPagoEfectivo.setLayout(pnlPagoEfectivoLayout);
        pnlPagoEfectivoLayout.setHorizontalGroup(
            pnlPagoEfectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPagoEfectivoLayout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addGroup(pnlPagoEfectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPagoEfectivoLayout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(lblPagoEfectivo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPagoEfectivoLayout.createSequentialGroup()
                        .addGroup(pnlPagoEfectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlPagoEfectivoLayout.createSequentialGroup()
                                .addComponent(lblMontoACancelar)
                                .addGap(140, 140, 140)
                                .addComponent(txtMontoaCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlPagoEfectivoLayout.createSequentialGroup()
                                .addGroup(pnlPagoEfectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlPagoEfectivoLayout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addComponent(btnPagoRealizado, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44)
                                        .addComponent(btnNoRealizado, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlPagoEfectivoLayout.createSequentialGroup()
                                        .addGap(139, 139, 139)
                                        .addComponent(btnRegresarPE, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(192, 192, 192))))
        );
        pnlPagoEfectivoLayout.setVerticalGroup(
            pnlPagoEfectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPagoEfectivoLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(lblPagoEfectivo)
                .addGap(104, 104, 104)
                .addGroup(pnlPagoEfectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMontoaCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMontoACancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(pnlPagoEfectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPagoRealizado, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNoRealizado, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addComponent(btnRegresarPE, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPagoEfectivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPagoEfectivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPagoRealizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagoRealizadoActionPerformed
        try {
            if (pagoEfectivo.realizarPago()) {
                sqlPago.registrarFactura(factura);
                sqlPago.cambiarEstadoDePago(factura, 1);
                JOptionPane.showMessageDialog(rootPane, "Pago Confirmado", "Pago Efectivo", 1);
                JFListaViajesDeConductor jFListaViajesDeConductor = new JFListaViajesDeConductor((Conductor) reservacion.getViaje().getCuenta());
                jFListaViajesDeConductor.setVisible(true);
                this.setVisible(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JFPagoEfectivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPagoRealizadoActionPerformed

    private void btnRegresarPEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarPEActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        JFListaReservacionesConductor jFListaReservacionesConductor = new JFListaReservacionesConductor(reservacion.getViaje());
        jFListaReservacionesConductor.setVisible(true);
    }//GEN-LAST:event_btnRegresarPEActionPerformed

    private void btnNoRealizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoRealizadoActionPerformed
        if (!pagoEfectivo.isEstaPagado()) {
            sqlPago.cambiarEstadoDePago(factura, 2);
            JOptionPane.showMessageDialog(rootPane, "Pago no confirmado", "Pago Efectivo", 2);
        }
        this.setVisible(false);
        JFListaReservacionesConductor jFListaReservacionesConductor = new JFListaReservacionesConductor(reservacion.getViaje());
        jFListaReservacionesConductor.setVisible(true);
    }//GEN-LAST:event_btnNoRealizadoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNoRealizado;
    private javax.swing.JButton btnPagoRealizado;
    private javax.swing.JButton btnRegresarPE;
    private javax.swing.JLabel lblMontoACancelar;
    private javax.swing.JLabel lblPagoEfectivo;
    private javax.swing.JPanel pnlPagoEfectivo;
    private javax.swing.JTextField txtMontoaCancelar;
    // End of variables declaration//GEN-END:variables
}
