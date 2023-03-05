
import java.time.LocalDateTime;


public class Fecha {
    private LocalDateTime localDateTime;

    public Fecha() {
        this.localDateTime = LocalDateTime.now();
    }
    
    public LocalDateTime determinarTiempoActual(){
        return LocalDateTime.now();
    }
    
}
