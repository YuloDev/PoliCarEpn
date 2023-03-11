
package modelo.usuarios;

import modelo.ranking.Evaluacion;
import modelo.reservacion.ListaReservacion;
import modelo.viaje.ListaViaje;

public abstract class Cuenta {    
    
    protected String correo;
    protected String contraseña;
    protected Evaluacion evaluacion;
    protected RestriccionDominio restriccion = new RestriccionDominio();
    protected Usuario usuario;
    protected Vehiculo vehiculo;
    protected ListaViaje listaViaje;
    protected ListaReservacion listaReservacion;
    
    
    public Cuenta(String correo, String contraseña, Usuario usuario) {
       this.correo = correo;
       this.contraseña = contraseña;
       this.usuario=usuario;
       this.evaluacion = new Evaluacion();
       listaViaje = new ListaViaje();
       listaReservacion = new ListaReservacion();
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public RestriccionDominio getRestriccion() {
        return restriccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public ListaViaje getListaViaje() {
        return listaViaje;
    }

    public ListaReservacion getListaReservacion() {
        return listaReservacion;
    }

    public boolean validarCredenciales(String correo, String contraseña){
        boolean validador = false;
        if((this.correo.equals(correo)) && (this.contraseña.equals(contraseña))){
            
            validador = true;
        }else{
            validador = false;
            //System.out.println("Incorrecto");
        }
        return validador;
    }
    
    @Override
    public String toString() {
        return "Cuenta{" + "correo=" + correo + ", contraseña=" + contraseña + ", usuario=" + usuario + '}';
    }
    
    
}
