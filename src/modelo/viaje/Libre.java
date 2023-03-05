package modelo.viaje;

import modelo.viaje.Estado;

public class Libre implements Estado {
    @Override
    public boolean solicitar() {
        return true;
    }
}
