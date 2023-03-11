package modelo.externo;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Fecha {
    private LocalDateTime fechaYHora;

    public Fecha() {
        this.fechaYHora = LocalDateTime.now();
    }
    
    public Fecha(String fecha) {
        this.fechaYHora = LocalDateTime.parse(fecha, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    
    public LocalDateTime determinarTiempoActual(){
        fechaYHora = LocalDateTime.now();
        return fechaYHora;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }
    
    public int obtenerAñoActual(){
        return LocalDateTime.now().getYear();
    }
    
}
