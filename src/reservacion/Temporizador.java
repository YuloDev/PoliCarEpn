/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reservacion;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Cesar
 */
public class Temporizador extends TimerTask{
    private Timer timer;
    private ControladorTiempoDeReserva controlador;

    public Temporizador(long tiempoRestante) {
        
        this.timer = new Timer();
        this.timer.schedule(this, tiempoRestante);
    }

    @Override
    public void run() {
        timer.cancel();
        controlador.controlarTiempoVencido();
    }

    public Timer getTimer() {
        return timer;
    }

    public ControladorTiempoDeReserva getControlador() {
        return controlador;
    }
    
    
}
