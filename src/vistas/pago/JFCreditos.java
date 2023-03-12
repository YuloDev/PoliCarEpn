/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas.pago;

import controladorBD.pago.SqlPago;
import controladorBD.usuarios.SqlCuenta;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import modelo.pago.Creditos;
import modelo.usuarios.Pasajero;
import vistas.usuarios.JFPasajero;

/**
 *
 * @author Kevin
 */
public class JFCreditos extends javax.swing.JFrame {
    Creditos creditos;
    Pasajero pasajero;
    SqlPago s;
    JFPasajero jfp;
    
    /**
     * Creates new form JFCreditos
     */
    public JFCreditos(Pasajero pasajero) {
        initComponents();
        setLocationRelativeTo(null);
        setSize(817,610);
        s = new SqlPago();
        this.creditos = pasajero.getCreditos();
        this.pasajero = pasajero;
        txtSaldoDisponible.setText(s.obtenerCreditos(pasajero.getCorreo())+"");
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
        btnRecargar = new javax.swing.JButton();
        btnRegresarC = new javax.swing.JButton();
        lblSaldoDisponible = new javax.swing.JLabel();
        txtSaldoDisponible = new javax.swing.JTextField();
        lblValorRecargar = new javax.swing.JLabel();
        txtValorRecargar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnRecargar.setText("Recargar");
        btnRecargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecargarActionPerformed(evt);
            }
        });

        btnRegresarC.setText("Regresar");
        btnRegresarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarCActionPerformed(evt);
            }
        });

        lblSaldoDisponible.setText("Créditos Disponible");

        txtSaldoDisponible.setEditable(false);
        txtSaldoDisponible.setFocusable(false);

        lblValorRecargar.setText("Valor a recargar");

        txtValorRecargar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorRecargarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblValorRecargar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSaldoDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtValorRecargar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(207, 207, 207))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRecargar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSaldoDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(76, 76, 76)
                        .addComponent(btnRegresarC, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(252, 252, 252))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSaldoDisponible)
                    .addComponent(txtSaldoDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValorRecargar)
                    .addComponent(txtValorRecargar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRecargar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegresarC, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(143, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel1.setText("CREDITOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecargarActionPerformed
        // TODO add your handling code here:
        if(txtValorRecargar.getText().equalsIgnoreCase(null)){
            double valor = Double.parseDouble(txtValorRecargar.getText());
            if( valor >= 1 && valor <= 50){
                try {
                    valor = creditos.recargarSaldo(valor);
                    s.actualizarCreditos(valor,pasajero.getCorreo());
                    txtSaldoDisponible.setText(valor+"");
                    txtValorRecargar.setText(null);
                    jfp = new JFPasajero(pasajero);
                } catch (SQLException ex) {
                    Logger.getLogger(JFCreditos.class.getName()).log(Level.SEVERE, null, ex);            
                }
                JOptionPane.showMessageDialog(rootPane, "Creditos recargados con éxito","Créditos",1);    
            }else{
                JOptionPane.showMessageDialog(rootPane, "El valor de la recarga debe ser entre $1 y $50","Creditos",0);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "El valor de la recarga debe ser entre $1 y $50","Creditos",0);
        }
    }//GEN-LAST:event_btnRecargarActionPerformed

    private void btnRegresarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarCActionPerformed
        // TODO add your handling code here:
        jfp = new JFPasajero(pasajero);
        this.setVisible(false);
        jfp.setVisible(true);
    }//GEN-LAST:event_btnRegresarCActionPerformed

    private void txtValorRecargarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorRecargarKeyTyped
        // TODO add your handling code here:
        char character = evt.getKeyChar();
        String text = txtValorRecargar.getText() + character;
        if (!Pattern.matches("[0-9]{0,2}(\\.[0-9]*)?", text)) {
            evt.consume(); 
        }  
    }//GEN-LAST:event_txtValorRecargarKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRecargar;
    private javax.swing.JButton btnRegresarC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblSaldoDisponible;
    private javax.swing.JLabel lblValorRecargar;
    private javax.swing.JTextField txtSaldoDisponible;
    private javax.swing.JTextField txtValorRecargar;
    // End of variables declaration//GEN-END:variables
}
