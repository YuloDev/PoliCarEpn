/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas.viaje;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.reservacion.Reservacion;
import modelo.usuarios.Pasajero;
import modelo.viaje.Asiento;
import modelo.viaje.Libre;
import vistas.usuarios.JFPasajero;
import modelo.viaje.Viaje;
import vistas.reservacion.JFCrearReservación;
import static vistas.usuarios.JFLogin.viajes;

/**
 * @author Dana
 */
public class JFBuscarViaje extends javax.swing.JFrame {

    Pasajero pasajero;
    String destinoBuscar;
    double precioBuscar;
    int asientosBuscar;
    ArrayList<Integer> idViajes = new ArrayList<>();

    public JFBuscarViaje(Pasajero pasajero) {
        initComponents();
        setLocationRelativeTo(null);
        this.pasajero = pasajero;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDestino = new javax.swing.JTextField();
        txtPrecioAsiento = new javax.swing.JTextField();
        txtAsientoDisponible = new javax.swing.JTextField();
        btnVolver = new javax.swing.JButton();
        scrTablaViajes = new javax.swing.JScrollPane();
        tblViajes = new javax.swing.JTable();
        btnFiltrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("VIAJES DISPONIBLES");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Destino:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Precio máximo por asiento:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Asientos minimos disponibles:");

        txtPrecioAsiento.setText("1");

        txtAsientoDisponible.setText("1");

        btnVolver.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        tblViajes.setModel(new javax.swing.table.DefaultTableModel(
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
        tblViajes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblViajesMouseClicked(evt);
            }
        });
        scrTablaViajes.setViewportView(tblViajes);

        btnFiltrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFiltrar.setText("FILTRAR");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtAsientoDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnVolver))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(scrTablaViajes, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(txtPrecioAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(txtAsientoDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(scrTablaViajes, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(btnVolver)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:

        setVisible(false);

        JFPasajero jFPasajero = new JFPasajero(pasajero);
        jFPasajero.setVisible(true);

    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed

        destinoBuscar = txtDestino.getText();
        String precio = txtPrecioAsiento.getText();
        String asientosV = txtAsientoDisponible.getText();

        String regex = "^[0-9]{1,2}(\\.[0-9]{1,2})?$"; // Expresión regular para validar el formato precio
        String regex2 = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]{1,30}$"; // Expresión regular para validar el formato
        String regex3 = "^[1-4]$"; // Expresión regular para validar el formato asientos
        
        if (destinoBuscar.isEmpty() || !destinoBuscar.matches(regex2)) {
            JOptionPane.showMessageDialog(null, "El destino debe tener entre 1 y 30 caracteres y contener solo letras y espacios");
            return;
        }

        if (!precio.matches(regex)) {
            JOptionPane.showMessageDialog(null, "El formato del precio debe ser: una o dos dígitos . uno o dos dígitos");
            return;
        }

        precioBuscar = Double.parseDouble(precio);

        if (!asientosV.matches(regex3)) {
            JOptionPane.showMessageDialog(null, "La cantidad de asientos debe ser un dígito entre 1 y 4");
            return;
        }

        asientosBuscar = Integer.parseInt(txtAsientoDisponible.getText());

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Partida");
        model.addColumn("Destino");
        model.addColumn("Fecha");
        model.addColumn("Hora");

        tblViajes.setModel(model);

        String[] fila = new String[4];

        System.out.println(viajes);

        for (int idviaje : viajes.keySet()) {
            Viaje viaje = viajes.get(idviaje);

            //No se muestran los viajes con fecha exactamente igual a la dek viaje de alguna reservacion
            boolean horaFechaExistente = false;
            Reservacion[] reservacionesPasajero = this.pasajero.getListaReservacion().getReservaciones();
            for (int i = 0; i < reservacionesPasajero.length; i++) {
                if (reservacionesPasajero[i] != null) {
                    if (viaje.getFecha().getFechaYHora().equals(reservacionesPasajero[i].getViaje().getFecha().getFechaYHora())) {
                        horaFechaExistente = true;
                    }
                }
            }
            if (horaFechaExistente) {
                continue;
            }

            Asiento[] asientosDelViaje = viaje.getListaDeAsientos().getAsientos();
            double precioPorAsiento = asientosDelViaje[0].getPrecio();
            int numeroDeAsientosDisponibles = 0;
            for (Asiento asiento : asientosDelViaje) {
                if (asiento != null) {
                    if (asiento.getEstado() instanceof Libre) {
                        numeroDeAsientosDisponibles++;
                    }
                }

            }

            if (!LocalDateTime.now().isAfter(viaje.getFecha().getFechaYHora())) {
                if (viaje.getUbicacionDestino().equals(destinoBuscar) && precioPorAsiento <= precioBuscar && asientosBuscar <= numeroDeAsientosDisponibles) {
                    idViajes.add(idviaje);

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

    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void tblViajesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblViajesMouseClicked
        // TODO add your handling code here:
        int fila = tblViajes.getSelectedRow();
        setVisible(false);
        JFCrearReservación JFCrearReservación = new JFCrearReservación(viajes.get(idViajes.get(fila)), pasajero);
        JFCrearReservación.setVisible(true);
    }//GEN-LAST:event_tblViajesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane scrTablaViajes;
    private javax.swing.JTable tblViajes;
    private javax.swing.JTextField txtAsientoDisponible;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtPrecioAsiento;
    // End of variables declaration//GEN-END:variables
}
