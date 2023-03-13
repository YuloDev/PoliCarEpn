package modelo.viaje;

public class ListaViaje {

    private Viaje[] viajes;

    public ListaViaje() {
        this.viajes = new Viaje[100];
    }

    public void añadirViaje(Viaje viaje) {
        for (int i = 0; i < viajes.length; i++) {
            if (viajes[i] == null) {
                viajes[i] = viaje;
                return;
            }
        }
        System.out.println("Máximo ");
    }

    public void quitarViaje(Viaje viaje) {
        for (int i = 0; i < viajes.length; i++) {
            if (viajes[i] != null) {
                if (viajes[i].equals(viaje)) {
                    viajes[i] = null;
                    return;
                }
            }

        }
        System.out.println(" no se encuentra");
    }

    public Viaje[] getViajes() {
        return viajes;
    }

}
