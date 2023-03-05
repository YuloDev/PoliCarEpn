package modelo.ranking;

import javax.swing.JOptionPane;

public class Comentario {

    private String contenido = "";
    private RestriccionComentario restriccionComentario;

    public Comentario() {
        this.restriccionComentario = new RestriccionComentario();
    }

    public void ingresar(String contenido) {
        if (restriccionComentario.validarComentario(contenido)) {
            this.contenido = contenido;
        }
    }

    public String getContenido() {
        return contenido;
    }

}
