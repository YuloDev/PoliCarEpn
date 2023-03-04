/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios;

import java.util.Scanner;

public class Usuario {
    protected String nombre;
    protected String apellido;
    protected String telefono;
    protected int codUnico;
    Cuenta cuenta;

    //RestriccionDominio restriccionDominio; no se usa


    public Usuario(String nombre, String apellido, String telefono, int codUnico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.codUnico = codUnico;
        //this.correo = correo;
       // this.contraseña = contraseña;
        
    }
    public boolean iniciarSesion(String correo, String contraseña, Cuenta cuenta){
        this.cuenta = cuenta;
        return this.cuenta.validarCredenciales(correo, contraseña);
    }
    
    
    public void cerrarSesion(String correo, String contraseña){
        System.out.println("Adios");
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
