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

    public LocalDateTime determinarTiempoActual() {
        fechaYHora = LocalDateTime.now();
        return fechaYHora;
    }

    public void sumarDias(int dias) {
        this.fechaYHora = this.fechaYHora.plusDays(dias);
    }

    public boolean compararFechaActual() {
        if (LocalDateTime.now().isAfter(this.fechaYHora)) {
            return true;
        } else {
            return false;
        }
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public int obtenerAñoActual() {
        return LocalDateTime.now().getYear();
    }

}
