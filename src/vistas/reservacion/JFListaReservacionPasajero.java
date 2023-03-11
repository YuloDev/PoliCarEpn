/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas.reservacion;

import java.time.format.DateTimeFormatter;
import javax.swing.table.DefaultTableModel;
import modelo.externo.Fecha;
import modelo.reservacion.ListaReservacion;
import modelo.reservacion.Reservacion;
import modelo.usuarios.Conductor;
import modelo.usuarios.Pasajero;
import modelo.usuarios.Usuario;
import modelo.usuarios.Vehiculo;
import modelo.viaje.Viaje;
import vistas.usuarios.JFPasajero;

/**
 *
 * @author Cesar
 */
public class JFListaReservacionPasajero extends javax.swing.JFrame {
Pasajero pasajero;
    ListaReservacion listaReservacion;
    /**
     * Creates new form jfmListaReservacionPasajero
     */
    public JFListaReservacionPasajero(Pasajero pasajero) {
        initComponents();
        setTitle("PoliCar4");
        setSize(817, 650);
        setResizable(false);
        this.setLocationRelativeTo(null);
        
        this.pasajero = pasajero;

        listaReservacion = pasajero.getListaReservacion();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Partida");
        model.addColumn("Destino");
        model.addColumn("Fecha");
        model.addColumn("Hora");
        tblListaReservacionPasajero.setModel(model);

        String[] fila = new String[4];

        for (Reservacion reservacion : listaReservacion.getReservaciones()) {
            if (reservacion != null) {
                Viaje viaje = reservacion.getViaje();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String fechaHora = viaje.getFecha().getFechaYHora().format(formatter);
               
                fila[0] = viaje.getUbicacionPartida();
                fila[1] = viaje.getUbicacionDestino();
                fila[2] = fechaHora.substring(0, 10);
                fila[3] = fechaHora.substring(11);
                model.addRow(fila);
            }

        }
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListaReservacionPasajero = new javax.swing.JTable();
        volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel1.setText("Lista de Reservaciones");

        tblListaReservacionPasajero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Partida", "Destino", "Fecha", "Hora"
            }
        ));
        tblListaReservacionPasajero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListaReservacionPasajeroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListaReservacionPasajero);

        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(volver)
                        .addGap(336, 336, 336))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(245, 245, 245))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addComponent(volver)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblListaReservacionPasajeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListaReservacionPasajeroMouseClicked
        // TODO add your handling code here:
        int filaSeleccionada = tblListaReservacionPasajero.rowAtPoint(evt.getPoint());
        this.setVisible(false);
        new JFVerReservacion(this.listaReservacion.getReservaciones()[filaSeleccionada]).setVisible(true);
        
    }//GEN-LAST:event_tblListaReservacionPasajeroMouseClicked

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        JFPasajero jFPasajero = new JFPasajero(pasajero);
        jFPasajero.setVisible(true);

    }//GEN-LAST:event_volverActionPerformed

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
            java.util.logging.Logger.getLogger(JFListaReservacionPasajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFListaReservacionPasajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFListaReservacionPasajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFListaReservacionPasajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListaReservacionPasajero;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
