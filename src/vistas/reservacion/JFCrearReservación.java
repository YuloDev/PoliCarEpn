/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas.reservacion;

import controladorBD.reservacion.SqlReservacion;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import modelo.externo.Fecha;
import modelo.reservacion.Reservacion;
import modelo.usuarios.Conductor;
import modelo.usuarios.Cuenta;
import modelo.usuarios.Pasajero;
import modelo.usuarios.Usuario;
import modelo.usuarios.Vehiculo;
import modelo.viaje.Asiento;
import modelo.viaje.Libre;
import modelo.viaje.Viaje;
import vistas.pago.JFPago;
import vistas.ranking.JFrameRanking;
import vistas.viaje.JFBuscarViaje;

/**
 *
 * @author Cesar
 */
public class JFCrearReservación extends javax.swing.JFrame {

    private Viaje viajeSeleccionado;
    private Pasajero pasajero;
    private int idViaje;

    /**
     * Creates new form jfmCrearReservación
     */
    public JFCrearReservación(Viaje viaje, Pasajero pasajero) {
        initComponents();
        setTitle("PoliCar4");
        setSize(817, 650);
        setResizable(false);
        this.setLocationRelativeTo(null);
        this.viajeSeleccionado = viaje;
        this.pasajero = pasajero;
        this.idViaje = idViaje;
        llenarDatos();
    }

    private void llenarDatos() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHora = viajeSeleccionado.getFecha().getFechaYHora().format(formatter);

        txtUbicaciónPartida.setText(viajeSeleccionado.getUbicacionPartida());
        txtUbicaciónDestino.setText(viajeSeleccionado.getUbicacionDestino());
        txtFecha.setText(fechaHora);
        txtNombreConductor.setText(viajeSeleccionado.getCuenta().getUsuario().getNombre());
        txtApellidoConductor.setText(viajeSeleccionado.getCuenta().getUsuario().getApellido());

        int numeroAsientos = 0;
        for (Asiento asiento : viajeSeleccionado.getListaDeAsientos().getAsientos()) {
            if (asiento != null) {
                if (asiento.getEstado() instanceof Libre) {
                    numeroAsientos++;
                }
            }
        }
        for (int i = 0; i < numeroAsientos; i++) {
            cmbNumeroAsientos.addItem(String.valueOf(i + 1));
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
        lblReservacion = new javax.swing.JLabel();
        pnlNumeroAsientos = new javax.swing.JPanel();
        lblNumeroAsientos = new javax.swing.JLabel();
        cmbNumeroAsientos = new javax.swing.JComboBox<>();
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
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblReservacion.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        lblReservacion.setText("RESERVACIÓN");

        pnlNumeroAsientos.setBorder(javax.swing.BorderFactory.createTitledBorder("Elección del número de asientos"));

        lblNumeroAsientos.setText("Número de Asientos");

        javax.swing.GroupLayout pnlNumeroAsientosLayout = new javax.swing.GroupLayout(pnlNumeroAsientos);
        pnlNumeroAsientos.setLayout(pnlNumeroAsientosLayout);
        pnlNumeroAsientosLayout.setHorizontalGroup(
            pnlNumeroAsientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNumeroAsientosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblNumeroAsientos)
                .addGap(37, 37, 37)
                .addComponent(cmbNumeroAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(366, Short.MAX_VALUE))
        );
        pnlNumeroAsientosLayout.setVerticalGroup(
            pnlNumeroAsientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNumeroAsientosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlNumeroAsientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumeroAsientos)
                    .addComponent(cmbNumeroAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pnlDatosViaje.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Viaje"));

        lblUbicaciónPartida.setText("Ubicación Partida");

        lblUbicaciónDestino.setText("Ubicación Destino");

        lblFecha.setText("Fecha y Hora");

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

        javax.swing.GroupLayout pnlDatosViajeLayout = new javax.swing.GroupLayout(pnlDatosViaje);
        pnlDatosViaje.setLayout(pnlDatosViajeLayout);
        pnlDatosViajeLayout.setHorizontalGroup(
            pnlDatosViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosViajeLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlDatosViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUbicaciónPartida)
                    .addComponent(lblFecha)
                    .addComponent(lblUbicaciónDestino)
                    .addComponent(lblApellidoConductor)
                    .addComponent(lblNombreConductor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDatosViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombreConductor, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                    .addComponent(txtApellidoConductor, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                    .addComponent(txtUbicaciónDestino)
                    .addComponent(txtUbicaciónPartida)
                    .addComponent(txtFecha))
                .addContainerGap())
        );
        pnlDatosViajeLayout.setVerticalGroup(
            pnlDatosViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosViajeLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlDatosViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUbicaciónPartida)
                    .addComponent(txtUbicaciónPartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUbicaciónDestino)
                    .addComponent(txtUbicaciónDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFecha)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreConductor)
                    .addComponent(txtNombreConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblApellidoConductor)
                    .addComponent(txtApellidoConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlNumeroAsientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDatosViaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(79, 79, 79))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(btnConfirmar)
                        .addGap(134, 134, 134)
                        .addComponent(btnCancelar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(lblReservacion)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblReservacion)
                .addGap(40, 40, 40)
                .addComponent(pnlDatosViaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(pnlNumeroAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(btnCancelar))
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 767, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 575, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        try {
            this.setVisible(false);
            Reservacion reservacion = new Reservacion(viajeSeleccionado, pasajero, cmbNumeroAsientos.getSelectedIndex() + 1);
            JFPago jFPago = new JFPago(reservacion);
            jFPago.setVisible(true);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo crear la reservación", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
        JFBuscarViaje jFBuscarViaje = new JFBuscarViaje(pasajero);
        jFBuscarViaje.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNombreConductorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreConductorMouseClicked
        // TODO add your handling code here:
        new JFrameRanking(this.viajeSeleccionado.getCuenta().getUsuario().getCodUnico()).setVisible(true);
    }//GEN-LAST:event_txtNombreConductorMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JComboBox<String> cmbNumeroAsientos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblApellidoConductor;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblNombreConductor;
    private javax.swing.JLabel lblNumeroAsientos;
    private javax.swing.JLabel lblReservacion;
    private javax.swing.JLabel lblUbicaciónDestino;
    private javax.swing.JLabel lblUbicaciónPartida;
    private javax.swing.JPanel pnlDatosViaje;
    private javax.swing.JPanel pnlNumeroAsientos;
    private javax.swing.JTextField txtApellidoConductor;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNombreConductor;
    private javax.swing.JTextField txtUbicaciónDestino;
    private javax.swing.JTextField txtUbicaciónPartida;
    // End of variables declaration//GEN-END:variables
}
