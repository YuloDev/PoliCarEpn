
package usuarios;

import ranking.Evaluacion;
import reservacion.ListaReservacion;
import viaje.Viaje;

public abstract class Cuenta {    
    
    protected String correo;
    protected String contraseña ;
    protected Viaje[] viajes;
    Usuario usuario;
    //RestriccionDominio restriccion = new RestriccionDominio();
    Vehiculo vehiculo;
    protected ListaReservacion listaReservacion;
    protected Evaluacion evaluacion;
    
    public Cuenta(String correo, String contraseña, Usuario usuario) {
       this.correo = correo;
       this.contraseña = contraseña;
       this.usuario=usuario;
       this.evaluacion = new Evaluacion();
       listaReservacion = new ListaReservacion();
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

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "correo=" + correo + ", contraseña=" + contraseña + ", usuario=" + usuario + '}';
    }
    
    
}
