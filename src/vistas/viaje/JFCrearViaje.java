/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas.viaje;

import controladorBD.viaje.SqlViaje;
import javax.swing.JOptionPane;

import modelo.usuarios.Conductor;
import modelo.usuarios.Usuario;
import modelo.usuarios.Vehiculo;
import modelo.viaje.Viaje;
import modelo.viaje.ListaViaje;
import modelo.externo.Fecha;

import java.time.LocalDateTime;
import vistas.usuarios.JFConductor;

/**
 * @author stalinnarvaezmolina
 */
public class JFCrearViaje extends javax.swing.JFrame {

    public ListaViaje listaViaje;
    Conductor conductor;
    //  public U_JFPerfilConductor perfilConductor;

    public JFCrearViaje(Conductor conductor) {
        initComponents();
        this.setLocationRelativeTo(this);

        this.conductor = conductor;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFecha = new javax.swing.JLabel();
        txtPartida = new javax.swing.JTextField();
        txtDestino = new javax.swing.JTextField();
        txtAsientos = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        lblPartida = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        lblDestino = new javax.swing.JLabel();
        lblAsientosDisponibles = new javax.swing.JLabel();
        lblPrecio1 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFecha.setText("Fecha y Hora");

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 2, 24)); // NOI18N
        jLabel1.setText("VIAJE");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblPartida.setText("Ubicacion de Partida:");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        lblDestino.setText("Ubicacion del Destino:");

        lblAsientosDisponibles.setText("Asientos Disponibles:");

        lblPrecio1.setText("Precio por Asiento:");

        txtFecha.setText("2000-00-00 00:00:00");
        txtFecha.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPartida)
                            .addComponent(lblDestino)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(60, 60, 60)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblPrecio1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblAsientosDisponibles)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(98, 98, 98)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(63, 63, 63)
                                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(102, 102, 102)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(331, 331, 331)
                        .addComponent(jLabel1)))
                .addContainerGap(205, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel1)
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPartida)
                    .addComponent(txtPartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDestino)
                    .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAsientosDisponibles)
                    .addComponent(txtAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecio1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFecha)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(107, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        this.setVisible(false);
        int opcion;// = JOptionPane.showMessageDialog(null, "V_JFViaje Cancelado");
        opcion = JOptionPane.showConfirmDialog(null, "Desea cancelar el Viaje", "Viaje", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            JFConductor jFConductor = new JFConductor(conductor);
            jFConductor.setVisible(true);

        } else {
            this.setVisible(true);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {

        //TODO
        String partida, destino, asientos, precio, fechaIngresada;

        partida = txtPartida.getText();
        destino = txtDestino.getText();
        asientos = txtAsientos.getText();
        precio = txtPrecio.getText();
        fechaIngresada = txtFecha.getText();
        
        String regex = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]{1,30}$"; // Expresión regular para validar el formato
        String regex2 = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$"; // Expresión regular para validar el formato
        String regex3 = "^[0-9]{1,2}(\\.[0-9]{1,2})?$"; // Expresión regular para validar el formato precio
        String regex4 = "^[1-4]$"; // Expresión regular para validar el formato

        if (partida.isEmpty() || destino.isEmpty() || asientos.isEmpty() || precio.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            return;
        }

        if (!fechaIngresada.matches(regex2)) {
            JOptionPane.showMessageDialog(null, "El formato de la fecha debe ser: 2000-00-00 00:00:00");
            return;
        }

        Fecha fecha = new Fecha(txtFecha.getText());

        if (partida.isEmpty() || !partida.matches(regex)) {
            JOptionPane.showMessageDialog(null, "La partida debe tener entre 1 y 30 caracteres y contener solo letras y espacios");
            return;
        }

        if (destino.isEmpty() || !destino.matches(regex)) {
            JOptionPane.showMessageDialog(null, "El destino debe tener entre 1 y 30 caracteres y contener solo letras y espacios");
            return;
        }
        if (partida.equals(destino)) {
            // Si los valores son iguales, mostrar un mensaje de error y terminar la ejecución.
            JOptionPane.showMessageDialog(null, "Error: La ubicación de partida y destino no puede ser la misma.");
            return;
        }
        
        if (!asientos.matches(regex4)) {
            JOptionPane.showMessageDialog(null, "La cantidad de asientos debe ser un dígito entre 1 y 4");
            return;
        }

        if (!precio.matches(regex3)) {
            JOptionPane.showMessageDialog(null, "El formato del precio debe ser: una o dos dígitos . uno o dos dígitos");
            return;
        }

        Viaje nuevoViaje = new Viaje(partida, destino, Integer.parseInt(asientos), Double.parseDouble(precio), conductor, fecha);
        conductor.crearViaje(nuevoViaje);

        SqlViaje sqlViaje = new SqlViaje();

        if (sqlViaje.registrarViaje(nuevoViaje, Integer.parseInt(asientos), Double.parseDouble(precio), txtFecha.getText())) {
            //System.out.println("Se registro el viaje");
            this.setVisible(false);
            JFConductor jFConductor = new JFConductor(conductor);
            jFConductor.setVisible(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAsientosDisponibles;
    private javax.swing.JLabel lblDestino;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblPartida;
    private javax.swing.JLabel lblPrecio1;
    private javax.swing.JTextField txtAsientos;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtPartida;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
