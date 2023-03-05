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
public class PagoTransferencia extends Pago{
    
    private BilleteraPoliCar billetera = new BilleteraPoliCar();
    
    public PagoTransferencia(Factura factura) {
        super(factura);
        controlador = new ControladorTiempoDeReserva(factura.reservacion,20*60*1000);
    }
    
    public boolean realizarPago(){
        return billetera.aumentarSaldo(factura.valorTotal);
    }
    
}
