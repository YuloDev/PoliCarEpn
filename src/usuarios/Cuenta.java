/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios;

import viaje.Viaje;

/**
 *
 * @author Gustavo
 */
public abstract class Cuenta {    
    
    protected String correo;
    protected String contraseña ;
    protected Viaje[] viajes;
    Usuario usuario;
    //RestriccionDominio restriccion = new RestriccionDominio();
    Vehiculo vehiculo;   
        
    public Cuenta(String correo, String contraseña, Usuario usuario) {
       this.correo = correo;
       this.contraseña = contraseña;
       this.usuario=usuario;
    }
    
        

    public boolean validarCredenciales(String correo, String contraseña){
        boolean validador = false;
        if((this.correo.equals(correo)) && (this.contraseña.equals(contraseña))){
            System.out.println("Bienvenido "+ correo);
            validador = true;
        }else{
            validador = false;
            System.out.println("Incorrecto");
        }
        return validador;
    }
    
    public void eliminarCuenta(){
        //Con un delete se eliminaria la cuenta
    }
    
    public void cambiarCuenta(){
        //metodo polimorfico
    }
    

    @Override
    public String toString() {
        return "Cuenta{" + "correo=" + correo + ", contraseña=" + contraseña + ", usuario=" + usuario + '}';
    }
    
    
}
