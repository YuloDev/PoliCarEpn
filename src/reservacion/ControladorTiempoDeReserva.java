/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reservacion;

/**
 *
 * @author Cesar
 */
public class ControladorTiempoDeReserva {
    private Reservacion reservacion;
    private Temporizador temporizador;
    
    
    public ControladorTiempoDeReserva(Reservacion reservacion, long tiempoRestante) {
        this.reservacion = reservacion;
        this.temporizador = new Temporizador(tiempoRestante);
        // Tiempo Restante 20min 20 * 60 * 1000
    }
    
    public void controlarTiempoVencido() {
        reservacion.cancelar();
    }

    public Reservacion getReservacion() {
        return reservacion;
    }

    public Temporizador getTemporizador() {
        return temporizador;
    }
    
}
