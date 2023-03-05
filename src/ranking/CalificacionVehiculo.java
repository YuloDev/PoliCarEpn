package ranking;

import usuarios.Conductor;
import viaje.Viaje;

public class CalificacionVehiculo extends Calificacion {

    public CalificacionVehiculo(double puntuacion) {
        super(puntuacion);
    }
    
    public CalificacionVehiculo(Viaje viaje) {
        super(viaje);
    }

}
