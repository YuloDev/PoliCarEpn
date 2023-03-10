/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.usuarios;

import modelo.usuarios.Cuenta;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.plaf.RootPaneUI;

public class Usuario {
    protected String nombre;
    protected String apellido;
    protected String telefono;
    protected int codUnico;
    Cuenta cuenta;



    public Usuario(String nombre, String apellido, String telefono, int codUnico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.codUnico = codUnico;     
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCodUnico() {
        return codUnico;
    }

    public void setCodUnico(int codUnico) {
        this.codUnico = codUnico;
    }
    
    
    public boolean iniciarSesion(String correo, String contraseña, Cuenta cuenta){
        this.cuenta = cuenta;
        return this.cuenta.validarCredenciales(correo, contraseña);
    }
    
    
    public void cerrarSesion(){
        JOptionPane.showMessageDialog(null, "Adios", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }
    
    @Override
    public String toString() {
        return "Usuario " 
                + "\nNombre: " + nombre 
                + "\nApellido: " + apellido 
                + "\nTelefono: " + telefono  
                + "\nCodigo Unico: " + codUnico;  

    }
    
    
    
    
}
