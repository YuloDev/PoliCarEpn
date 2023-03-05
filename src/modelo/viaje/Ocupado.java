package modelo.viaje;

import modelo.viaje.Estado;

public class Ocupado implements Estado {
    @Override
    public boolean solicitar() {
        return false;
    }
}
