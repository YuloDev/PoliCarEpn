/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.pago;

import modelo.pago.*;
import modelo.reservacion.ControladorTiempoDeReserva;

/**
 *
 * @author Kevin
 */
public class PagoTransferencia extends Pago{
    public double valorTotal;
    public BilleteraPoliCar billetera = new BilleteraPoliCar();
 
    
    public PagoTransferencia(Factura factura, Creditos creditos) {
        super(factura, creditos);
        controlador = new ControladorTiempoDeReserva(factura.reservacion,20*60*1000);
        factura.calcularTotal();
        this.valorTotal = factura.valorTotal;
    }
    
    public boolean realizarPago(){
        double valorxPagar = super.creditos.getSaldo();
        if(factura.valorTotal <= valorxPagar){
            if (billetera.aumentarSaldo(valorxPagar)){
                estaPagado = true;
            }
        }
        return estaPagado;
    }
    
}
