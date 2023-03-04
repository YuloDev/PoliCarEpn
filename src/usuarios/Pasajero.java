
package usuarios;


public class Pasajero extends Cuenta {
    public Reservacion reservacion;

    public Pasajero(String correo, String contraseña, Usuario usuario) {
        super(correo, contraseña, usuario);
    }

    public Pasajero(String correo, String contraseña, Usuario usuario, Vehiculo vehiculo) {
        super(correo, contraseña, usuario);
        this.vehiculo = vehiculo;
    }

    public void crearReservacion(Reservacion nuevaReservacion) {
        this.reservacion = nuevaReservacion;
        nuevaReservacion.calcularPrecioReservacion();
    }

    public void cancelarReservacion() {
        //Codigo de cancelar reservacion
    }

    public void calificarViaje() {
        //codigo calificar viaje
    }

    public Conductor cambiarCuenta(Pasajero pasajero) {
        Conductor conductor;
        if (pasajero.vehiculo == null) {//verifica si el pasajero posee un vehiculo y lo crea
            //Gui ingresar vehiculo
            conductor = new Conductor(this.correo, this.contraseña, this.usuario, new Vehiculo("PDB1856", "AVEO", "azul", 2010, 4));
            System.out.println("Registro exitoso");
        } else {//si ya tiene vehiculo solo cambia a conductor
            conductor = new Conductor(this.correo, this.contraseña, this.usuario, this.vehiculo);
            System.out.println("Se ha cambiado a conductor");
        }
        return conductor;
    }

    @Override
    public String toString() {
        return usuario.toString()
                + "\nPasajero";
    }


}
