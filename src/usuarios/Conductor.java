package usuarios;


import viaje.Viaje;

public class Conductor extends Cuenta {

    Vehiculo vehiculo;


    public Conductor(String correo, String contraseña, Usuario usuario, Vehiculo vehiculo) {
        super(correo, contraseña, usuario);
        this.vehiculo = vehiculo;
        super.viajes = new Viaje[10];
    }

    public void crearViaje(Viaje nuevoViaje) {

        Viaje[] nuevoArreglo = new Viaje[viajes.length + 1];
        System.arraycopy(viajes, 0, nuevoArreglo, 0, viajes.length);
        nuevoArreglo[nuevoArreglo.length - 1] = nuevoViaje;
        viajes = nuevoArreglo;
    }

    public void cancelarViaje() {
        //Todo:codigo para cancelar viaje
    }

    public Pasajero cambiarCuenta(Conductor conductor) {
        Pasajero pasajero = new Pasajero(this.correo, this.contraseña, this.usuario, this.vehiculo);
        return pasajero;
    }

    public int obtenerCantidadAsientos() {
        return vehiculo.getNumeroAsientos();
    }


    @Override
    public String toString() {


        return usuario.toString() + "\nConductor " + "\n" + vehiculo.mostrarInfo();
    }


}
