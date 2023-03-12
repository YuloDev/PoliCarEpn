package modelo.ranking;

import modelo.viaje.Viaje;

public class CalificacionExperiencia extends Calificacion {

    private Comentario comentario;

    public CalificacionExperiencia(Viaje viaje) {
        super(viaje);
        this.comentario = new Comentario();
    }

    public void agregarComentario(String comentario, String tipo) {
        this.comentario.ingresar(comentario, tipo);
    }

    public Comentario getComentario() {
        return comentario;
    }

}
