package ranking;


public class RestriccionComentario {

    private static final int limiteDeCaracteres = 300; // Poner el limite de palabras

    public RestriccionComentario() {
    }

    public static boolean validarComentario(String comentario) {
        if (!(comentario.length() <= limiteDeCaracteres)) {
            // Se excede el limite de caracteres y  se pide que corrija
            return false;
        }
        return true;
    }
}
