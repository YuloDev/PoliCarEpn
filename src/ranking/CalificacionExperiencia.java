package ranking;

import usuarios.Conductor;
import viaje.Viaje;


public class CalificacionExperiencia extends Calificacion{
    private Comentario comentario;

    public CalificacionExperiencia( Viaje viaje) {
        super(viaje);
        this.comentario = new Comentario();
    }
    
    public void agregarComentario(String comentario){
        this.comentario.ingresar(comentario);
    }
    
    @Override
    public void mostrar(){
        System.out.println("La calificacion es:" + this.comentario.getContenido());
        System.out.println("La comentario es:" + this.comentario.getContenido());
    }

    public Comentario getComentario() {
        return comentario;
    }

    @Override
    public String toString() {
        return "CalificacionExperiencia{" + "comentario=" + comentario + '}';
    }
    
}
