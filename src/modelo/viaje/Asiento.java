package modelo.viaje;

public class Asiento {

    private double precio;
    private Estado estado;

    public Asiento(double precio) {
        this.precio = precio;
        this.estado = new Libre();
    }

    public final void actualizarEstado() {
        if (estado instanceof Libre){
            estado = new Ocupado();
             System.out.println("Asiento reservado");
        } else {
            estado = new Libre();
            System.out.println("Asiento liberado");
        }
    }
    
    public boolean solicitar(){
        return estado.solicitar();
    }
    
    public double getPrecio() {
        return precio;
    }

    public Estado getEstado() {
        return estado;
    }


}
