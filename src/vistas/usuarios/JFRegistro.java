/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas.usuarios;

import controladorBD.usuarios.SqlCuenta;
import controladorBD.usuarios.SqlUsuario;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import modelo.usuarios.Conductor;
import modelo.usuarios.Cuenta;
import modelo.usuarios.Pasajero;
import modelo.usuarios.RestriccionDominio;
import modelo.usuarios.Usuario;
import modelo.usuarios.Vehiculo;

/**
 *
 * @author Lenovo
 */
public class JFRegistro extends javax.swing.JFrame {

    /**
     * Creates new form JFRegistro
     */
    public static String nombre;
    public static String apellido;
    public static int codigoUnico;
    public static String telefono;
    public static String correo;
    public static String contrasenia;
    public static String tipoCuenta;
    public static Usuario nuevoUsuario;

    public JFRegistro() {
        initComponents();
        setLocationRelativeTo(null);
        this.cmbTipoCuenta.setEnabled(false);
        this.btnRegistrar.setEnabled(false);
        this.txtCodigoUnico.setEnabled(false);
        this.txtTelefono.setEnabled(false);
        this.txtCorreo.setEnabled(false);
        this.psswdContraseniaR.setEnabled(false);


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblContrasenia = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        lblCodigoUnico = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        txtCodigoUnico = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        cmbTipoCuenta = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        psswdContraseniaR = new javax.swing.JPasswordField();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNombre.setText("Nombre");

        lblApellido.setText("Apellido");

        lblCorreo.setText("Correo");

        lblContrasenia.setText("Contraseña");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
            }
        });

        lblCodigoUnico.setText("Código Único");

        lblTelefono.setText("Teléfono");

        txtCodigoUnico.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigoUnicoFocusLost(evt);
            }
        });
        txtCodigoUnico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoUnicoKeyTyped(evt);
            }
        });

        txtTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelefonoFocusLost(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        cmbTipoCuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pasajero", "Conductor" }));
        cmbTipoCuenta.setSelectedIndex(-1);
        cmbTipoCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoCuentaActionPerformed(evt);
            }
        });

        jLabel1.setText("Tipo de cuenta");

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        psswdContraseniaR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psswdContraseniaRActionPerformed(evt);
            }
        });
        psswdContraseniaR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                psswdContraseniaRKeyTyped(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(235, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCodigoUnico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(120, 120, 120)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombre)
                                    .addComponent(txtApellido)
                                    .addComponent(txtCodigoUnico)
                                    .addComponent(txtTelefono)
                                    .addComponent(txtCorreo)
                                    .addComponent(cmbTipoCuenta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(psswdContraseniaR, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(btnRegistrar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(377, 377, 377)
                        .addComponent(btnRegresar)))
                .addGap(153, 153, 153))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(btnRegresar)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCodigoUnico)
                    .addComponent(txtCodigoUnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContrasenia)
                    .addComponent(psswdContraseniaR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(51, 51, 51)
                .addComponent(btnRegistrar)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void habilitarRegistro(){
        if(!txtNombre.getText().isEmpty() && !txtApellido.getText().isEmpty()
                && !txtTelefono.getText().isEmpty() 
                && !txtCorreo.getText().isEmpty() 
                && !psswdContraseniaR.getText().isEmpty()&& !txtCodigoUnico.getText().isEmpty()){
            cmbTipoCuenta.setEnabled(true);
        }
    }
    

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:

        correo = txtCorreo.getText();
        contrasenia = new String(psswdContraseniaR.getPassword());
        nombre = txtNombre.getText();
        apellido = txtApellido.getText();
        codigoUnico = Integer.parseInt(txtCodigoUnico.getText());
        telefono = txtTelefono.getText();
        nuevoUsuario = new Usuario(nombre, apellido, telefono, codigoUnico);
        tipoCuenta = cmbTipoCuenta.getSelectedItem().toString();
        Cuenta cuentaPasajero = null;
        if (tipoCuenta.equals("Pasajero")) {
            cuentaPasajero = new Pasajero(correo, contrasenia, nuevoUsuario, 0.0);
            SqlUsuario modSql = new SqlUsuario();
            try {
                if ((modSql.registrarUsuario(nuevoUsuario))) {
                    if ((modSql.registrarPasajero(nuevoUsuario, cuentaPasajero, tipoCuenta))) {
                        JOptionPane.showMessageDialog(null, "Pasajero registrado exitosamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        JFLogin login = new JFLogin();
                        login.setVisible(true);
                        this.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo registrar pasajero", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo registrar pasajero", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JFVehiculo jfvehiculo = new JFVehiculo();
            jfvehiculo.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void psswdContraseniaRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psswdContraseniaRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_psswdContraseniaRActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        JFLogin login = new JFLogin();
        login.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
        // TODO add your handling code here:
        RestriccionDominio restriccionDominio = new RestriccionDominio();
        if (restriccionDominio.validarDominio(txtCorreo.getText()) == true) {
            this.psswdContraseniaR.setEnabled(true);
            this.psswdContraseniaR.requestFocus();
        } else {
            JOptionPane.showMessageDialog(rootPane, "El correo ingresado no es valido, debe tener el formato: nombre.apellido@epn.edu.ec");
            txtCorreo.requestFocus();
        }

    }//GEN-LAST:event_txtCorreoFocusLost

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        char validacion1 = evt.getKeyChar();
        if(Character.isDigit(validacion1)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo se permiten letras");
        }
        habilitarRegistro();    
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        // TODO add your handling code here:
        char validacion1 = evt.getKeyChar();
        if(Character.isDigit(validacion1)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo se permiten letras");
        }
        txtCodigoUnico.setEnabled(true);
        //txtCodigoUnico.requestFocus();
        habilitarRegistro();    
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtCodigoUnicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoUnicoKeyTyped
        // TODO add your handling code here:
             char validacion1 = evt.getKeyChar();
        if(Character.isLetter(validacion1)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo se permiten números con una longitud de nueve dígitos");
        }
        if(txtCodigoUnico.getText().length()==9){
                evt.consume();
                getToolkit().beep();
                this.txtTelefono.setEnabled(true);
                this.txtTelefono.requestFocus();

        }        

        habilitarRegistro();    
    }//GEN-LAST:event_txtCodigoUnicoKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
            char validacion1=evt.getKeyChar();
        if(Character.isLetter(validacion1)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo se permiten Numeros");
        }
        if(txtTelefono.getText().length()==10){
            evt.consume();
            getToolkit().beep();
            this.txtCorreo.setEnabled(true);
            this.txtCorreo.requestFocus();
        }        
        habilitarRegistro();    
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void psswdContraseniaRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_psswdContraseniaRKeyTyped
        // TODO add your handling code here:
        habilitarRegistro();
    }//GEN-LAST:event_psswdContraseniaRKeyTyped

    private void cmbTipoCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoCuentaActionPerformed
        // TODO add your handling code here:
            String tipoEmpleado = cmbTipoCuenta.getSelectedItem().toString();
        if ("Conductor".equals(tipoEmpleado)) {
            cmbTipoCuenta.setEnabled(false);
            btnRegistrar.setEnabled(true);
        } else if ("Pasajero".equals(tipoEmpleado)) {
            btnRegistrar.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Elija un tipo de cuenta");
        }
        habilitarRegistro(); 
        btnRegistrar.setVisible(true);
    }//GEN-LAST:event_cmbTipoCuentaActionPerformed

    private void txtCodigoUnicoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoUnicoFocusLost
          
    }//GEN-LAST:event_txtCodigoUnicoFocusLost

    private void txtTelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoFocusLost

    }//GEN-LAST:event_txtTelefonoFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cmbTipoCuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCodigoUnico;
    private javax.swing.JLabel lblContrasenia;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JPasswordField psswdContraseniaR;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCodigoUnico;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
