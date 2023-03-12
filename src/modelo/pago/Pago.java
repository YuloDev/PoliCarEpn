/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.pago;

import modelo.pago.Factura;
import modelo.reservacion.ControladorTiempoDeReserva;

/**
 *
 * @author Kevin
 */
public abstract class Pago {

    Factura factura;
    protected ControladorTiempoDeReserva controlador;
    protected boolean estaPagado;
    protected Creditos creditos;

    public Pago(Factura factura, Creditos creditos) {
        this.factura = factura;
        this.creditos = creditos;
    }

    // método polimorfico implementado en los hijos
    private boolean realizarPago() {
        return false;
    }

    public ControladorTiempoDeReserva getControlador() {
        return controlador;
    }

    public boolean isEstaPagado() {
        return estaPagado;
    }
    
    

}
