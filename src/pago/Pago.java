/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pago;

import reservacion.ControladorTiempoDeReserva;

/**
 *
 * @author Kevin
 */
public abstract class Pago {
    Factura factura;
    protected ControladorTiempoDeReserva controlador;

    public Pago(Factura factura) {
        this.factura = factura;
    }
    
    // método polimorfico implementado en los hijos
    private void realizarPago(){
        
    }
}
