package modelo.ranking;

public class Comentario {

    private String contenido = "";
    private RestriccionComentario restriccionComentario;
    private String tipo;

    public Comentario() {
        this.restriccionComentario = new RestriccionComentario();
    }

    public void ingresar(String contenido, String tipo) {
        if (restriccionComentario.validarComentario(contenido)) {
            this.contenido = contenido;
            this.tipo = tipo;
        }
    }

    public String getContenido() {
        return contenido;
    }

    public String getTipo() {
        return tipo;
    }
}
