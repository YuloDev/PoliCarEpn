package viaje;

public class Asiento {

    private double precio;
    private Estado estado;

    public Asiento(double precio) {
        this.precio = precio;
        this.estado = new Libre();
    }

    public final void actualizarEstado() {
        estado = new Ocupado();
        System.out.println("Asiento reservado");
    }
    public double getPrecio() {
        return precio;
    }


}
