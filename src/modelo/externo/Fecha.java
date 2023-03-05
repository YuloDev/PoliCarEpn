package modelo.externo;


import java.time.LocalDateTime;


public class Fecha {
    private LocalDateTime fechaYHora;

    public Fecha() {
        this.fechaYHora = LocalDateTime.now();
    }
    
    public LocalDateTime determinarTiempoActual(){
        fechaYHora = LocalDateTime.now();
        return fechaYHora;
    }
    
}
