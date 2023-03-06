package modelo.ranking;

import modelo.viaje.Viaje;

public class CalificacionExperiencia extends Calificacion {

    private Comentario comentario;

    public CalificacionExperiencia(Viaje viaje) {
        super(viaje);
        this.comentario = new Comentario();
    }

    public void agregarComentario(String comentario) {
        this.comentario.ingresar(comentario);
    }

    public Comentario getComentario() {
        return comentario;
    }

    @Override
    public String toString() {
        return "CalificacionExperiencia{" + "comentario=" + comentario + '}';
    }

}
