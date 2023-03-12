
package modelo.usuarios;

import modelo.ranking.Calificacion;
import modelo.ranking.CalificacionConductor;
import modelo.ranking.CalificacionExperiencia;
import modelo.ranking.CalificacionVehiculo;
import modelo.ranking.Evaluacion;
import modelo.ranking.Penalizacion;
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
    protected Penalizacion penalizacion;
    
    
    public Cuenta(String correo, String contraseña, Usuario usuario) {
       this.correo = correo;
       this.contraseña = contraseña;
       this.usuario=usuario;
       this.evaluacion = new Evaluacion();
       this.listaViaje = new ListaViaje();
       this.listaReservacion = new ListaReservacion();
       this.penalizacion = new Penalizacion(evaluacion);
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

    public Penalizacion getPenalizacion() {
        return penalizacion;
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

    public void calificarViaje(Calificacion ... calificaciones) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
